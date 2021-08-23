package loop2;

import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int matchCount = 0;
		int oddCount = 0;

		while (true) {
			System.out.println("숫자 입력 : ");
			int num = sc.nextInt();

			if (num == 0) {
				System.out.println("그만!");
				break;
			} else {
				if (num % 2 == 0) {
					matchCount++;
				} else {
					oddCount++;
				}
			}
		}
		System.out.println("짝 개수 " + matchCount);
		System.out.println("홀 개수 " + oddCount);
		sc.close();
	}
}
