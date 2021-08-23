package loop;

import java.util.Scanner;

public class Test15 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 입력 : ");
		int num = sc.nextInt();
		sc.close();

		int total = 0;

		for (int i = num; i > 0; i /= 10) {
			int n = i % 10;
			System.out.println(i);
			System.out.println(n);
			if (n == 7) {
				total++;
			}
		}
		System.out.println("입력하신 숫자 " + num + "에는 7이" + total + "개 있습니다");
		}
}
