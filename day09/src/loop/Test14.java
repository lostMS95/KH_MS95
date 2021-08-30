package loop;

import java.util.Scanner;

public class Test14 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("분 입력 : ");
		int min = sc.nextInt();
		System.out.println("초 입력 : ");
		int sec = sc.nextInt();
		sc.close();

		int time = min * 60 + sec; 

		for (int i = time; i >= 0; i--) {
			System.out.println(i / 60 + "분" + i % 60 + "초 후 알람이 울립니다.");
		}
		System.out.println("시간이 다 되었습니다");
	}
}
