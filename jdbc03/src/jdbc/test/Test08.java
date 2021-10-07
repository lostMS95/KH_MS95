package jdbc.test;

import java.util.Scanner;

import jdbc.beans.MemberDao;
import jdbc.beans.MemberDto;

public class Test08 {
	public static void main(String[] args) throws Exception {

		// 입력 : 현재아이디, 현재비밀번호, 바꿀비밀번호
		// [1] String + String + String
		// [2] MemberDto + String

		Scanner sc = new Scanner(System.in);

		MemberDto memberDto = new MemberDto();
		System.out.print("아이디 입력 : ");
		memberDto.setMemberId(sc.nextLine());
		System.out.print("기존 비밀번호 입력 : ");
		memberDto.setMemberPw(sc.nextLine());
		String changePw = "test1115";

		sc.close();

		MemberDao memberDao = new MemberDao();
		boolean success = memberDao.editPassword(memberDto, changePw);

		if (success) {
			System.out.println("비밀번호 변경이 완료되었습니다");
		} else {
			System.out.println("정보가 일치하지 않습니다");
		}

	}
}
