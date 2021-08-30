package oop.method1;

public class Goods {

	int price;
	String code, name, division;

	void init(String code, String name, String division, int price) {

		this.code = code;
		this.name = name;
		this.division = division;
		this.price = price;

	}

	void showInfo() {
		System.out.println("<상품 정보>");
		System.out.println("상품코드 : " + this.code);
		System.out.println("상품이름 : " + this.name);
		System.out.println("상품분류 : " + this.division);
		System.out.println("상품가격 : " + this.price + "원");
	}

}
