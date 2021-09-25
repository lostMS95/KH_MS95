package api.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("나라 입력 : ");
			String str = sc.nextLine(); 
			
			str = str.replace(" ","");
			if (list.contains(str)) {
				System.out.println("Game Over...");
				break;
			} else {
				list.add(str);

			}
		}

		System.out.println("입력한 나라 개수 : " + list.size());
		System.out.println("입력한 나라 목록 : " + list);
		sc.close();
	}
}
