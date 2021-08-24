package array;

public class Test08 {
	public static void main(String[] args) {

		// 입력(준비)
		// int[] score = new int[10];
		int[] score = new int[] { 95, 82, 77, 69, 75, 62, 76, 77, 85, 93 };

		// 1. 전체 점수를 출력
		for (int i = 0; i < score.length; i++) {
			System.out.println("점수 = " + score[i]);
		}

		// 2. 80점 이상을 획득한 인원 수 출력(카운트)
		for (int i = 0; i < score.length; i++) {
			if (score[i] >= 80) {
				System.out.println("80점 이상인 학생 = " + score[i]);
			}
		}

		// 3. 우리반 평균 출력
		// 평균 = 총점 / 인원수 = 총점 / score.length

		int total = 0;
		for (int i = 0; i < score.length; i++) {
			total += score[i];
		}

		float average = (float) total / score.length;
		System.out.println("평균 = " + average);

		// 4. 전학생의 예상 등수 구하기
		int newScore = 76;
		int rank = 1;

		for (int i = 0; i < score.length; i++) {
			if (newScore < score[i]) {// 나보다 잘난놈을 발견했다면
				rank++;
			}
		}

		System.out.println("전학생 등수 = " + rank);

		// 추가문제 : ranking 배열에 "모든 학생의 순위" 점수 순서대로 계산하여 저장 후 점수와 연결하여 출력
		// ex : ranking[0]에는 score[0] 학생의 순위를 구하여 저장
		int[] ranking = new int[score.length];// score 길이만큼 ranking 생성

		// ranking[k] 에 들어갈 순위를 계산
		for (int k = 0; k < score.length; k++) {
			int sampleScore = score[k];
			int sampleRank = 1;
			for (int i = 0; i < score.length; i++) {
				if (sampleScore < score[i]) {
					sampleRank++;
				}
			}
			ranking[k] = sampleRank;
		}

		// 출력
		for (int i = 0; i < score.length; i++) {
			System.out.println("점수 = " + score[i] + ", 등수 = " + ranking[i] + "등");
		}

	}
}
