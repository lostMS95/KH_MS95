package jdbc.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jdbc.util.JdbcUtils;

//member 테이블에 접근하는 객체
public class MemberDao {
	
	//[1] 회원가입 메소드
	public void insert(MemberDto memberDto) throws Exception {
		Connection con = JdbcUtils.connect("kh", "kh");
		
		String sql ="insert into member values(?, ?, ?, to_date(?, 'YYYY-MM-DD'), ?, ?, sysdate, 100, '준회원')";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, memberDto.getMemberId());
		ps.setString(2, memberDto.getMemberPw());
		ps.setString(3, memberDto.getMemberNick());
		ps.setString(4, memberDto.getMemberBirth());
		ps.setString(5, memberDto.getMemberEmail() );
		ps.setString(6, memberDto.getMemberPhone());
		ps.execute();
		con.close();
		
	}
}
