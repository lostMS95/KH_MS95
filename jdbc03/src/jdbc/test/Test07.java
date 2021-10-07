package jdbc.test;

import java.util.Scanner;

import jdbc.beans.MemberDao;
import jdbc.beans.MemberDto;

public class Test07 {
	public static void main(String[] args) throws Exception {
		
		Scanner sc= new Scanner(System.in);
		
		MemberDto memberDto = new MemberDto();
		memberDto.setMemberNick("로스트엠에스");
		memberDto.setMemberBirth("1987-07-14");
		memberDto.setMemberEmail("lostms@naver.com");
		System.out.print("아이디 입력 : ");
		memberDto.setMemberId(sc.nextLine());
		System.out.print("비번 입력 : ");
		memberDto.setMemberPw(sc.nextLine());
		sc.close();
		
		MemberDao memberDao = new MemberDao();
		boolean success = memberDao.update(memberDto);
		
		if(success) {
			System.out.println("정보 변경이 완료되었습니다.");
		}
		else {
			System.out.println("존재하지 않는 회원 정보입니다");
		}
	}
}
