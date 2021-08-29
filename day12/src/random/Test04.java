package random;

import java.util.Random;

public class Test04 {
	public static void main(String[] args) {

		Random r = new Random();
		int count = 0;
		for (int i = 0; i < 1000; i++) {

			int ans = r.nextInt(100) + 1;

			if (ans == 1) {
				System.out.println("축하합니다!!!! 최상급아이템 획득~~");
				count++;
			} else if (ans <= 6) {
				System.out.println("축하합니다!! 상급아이템 획득~~");
			} else if (ans <= 20) {
				System.out.println("축하합니다! 중급아이템 획득~~");
			} else {
				System.out.println("꽝!! 일방 아이템 획득");
			}
		}
		System.out.println("카운트 개수 : " + count);
	}
}
