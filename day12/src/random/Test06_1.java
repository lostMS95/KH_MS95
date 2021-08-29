package random;

import java.util.Random;

public class Test06_1 {
	public static void main(String[] args) {
		Random r = new Random();// 자동 import : 컨트롤+쉬프트+O

		int[] count = new int[45];

		for (int i = 0; i < 1000; i++) {
			int lotto = r.nextInt(45) + 1;
			count[lotto - 1]++;
		}

		for (int i = 0; i < count.length; i++) {
			System.out.println((i + 1) + " - " + count[i] + "번");
		}

	}
}
