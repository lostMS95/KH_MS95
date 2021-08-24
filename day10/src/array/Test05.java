package array;

import java.util.Scanner;

public class Test05 {
	public static void main(String[] args) {

		String[] name = new String[5];

		Scanner sc = new Scanner(System.in);
		System.out.println("이름 5개 입력 : ");

		for (int i = 0; i < 5; i++) {
			name[i] = sc.next();
		}
		for (int i = 0; i < 5; i++) {
			System.out.println(i + "번째 이름 : " + name[i]);
		}

		sc.close();
	}
}
