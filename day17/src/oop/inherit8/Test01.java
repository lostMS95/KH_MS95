package oop.inherit8;

public class Test01 {
	public static void main(String[] args) {
		Galaxy21s p1 = new Galaxy21s("010-1010-2020", "골드");
		p1.call();
		p1.sms();
		p1.samsungPay();
		p1.bixby();
		
		GalaxyFold3 p2 = new GalaxyFold3("010-1111-2222", "블랙");
		p2.call();
		p2.sms();
		p2.samsungPay();
		p2.iris();
		
		
	}
}
