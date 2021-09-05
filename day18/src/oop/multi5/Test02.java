package oop.multi5;

public class Test02 {
	public static void main(String[] args) {

		ElectronicBox box = new ElectronicBox();
		Camera c = new Camera("디지컬카메라");
		box.setValue(c);

		System.out.println(box.getValue());
		box.getValue().on();
		box.getValue().off();

		GroceryBox box2 = new GroceryBox();
		Bread g = new Bread("팥빵", "2022-01-01");

		box2.setValue(g);

		System.out.println(box2.getValue());

	}
}