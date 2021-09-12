package api.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test07 {
	public static void main(String[] args) {

		List<Integer> bowl = new ArrayList<>();

		for (int i = 1; i <= 45; i++) {
			bowl.add(i);// auto-boxing 코드(int ---> Integer)
		}

		Collections.shuffle(bowl);
		System.out.println(bowl);

		List<Integer> lotto = bowl.subList(0, 6);

		Collections.sort(lotto);
		System.out.println(lotto);

	}
}
