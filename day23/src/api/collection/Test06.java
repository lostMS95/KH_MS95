package api.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Test06 {
	public static void main(String[] args) {

		Random r = new Random();
		List<Integer> lotto = new ArrayList<Integer>();

		for (int i = 1; i <= 6; i++) {
			int number = r.nextInt(45) + 1;
			if (!lotto.contains(number)) {
				lotto.add(number);
			}

			else {
				i--;
			}

		}
		Collections.sort(lotto);
//		System.out.println(lotto);
		for (int number : lotto) {
			System.out.println(number);
		}
	}
}
