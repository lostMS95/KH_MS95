package oop.inherit7;

public class Test01 {
	public static void main(String[] args) {

		Galaxy21s p1 = new Galaxy21s("010-1212-3434", "red");

		System.out.println(p1.getNumber());
		System.out.println(p1.getColor());

		p1.call();
		p1.sms();
		p1.samsungPay();
		p1.bixby();

		GalaxyFold3 p2 = new GalaxyFold3("010-3434-1212", "black");
		System.out.println(p2.getNumber());
		System.out.println(p2.getColor());
		p2.call();
		p2.sms();
		p2.samsungPay();
		p2.iris();

		IPhone11 p3 = new IPhone11("010-5111-5646", "red");
		System.out.println(p3.getNumber());
		System.out.println(p3.getColor());
		p3.call();
		p3.sms();
		p3.itunes();
		p3.siri();

		IPhone12 p4 = new IPhone12("010-1561-1561", "pink");
		System.out.println(p4.getNumber());
		System.out.println(p4.getColor());
		p4.call();
		p4.sms();
		p4.faceTime();
		p4.siri();

	}

}
