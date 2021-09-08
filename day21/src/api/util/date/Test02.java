package api.util.date;

import java.util.Date;

public class Test02 {
	public static void main(String[] args) {
		// Date 클래스를 이용하여 현재 날짜를 출력
		Date a = new Date();
		System.out.println(a);

		// 비추천된 생성자가 많은 이유
		// = 밀레니엄 이슈(Y2K)로 인하여 비추천된 생성자가 존재함
		// = 연도를 1900년을 기준으로 계산하도록 만들어져 있기 때문
		// = 월은 0부터 11까지로 설계되어 있다
		// = 다른 클래스를 만들어 해결하였다.
		Date b = new Date(121, 8, 8);
		System.out.println(b);
	}
}