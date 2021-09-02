package oop.inherit7;

public class IPhone11 extends Apple {

	public IPhone11(String number, String color) {
		super(number, color);

	}

	public void call() {
		System.out.println("아이폰11 전화 기능 실행");
	}

	public void sms() {
		System.out.println("아이폰11 문자 기능 실행");
	}

	public void itunes() {
		System.out.println("IPhone11 아이튠즈 기능 실행");
	}

	public void siri() {
		System.out.println("IPhone11 음성인식 기능 실행");
	}

}
