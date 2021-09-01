package oop.inherit2;

//휴대폰 클라스 : 휴대폰이라면 가져야할 공용기능에 대해서 정의
public class Phone {
	// 멤버 변수
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

}
