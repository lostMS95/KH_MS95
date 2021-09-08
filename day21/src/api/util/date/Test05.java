package api.util.date;

import java.util.Date;

public class Test05 {
	public static void main(String[] args) {
		// Date 객체에서 정보를 추출
		// = 비추천이 많으며 이해하기가 어려우므로 다른 클래스로 대체(Calendar, LocalDateTime 등)
		Date d = new Date();

		System.out.println(d.getYear());
		System.out.println(d.getMonth());
		System.out.println(d.getDate());
		System.out.println(d.getHours());
		System.out.println(d.getMinutes());
		System.out.println(d.getSeconds());
	}
}
