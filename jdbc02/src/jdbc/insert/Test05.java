package jdbc.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;


public class Test05 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
		//사용자에게 필요한 정보를 입력받아서 product 테이블에 데이터를 등록하는 프로그램을 구현
		//문제 없이 등록이 되었다면 마지막에 "등록 성공!" 이라는 메세지 출력
		
		
		// 준비 : 등록에 필요한 데이터
//		String name = "메로나튜브";
//		String type = "아이스크림";
//		int price = 1200;
//		String made = "2021-10-04";
//		String expire = "2022-04-03";

		// 처리 : 데이터베이스 등록
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh", "kh");

		String sql = "insert into product values(" 
				+ "product_seq.nextval," 
				+ "'메로나튜브'," 
				+ "'아이스크림'," 
				+ "1200,"
				+ "to_date('2021-10-04', 'YYYY-MM-DD')," 
				+ "to_date('2022-04-03', 'YYYY-MM-DD')" 
				+ ")";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.execute();

		con.close();
		// 완료 : 메세지 출력
		System.out.println("등록 완료!");
	}
}