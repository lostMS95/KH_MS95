package condition;

import java.lang.*;
import java.util.Scanner;

public class Test05 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("이름 : ");
		String name = sc.next();
		System.out.println("국어 점수 :");
		int kor = sc.nextInt();
		System.out.println("영어 점수 :");
		int eng = sc.nextInt();
		System.out.println("수학 점수 : ");
		int math = sc.nextInt();
		sc.close();

		int total = kor + eng + math;
		float aver = total / 3f;

		boolean great = kor >= 40 && eng >= 40 && math >= 40 && aver >= 60;

		System.out.println("이름 : " + name);
		System.out.println("총점 : " + total + "점");
		System.out.println("평균 " + aver + "점");

		if (great) {
			System.out.println("해당 평가 통과입니다");
		} else {
			System.out.println("재평가입니다");
		}

	}
}
