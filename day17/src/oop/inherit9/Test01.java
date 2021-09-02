package oop.inherit9;

public class Test01 {
	public static void main(String[] args) {

		Circle a = new Circle(5);
		System.out.println(a.area());

		Triangle b = new Triangle(30, 50);
		System.out.println(b.area());

		Rect c = new Rect(10, 50);
		System.out.println(c.area());

	}
}
