package input;
import java.lang.*;
import java.util.Scanner;
public class Test04_2 {
	public static void main(String[] args) {

		// 입력(준비) - Scanner 적용
		// = next 계열 명령은 엔터,띄어쓰기 등을 이용하여 데이터를 구분하여 입력받는다
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

		boolean isHeavy = bmi >= 24.5;

		// 출력(결과)
		System.out.println("이름 : " + name);

		// float bmi2 = (int)(bmi * 100) / 100f;
		float bmi2;
		bmi2 = bmi * 100;
		System.out.println(bmi2);
		bmi2 = (int) bmi2;
		System.out.println(bmi2);
		bmi2 = bmi2 / 100f;
		// System.out.println(bmi2);
		System.out.println("BMI : " + bmi2);

		System.out.println("과체중? " + isHeavy);

		// DecimalFormat df = new DecimalFormat("#.00");
		// System.out.println("BMI : " + df.format(bmi));
	}
}
