package oop.inherit1;

public class IPhone {

	private String number;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void call() {
		System.out.println("전화 기능 실행!");
	}

	public void sms() {
		System.out.println("문자 기능 실행!");
	}

	public void gallery() {
		System.out.println("갤러리 실행!");
	}

	public void itunes() {
		System.out.println("아이튠즈 실행");
	}

	public void siri() {
		System.out.println("음성인식 실행");
	}

}
