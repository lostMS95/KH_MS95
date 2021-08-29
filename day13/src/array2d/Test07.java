package array2d;

public class Test07 {
	public static void main(String[] args) {
		// 입력(준비)
		int[][] data = new int[5][5];

		int count = 1;
		for (int i = 0; i < data.length; i++) {
			for (int k = 0; k < data[i].length; k++) {
				if (i % 2 == 0) {// 짝수 줄이라면
					//System.out.println("i = " + i + ", k = " + k);
					data[i][k] = count++;
				} 
				else {// 홀수 줄이라면
					//System.out.println("i = " + i + ", k = " + (4-k));
					//System.out.println("i = " + i + ", k = " + (data[i].length-1-k));
					int t = data[i].length - 1 - k;
					data[i][t] = count++;
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