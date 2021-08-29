package array;

import java.util.Scanner;

public class Test14 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("회전시킬 숫자 입력 : ");
		int rol = sc.nextInt();
		sc.close();

		int[] data = new int[] { 30, 50, 20, 10, 40 };

		for (int k = 0; k < rol; k++) {
			int temp = data[data.length - 1];
			for (int i = data.length - 1; i >= 1; i--) {
				data[i] = data[i - 1];
			}
			data[0] = temp;
			for (int i = 0; i < data.length; i++) {
				System.out.print(data[i] + " ");

			}
			System.out.println("");
		}

	}

}
