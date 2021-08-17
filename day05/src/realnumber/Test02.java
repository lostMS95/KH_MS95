package realnumber;
import java.lang.*;
public class Test02 {
	public static void main(String[] args) {
		//다음 주어진 국어점수, 영어점수. 수학점수를 이용하여 총점과 평균을 구하여 출력
		
		//입력(준비)
		int kor = 85;
		int eng = 90;
		int math = 90;
		
		//처리
		int total = kor + eng + math;
		double aver = total / 3.0;
		
		//출력
		System.out.println(total);
		System.out.println(aver);
	}
}
