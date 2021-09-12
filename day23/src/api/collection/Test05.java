package api.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test05 {
	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();

		for (int i = 1; i <= 45; i++) {
			list.add(i);
		}

		System.out.println(list);

		Collections.reverse(list);
		System.out.println(list);

		Collections.shuffle(list);
		System.out.println(list);

		Collections.sort(list);
		System.out.println(list);
	}
}