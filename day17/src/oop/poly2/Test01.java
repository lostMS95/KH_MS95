package oop.poly2;

public class Test01 {
	public static void main(String[] args) {

		Galaxy21s a = new Galaxy21s();
		a.camera();
		a.gallery();
		a.call();
		a.sms();

		GalaxyFold3 b = new GalaxyFold3();
		b.camera();
		b.gallery();
		b.call();
		b.sms();

		IPhone11 c = new IPhone11();
		c.camera();
		c.gallery();
		c.call();
		c.sms();

		IPhone12 d = new IPhone12();
		d.camera();
		d.gallery();
		d.call();
		d.sms();
	}
}
