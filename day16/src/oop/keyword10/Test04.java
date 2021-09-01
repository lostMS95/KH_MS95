package oop.keyword10;

import java.util.Random;

public class Test04 {
	public static void main(String[] args) {
		// Q : 랜덤으로 가위바위보 중 하나를 출력
		// = 랜덤으로는 정수를 추첨할 수 있다.
		// = 문자열은 어떻게?

		Random r = new Random();
		int com = r.nextInt(RSP.RANGE) + RSP.START;

		switch (com) {
		case RSP.SCISSORS:
			System.out.println("가위!");
			break;
		case RSP.ROCK:
			System.out.println("바위!");
			break;
		case RSP.PAPER:
			System.out.println("보!");
			break;
		}

	}
}