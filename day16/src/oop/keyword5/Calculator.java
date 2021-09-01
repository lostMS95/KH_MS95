package oop.keyword5;

import java.util.Random;

public class Calculator {
	//곱셈 메소드
	public static int multiple(int left, int right) {
		return left * right;
	}
	//제곱 메소드 - 11의 제곱, 11의 3제곱
	public static int square(int n) {//n의 제곱
		//return n ^ 2;//제곱 기호가 아님(에러)
		//return n * n;
		//return this.multiple(n, n);//this는 "주인공 객체"를 의미하므로 static 상황에서는 못쓴다.(에러)
		//return Calculator.multiple(n, n);//정확한 표현
		//return multiple(n, n);
		return square(n, 2);
	}
	public static int square(int n, int m) {//n의 m제곱
		int result = 1;
		for(int i=0; i < m; i++) {
			result *= n;
		}
		return result;
	}
	
	//삼각형 넓이 계산 메소드
	public static float triangle(int width, int height) {
		int rect = width * height;
		float result = rect / 2f;
		return result;
	}
	
	//원의 넓이 계산 메소드 (원의넓이 = 원주율 * 반지름²)
	public static float circle(int radius) {
		//return 원주율 * 반지름 * 반지름;
		//return 3.141592f * radius * radius;
		return 3.141592f * square(radius);
	}
	
	//랜덤 메소드
	//= a부터 n개로 관리되는 랜덤 코드를 우리가 이해하기 쉽도록 a부터 b까지로 개조
	public static int random(int a, int b) {
		int n = b - a + 1;
		int number = (int)(Math.random() * n) + a;
//		Random r = new Random();
//		int number = r.nextInt(n) + a;
		return number;
	}
}