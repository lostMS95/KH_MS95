package jdbc.test;

import java.util.Scanner;

import jdbc.beans.MemberDao;

public class Test11 {
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 아이디 입력 : ");
		String id = sc.nextLine();
		sc.close();

		MemberDao memberDao = new MemberDao();
		boolean result = memberDao.delete(id);

		if (result) {
			System.out.println("회원 탈퇴 처리가 완료되었습니다");
		} else {
			System.out.println("존재하지 않는 회원입니다");
		}
	}
}
