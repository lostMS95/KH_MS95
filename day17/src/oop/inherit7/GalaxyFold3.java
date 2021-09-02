package oop.inherit7;

public class GalaxyFold3 extends Samsung {

	public GalaxyFold3(String number, String color) {
		super(number, color);
	}

	public void call() {
		System.out.println("갤럭시폴드3 전화 기능 실행");
	}

	public void sms() {
		System.out.println("갤럭시폴드3 문자 기능 실행");
	}

	public void samsungPay() {
		System.out.println("갤럭시폴드3 삼성페이 기능 실행");
	}

	public void iris() {
		System.out.println("갤럭시폴드3 홍채인식 기능 실행");
	}

}
