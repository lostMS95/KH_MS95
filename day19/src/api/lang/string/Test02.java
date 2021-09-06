package api.lang.string;

import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("아이디 입력 : ");
		String id = sc.next();
		System.out.println("비밀번호 입력 : ");
		String password = sc.next();

		if (id.equalsIgnoreCase("admin") && password.equals("master")) {

			System.out.println("관리자 로그인 되었습니다.");
		} else {
			System.out.println("정보가 일치하지 않습니다.");
		}
		sc.close();
	}
}
