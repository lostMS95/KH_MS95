package realnumber;
import java.lang.*;
public class Test02_1 {
	public static void main(String[] args) {
		
		//입력(준비)
		int korean = 85, english = 90, math = 90;
		
		//처리
		int total = korean + english + math;
		//double average = total / 3.0;
		//float average = total / 3.0f;
		float average = (float)total / 3;
		//float average = total / (float)3;
		
		//출력
		System.out.println(total);
		System.out.println(average);
	}
}
