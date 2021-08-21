package input;
import java.lang.*;
import java.util.Scanner;
public class Test04_1 {
	public static void main(String[] args) {

		// 입력(준비) - Scanner 적용
		Scanner sc = new Scanner(System.in);

		System.out.println("이름 입력");
		String name = sc.next();

		System.out.println("신장(cm) 입력");
		float height = sc.nextFloat();

		System.out.println("체중(kg) 입력");
		float weight = sc.nextFloat();

		sc.close();

		// 처리(계산)
		float heightMeter = height / 100;
		float bmi = weight / (heightMeter * heightMeter);
		// float bmi = weight / (heightMeter^2);//자바에서는 ^는 XOR 연산자

		// 출력(결과)
		System.out.println("이름 : " + name);

		float bmi2 = (int) (bmi * 100) / 100f;
		System.out.println("BMI : " + bmi2);

		// DecimalFormat df = new DecimalFormat("#.00");
		// System.out.println("BMI : " + df.format(bmi));
	}
}
