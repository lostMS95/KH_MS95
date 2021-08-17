package realnumber;
import java.lang.*;
public class Test06 {
	public static void main(String[] args) {
		
		//입력(준비)
		int cm = 180;
		int kg = 80;
		
		//처리
		//double m = cm / 100.0;
		double m = cm * 0.01;
		
		double bmi = kg / (m * m);
		//double bmi = kg / m / m;
		
		//출력
		System.out.println(bmi);
	}
}
