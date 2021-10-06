package jdbc.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;

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

}
