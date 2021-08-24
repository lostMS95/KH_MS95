package loop4;

import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("시작 숫자 입력 : ");
		int num = sc.nextInt();
		System.out.println("종료 숫자 입력 : ");
		int num2 = sc.nextInt();

		int total = 0;

		for (int j = num; j <= num2; j++) {
			for (int i = j; i > 0; i /= 10) {
				int n = i % 10;

				if (n == 3 || n == 6 || n == 9) {
					total++;
				}
			}
		}
		System.out.println(total);
		sc.close();

	}
}
