package oop.inherit7;

public class Galaxy21s extends Samsung {

	public Galaxy21s(String number, String color) {
		super(number, color);

	}

	public void call() {
		System.out.println("갤럭시21s 전화 기능 실행");
	}

	public void sms() {
		System.out.println("갤럭시21s 문자 기능 실행");
	}

	public void samsungPay() {
		System.out.println("갤럭시21s 삼성페이 기능 실행");
	}

	public void bixby() {
		System.out.println("갤럭시21s 음성인식 기능 실행");
	}

}
