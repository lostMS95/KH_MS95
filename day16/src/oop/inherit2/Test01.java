package oop.inherit2;

public class Test01 {
	public static void main(String[] args) {

		Galaxy p1 = new Galaxy();

		p1.setNumber("010-1212-3434");
		p1.call();
		p1.sms();
		p1.gallery();
		p1.samsungPay();
		p1.voiceRecord();

		IPhone p2 = new IPhone();
		p2.setNumber("010-1212-3434");
		p2.call();
		p2.sms();
		p2.gallery();
		p2.itunes();
		p2.siri();

	}
}
