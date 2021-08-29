package random;

import java.util.Random;

public class Test02 {
	public static void main(String[] args) {

		Random r = new Random();
		int num = r.nextInt(6) + 1;

		System.out.println("주사위 : " + num);

		int num2 = r.nextInt(45) + 1;

		System.out.println("로또번호 : " + num2);

		int num3 = r.nextInt(900000) + 100000;

		System.out.println("OTP : " + num3);

	}
}
