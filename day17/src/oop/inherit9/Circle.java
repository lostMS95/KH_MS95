package oop.inherit9;

public class Circle extends Shape {

	public static final double PI = 3.141592;
	protected int radius;

	public Circle(int radius) {
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public double area() {
		return PI * radius * radius;

	}

}
