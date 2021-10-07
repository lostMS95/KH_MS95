package jdbc.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc.util.JdbcUtils;

//product 테이블 관련된 CRRUD 처리 클래스
public class ProductDao {

	public static final String USERNAME = "kh";
	public static final String PASSWORD = "kh";

	// 등록 메소드
	// = insert into product values(상품번호, 상품명, 상품분류, 상품가격, 제조일, 유통기한)
	// = insert into product values(product_seq.nextval, ?, ?, ?, to_date(?,
	// 'YYYY-MM-DD'), to_date(?, 'YYYY-MM-DD'))

	public void insert(String name, String type, int price, String made, String expire) throws Exception {
		Connection con = JdbcUtils.connect("kh", "kh");

		String sql = "insert into product values(product_seq.nextval, ?,?,?,to_date(?, 'YYYY-MM-DD'),to_date(?, 'YYYY-MM-DD'))";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, type);
		ps.setInt(3, price);
		ps.setString(4, made);
		ps.setString(5, expire);
		ps.execute();

		con.close();

	}

	public void insert(ProductDto productDto) throws Exception {
		Connection con = JdbcUtils.connect("kh", "kh");

		String sql = "insert into product values(product_seq.nextval, ?,?,?,to_date(?, 'YYYY-MM-DD'),to_date(?, 'YYYY-MM-DD'))";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, productDto.getName());
		ps.setString(2, productDto.getType());
		ps.setInt(3, productDto.getPrice());
		ps.setString(4, productDto.getMade());
		ps.setString(5, productDto.getExpire());
		ps.execute();
		con.close();
	}

//	전체 정보 수정 메소드
//	= 매개변수 : ProductDto
//	= 반환형 : boolean
	public boolean update(ProductDto productDto) throws Exception {
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		String sql = "update product set name = ?, type = ?, price = ?, made = to_date(?,'YYYY-MM-DD'), expire = to_date(?,'YYYY-MM-DD') where no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, productDto.getName());
		ps.setString(2, productDto.getType());
		ps.setInt(3, productDto.getPrice());
		ps.setString(4, productDto.getMade());
		ps.setString(5, productDto.getExpire());
		ps.setInt(6, productDto.getNo());
		int result = ps.executeUpdate();

		con.close();

		return result > 0;
	}

//	가격 정보 수정 메소드
//	= 매개변수 : ProductDto(= int + int)
//	= 반환형 : boolean
	public boolean updatePrice(ProductDto productDto) throws Exception {
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		String sql = "update product set price = ? where no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, productDto.getPrice());
		ps.setInt(2, productDto.getNo());

		int result = ps.executeUpdate();

		con.close();

		return result > 0;

	}

//	삭제 메소드
//	= 매개변수 : no(int)
//	= 반환형 : boolean
	public boolean delete(int no) throws Exception {
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		String sql = "delete product where no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, no);
		int result = ps.executeUpdate();

		return result > 0;
	}

//	목록 메소드
//	= select * from product
//	= 매개변수 없음
//	= 반환형은 List<ProductDto>
	public List<ProductDto> select() throws Exception {
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		String sql = "select * from product";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		// rs -- > List copy
		List<ProductDto> list = new ArrayList<>();

		while (rs.next()) {
			ProductDto productDto = new ProductDto();
			productDto.setNo(rs.getInt("no")); // rs.getInt("no") = DB행의 no 컬럼값
			productDto.setName(rs.getString("name"));
			productDto.setType(rs.getString("type"));
			productDto.setMade(rs.getString("made"));
			productDto.setExpire(rs.getString("expire"));

			list.add(productDto);
		}
		con.close();
		return list;

	}

	public List<ProductDto> select(String column, String keyword) throws Exception {

		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);

		String sql = "select * from product where instr(#1, ?) >0 order by #1 asc";
		sql = sql.replace("#1", column);

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, keyword);
		ResultSet rs = ps.executeQuery();

		List<ProductDto> list = new ArrayList<>();

		while (rs.next()) {
			ProductDto productDto = new ProductDto();
			productDto.setNo(rs.getInt("no"));
			productDto.setName(rs.getString("name"));
			productDto.setPrice(rs.getInt("price"));
			productDto.setType(rs.getString("type"));
			productDto.setMade(rs.getString("made"));
			productDto.setExpire(rs.getString("expire"));

			list.add(productDto);
		}
		con.close();
		return list;
	}
}
