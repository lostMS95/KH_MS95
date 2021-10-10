package jdbc.test;

import jdbc.beans.MemberDao;
import jdbc.beans.MemberDto;

public class Test21 {
	public static void main(String[] args) throws Exception {
		//회원 검색
		
		String memberId = "test1111";
		
		MemberDao memberDao = new MemberDao();
		MemberDto memberDto = memberDao.select(memberId);
		
		if(memberDto == null) {
			System.out.println("해당하는 정보가 없습니다.");
		}
		else {
			System.out.print(memberDto.getMemberId() +"/");
			System.out.print(memberDto.getMemberNick() +"/");
			System.out.print(memberDto.getBirthDate() +"/");
			System.out.print(memberDto.getMemberEmail() +"/");
			System.out.print(memberDto.getMemberPhone() +"/");
			System.out.print(memberDto.getMemberJoin() +"/");
			System.out.print(memberDto.getMemberPoint() +"/");
			System.out.println(memberDto.getMemberGrade());
		}
	}
}
