package array2d;

public class Test05 {
	public static void main(String[] args) {

		int[][] num = new int[5][5];

		for (int i = 0; i < num.length; i++) {
			for (int k = 0; k < num[i].length; k++) {

				System.out.print(num[i][k]);
				System.out.print("\t" + "\t");
			}
			System.out.println();
			System.out.println();
		}

	}
}
