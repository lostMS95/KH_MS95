package jdbc.test;

import java.util.Scanner;

import jdbc.beans.MemberDao;
import jdbc.beans.MemberDto;

public class Test03_1 {
	public static void main(String[] args) throws Exception {
		// 회원 가입 프로그램

		// 입력 : 회원 정보
		Scanner sc = new Scanner(System.in);
		MemberDto memberDto = new MemberDto();

		System.out.print("ID : ");
		memberDto.setMemberId(sc.nextLine());

		System.out.print("Password : ");
		memberDto.setMemberPw(sc.nextLine());

		System.out.print("Nickname : ");
		memberDto.setMemberNick(sc.nextLine());

		System.out.print("Birth : ");
		memberDto.setMemberBirth(sc.nextLine());

		System.out.print("Email : ");
		memberDto.setMemberEmail(sc.nextLine());

		System.out.print("Mobile : ");
		memberDto.setMemberPhone(sc.nextLine());

		sc.close();

		// 처리 : 등록
		MemberDao memberDao = new MemberDao();
		memberDao.insert(memberDto);

		// 출력
		System.out.println("회원 가입 완료");
	}
}