package oop.inherit7;

public class IPhone12 extends Apple {

	public IPhone12(String number, String color) {
		super(number, color);

	}

	public void call() {
		System.out.println("아이폰12 전화 기능 실행");
	}

	public void sms() {
		System.out.println("아이폰12 문자 기능 실행");
	}

	public void faceTime() {
		System.out.println("IPhone12 영상통화 기능 실행");
	}

	public void siri() {
		System.out.println("IPhone12 음성인식 기능 실행");
	}
}
