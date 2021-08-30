package oop.method3;

//장난감 클래스
public class Toy {
	String name;
	int price;

	void init(String name, int price) {
		// setName 메소드 실행해!
		this.setName(name);
		this.setPrice(price);
	}

	void showInfo() {
		System.out.println("이름 : "+this.name);
		System.out.println("가격 : "+this.price+"원");
	}

	// 정보는 언제든지 바뀔수 있다.
	// 하나씩 바꿀 수 있도록 메소드를 준비
	// 세터 메소드(setter method)
	// 설정 전용 메소드
	// = 변수명을 이용해서 메소드 이름을 구성
	// =set + 변수명으로 메소드 이름을 작성
	// set+name이면 setName
	// =조건을 추가하여 "원하는 값"만 설정
	void setName(String name) {

		this.name = name;
	}

	void setPrice(int price) {
		if (price >= 0) {
			this.price = price;
		}
	}
}
