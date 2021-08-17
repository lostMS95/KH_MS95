package realnumber;
import java.lang.*;
public class Test05 {
	public static void main(String[] args) {
		
		//입력(준비)
		int javaScore = 70;
		int datebaseScore = 85;
		int count = 2;
		
		//처리 - 변환(cast) 연산을 활용해서 두 값 중 하나를 미리 실수로 변환 후 계산
		int totalScore = javaScore + datebaseScore;
		float aver  = totalScore / (float)count ;
		
		//출력
		System.out.println(aver);
		
		
		
		
		
		
		
		
	}
}
