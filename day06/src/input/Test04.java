package input;
import java.text.DecimalFormat;
public class Test04 {
	public static void main(String[] args) {
		
		//입력(준비)
		String name = "피카츄";
		float height = 180f;
		float weight = 80f;
		
		//처리(계산)
		float heightMeter = height / 100;
		float bmi = weight / (heightMeter * heightMeter);
		//float bmi = weight / (heightMeter^2);//자바에서는 ^는 XOR 연산자
		
		//출력(결과)
		System.out.println("이름 : " + name);
		System.out.println("BMI : " + bmi);
		
		float bmi2 = (int)(bmi * 100) / 100f;
		System.out.println("BMI : " + bmi2);
		
		//DecimalFormat df = new DecimalFormat("#.00");
		//System.out.println("BMI : " + df.format(bmi));
	}
}
