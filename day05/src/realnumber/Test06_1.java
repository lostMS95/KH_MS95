package realnumber;
import java.lang.*;
public class Test06_1 {
	public static void main(String[] args) {
		
		//입력(준비)
		double cm = 180;
		double kg = 80;
		
		//처리
		double m = cm / 100;
		double bmi = kg / (m * m);
		//double bmi = kg / m / m;
		
		//출력
		System.out.println(bmi);
		
		
	}
}
