package oop.method2;

public class Menu {
	// 멤버 변수(멤버 필드)
	String name;
	String type;
	int price;
	boolean isEvent;

	void init(String name, String type, int price) {
		this.name = name;
		this.type = type;
		this.price = price;
		this.isEvent = false;
	}

	void init(String name, String type, int price, boolean isEvent) {
		this.name = name;
		this.type = type;
		this.price = price;
		this.isEvent = isEvent;

	}

	void showInfo() {

		System.out.println("<메뉴 정보>");
		System.out.println("메뉴 이름 : " + this.name);
		System.out.println("메뉴 종류 : " + this.type);
//		System.out.println("메뉴 가격 : "+this.price+"원");
//		System.out.println("행사 여부 : "+this.isEvent);

		if (this.isEvent) {// 행사중일 때 --> 20% 할인(즉석에서 계산하여 출력)
			int discount = this.price * (100 - 20) / 100;
			System.out.println("메뉴 가격 : " + discount + "원" + "(원가 : " + this.price + "원)");
		} else {// 행사중이 아닐 때

			System.out.println("메뉴 가격 : " + this.price + "원");
		}
	}
}