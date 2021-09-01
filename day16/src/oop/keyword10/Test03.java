package oop.keyword10;

import java.util.Random;

public class Test03 {
	// 객체 없이 편하게 접근할 수 있도록 정적 변수 처리
	public static final int 가위 = 1;
	public static final int 바위 = 2;
	public static final int 보 = 3;

	public static void main(String[] args) {
		// Q : 랜덤으로 가위바위보 중 하나를 출력
		// = 랜덤으로는 정수를 추첨할 수 있다.
		// = 문자열은 어떻게?

		Random r = new Random();
		int com = r.nextInt(3) + 1;// 1부터 3개

		// System.out.println("com = " + com);

		switch (com) {
		// case Test03.가위:
		case 가위:
			System.out.println("가위!");
			break;
		// case Test03.바위:
		case 바위:
			System.out.println("바위!");
			break;
		// case Test03.보:
		case 보:
			System.out.println("보!");
			break;
		}

	}
}