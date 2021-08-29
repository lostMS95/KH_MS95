package random;

import java.util.Random;
import java.util.Scanner;

public class Test03_1 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random r = new Random();

		System.out.println("몇단까지 설정?");
		int num = sc.nextInt();
		System.out.println("얼마까지 설정?");
		int num2 = sc.nextInt();

		System.out.println("랜덤한 구구단 출력!!");
		int gugu = r.nextInt(num) + 1;
		int gugu2 = r.nextInt(num2) + 1;

		System.out.print(gugu + " X " + gugu2 + " = ");
		int ans = sc.nextInt();

		if (ans == (gugu * gugu2)) {
			System.out.println("정답입니다");
		} else {
			System.out.println("오답입니다.");
		}

		sc.close();

	}
}
