package jdbc.test;

import jdbc.beans.MemberDao;
import jdbc.beans.MemberDto;

public class Test03 {
 public static void main(String[] args) throws Exception {
	//회원 가입 프로그램
	 
	 
	//입력 : 회원 정보
		MemberDto memberDto = new MemberDto();
		memberDto.setMemberId("test1111");
		memberDto.setMemberPw("test1111");
		memberDto.setMemberNick("비밀번호");
		memberDto.setMemberBirth("1995-04-15");
		memberDto.setMemberEmail("rmsdn415@naver.com");
		memberDto.setMemberPhone("010-1111-2222");
		

		//처리 : 등록
		MemberDao memberDao = new MemberDao();
		memberDao.insert(memberDto);
		
		//출력
		System.out.println("회원가입 완료.");
		
}
}
