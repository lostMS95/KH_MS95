package array;

public class Test09 {
	public static void main(String[] args) {
		//입력(준비)
		int[] score = new int[] {95, 82, 77, 69, 75, 62, 76, 100, 85, 93};
		
		//1. 최대값 찾기
		//(1) 맨 앞에 있는 점수가 가장 큰 점수일 것이라고 가정을 하고 시작
		//(2) 그 뒤에 있는 데이터들과 비교하여 더 큰 데이터가 나오면 갱신
		//(3) 모든 과정이 종료된 뒤 남은 데이터가 최대값
		
		//(1)
		int maxValue = score[0];
		
		//(2)
		for(int i=1; i < score.length; i++) {
			//System.out.println("maxValue = " + maxValue + ", i = " + i + " , score[i] = " + score[i]);
			if(maxValue < score[i]) {//maxValue보다 더 큰 데이터가 score에 존재한다면
				//maxValue를 현재의 점수(score[i])로 변경(갱신)한다
				maxValue = score[i];
			}
		}
		
		//(3)
		System.out.println("최대값 = " + maxValue);
		
		//1. 최소값 찾기
		//(1) 맨 앞에 있는 점수가 가장 작은 점수일 것이라고 가정을 하고 시작
		//(2) 그 뒤에 있는 데이터들과 비교하여 더 작은 데이터가 나오면 갱신
		//(3) 모든 과정이 종료된 뒤 남은 데이터가 최소값
		
		int minValue = score[0];
		
		for(int i=1 ; i < score.length; i++) {
			//System.out.println("minValue = " + minValue + ", i = " + i + " , score[i] = " + score[i]);
			if(minValue > score[i]) {
				minValue = score[i];
			}
		}
		
		System.out.println("최소값 = " + minValue);
	}
}