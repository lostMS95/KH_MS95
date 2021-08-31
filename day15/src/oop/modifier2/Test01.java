package oop.modifier2;

public class Test01 {
	public static void main(String[] args) {

		Phone a = new Phone();
		Phone b = new Phone();
		Phone c = new Phone();

		a.init("갤럭시폴드3", "SKT", 24, 200);
		b.init("아이폰12", "KT", 24, 180);
		c.init("갤럭시s21s", "LGU+", 30, 155);

		a.showInfo();
		b.showInfo();
		c.showInfo();

	}
}
