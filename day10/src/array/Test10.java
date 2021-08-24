package array;

public class Test10 {
	public static void main(String[] args) {

		int[] score = new int[10];
		score[0] = 95;
		score[1] = 82;
		score[2] = 77;
		score[3] = 69;
		score[4] = 75;
		score[5] = 62;
		score[6] = 76;
		score[7] = 77;
		score[8] = 100;
		score[9] = 93;

		
		int maxIndex = 0;
		for (int i = 1; i < score.length; i++) {
			if (score[i] > score[maxIndex]) {
				maxIndex = i;
			}
		}

		System.out.println("최대값 위치 : " + maxIndex);
		System.out.println("최대값 : " + score[maxIndex]);
	}
}
