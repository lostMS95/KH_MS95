package array2d;

public class Test07_1 {
	public static void main(String[] args) {
		// 입력(준비)
		int[][] data = new int[5][5];

		int x = 0;
		int y = 0;
		for (int i = 1; i <= 25; i++) {
			System.out.println("(" + x + ", " + y + ")에 " + i + " 대입");
			data[x][y] = i;

			if (x % 2 == 0) {
				y++;
				if (y >= 5) {
					y = 4;
					x++;
				}
			} else {
				y--;
				if (y < 0) {
					y = 0;
					x++;
				}
			}
		}

		// 출력
		for (int i = 0; i < data.length; i++) {
			for (int k = 0; k < data[i].length; k++) {
				System.out.print(data[i][k]);
				System.out.print("\t");
			}
			System.out.println("\n");
		}
	}
}
