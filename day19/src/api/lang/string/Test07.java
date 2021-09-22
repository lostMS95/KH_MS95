package api.lang.string;

import java.util.Scanner;

public class Test07 {
	public static void main(String[] args) {

		String[] badMouth = new String[] { "주옥", "신발끈", "개나리", "십장생", "수박씨", 
				"시베리아", "쌍화차", "가습기", "개불", "게새우" };

		Scanner sc = new Scanner(System.in);
		System.out.println("채팅을 입력하세요.");
		String chat = sc.nextLine();
		sc.close();
		
		for (int i = 0; i < badMouth.length; i++) {
			if (chat.contains(badMouth[i])) {
				chat = chat.replace(badMouth[i], "***");

			}
		}
		System.out.println(chat);
	}
}
