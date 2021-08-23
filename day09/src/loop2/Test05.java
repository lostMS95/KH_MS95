package loop2;

import java.util.Scanner;

public class Test05 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("도전 할 단 입력 : ");

		int dan = sc.nextInt();
		int score = 0;
		int failCount = 0;
		int combo = 0;

		int i = 1;
		while (true) {
			System.out.print(dan + " X " + i + " = ");
			int ans = sc.nextInt();

			if (dan * i == ans) {
				i++;
				combo++;
				System.out.println(combo + "콤보!");
				score += combo * 100;

			} else {
				System.out.println("땡");
				failCount++;
				combo = 0;

				if (failCount == 3) {
					System.out.println(failCount + "번째 틀렸습니다.");
					break;

				}
			}
		}
		System.out.println("Game Over!");
		System.out.println("획득 점수 : " + score + "점");
		sc.close();
	}
}
