package oop.inherit8;

//추상 클래스 : 
//상속관계에서 추상적인 상위클래스를 효율적으로 표현하도록 만들어진 클래스
//추상 메소드
//객체 생성이 불가능
public abstract class Phone {
	protected String Number;
	protected String color;

	public String getNumber() {
		return Number;
	}

	public void setNumber(String number) {
		Number = number;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Phone(String number, String color) {
		super();
		Number = number;
		this.color = color;
	}

	// 추상메소드
	public abstract void call();

	public abstract void sms();

}
