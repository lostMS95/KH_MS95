package api.lang.string;

import java.util.Scanner;

public class Test05 {
	public static void main(String[] args) {

		String[] record = new String[10];
		record[0] = "바나나";

		int round = 0;
		Scanner sc = new Scanner(System.in);
		for (int i = 1; i < record.length; i++) {
			System.out.println("제시어 : " + record[i - 1]);
			System.out.println("입력");
			record[i] = sc.next();

			boolean isLengthOk = record[i].length() == 3;
			boolean isConnect = record[i - 1].charAt(record[i - 1].length() - 1) == record[i].charAt(0);
			boolean isCorrect = isLengthOk && isConnect;

			if (isCorrect) {
				round++;
			} else {
				break;
			}
		}
		sc.close();

		System.out.println("진행라운드 : " + round);
		if (round == record.length - 1) {
			System.out.println("Game Finish");
		} else {
			System.out.println("Game Over..");
		}

	}
}