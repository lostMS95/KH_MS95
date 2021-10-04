package jdbc.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//사용자에게 필요한 정보를 입력받아서 exam 테이블에 데이터를 등록하는 프로그램을 구현
		//문제 없이 등록이 되었다면 마지막에 "등록 성공!" 이라는 메세지 출력
		Scanner sc = new Scanner(System.in);

		System.out.print("번호입력");
		int exam_id = sc.nextInt();
		System.out.print("이름입력");
		String student = sc.next();
		System.out.print("과목입력");
		String subject = sc.next();
		System.out.print("유형입력");
		String type = sc.next();
		System.out.print("점수입력");
		int score = sc.nextInt();
		sc.close();

		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh", "kh");

		String sql = "insert into exam values (?, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, exam_id);
		ps.setString(2, student);
		ps.setString(3, subject);// 3번 위치홀더(?)에 menuName을 String형태로 채울거에요!
		ps.setString(4, type);
		ps.setInt(5, score);
		ps.execute();

		con.close();
		System.out.println("등록 성공!");

	}
}
