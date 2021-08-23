package loop;

import java.util.Scanner;

public class Test16 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 입력 : ");
		int num = sc.nextInt();
		sc.close();

		int count = 0;

		for (int i = 1; i <= num; i++) {
			System.out.println(num + " % " + i + " = " + num % i);

			if (num % i == 0) {
				count++;

			}
		}
		if (count == 2) {
			System.out.println(num + "은 소수입니다");
		} else if (count > 2) {
			System.out.println("소수가 아닙니다");
		} else {
			System.out.println(num + "은 어디에도 해당되지 않습니다");
		}

	}
}
