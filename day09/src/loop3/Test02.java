package loop3;

import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
		// Test01을 while문으로 구현

		// ex : 사용자에게 점수(1~100점)를 입력받는 코드 구현. 잘못 입력하면 다시 입력하도록 처리
		Scanner sc = new Scanner(System.in);

		int score;
		while (true) {
			System.out.println("점수 입력");
			score = sc.nextInt();

			if (score >= 0 && score <= 100) {// 점수가 정상적으로 입력되었다면(0점 이상 100점 이하)
				break;
			}
		}

		sc.close();
	}
}
