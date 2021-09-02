package oop.inherit7;

public class Apple extends Phone {

	public Apple(String number, String color) {
		super(number, color);
	}

	public void siri() {
		System.out.println("음성인식 기능 실행");
	}
}
