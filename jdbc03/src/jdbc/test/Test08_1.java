package jdbc.test;

import jdbc.beans.MemberDao;

public class Test08_1 {
	public static void main(String[] args) throws Exception {
		
		String memberId = "test1112";
		String memberPw = "test1111";
		String changePw = "testuser0000";
		
		MemberDao memberDao = new MemberDao();
		boolean success = memberDao.editPassword(memberId, memberPw, changePw);
		
		if(success) {
			System.out.println("비밀번호 변경이 완료되었습니다");
		}
		else {
			System.out.println("정보가 일치하지 않습니다");
		}
		
	}
}
