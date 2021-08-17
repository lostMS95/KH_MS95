package realnumber;
import java.lang.*;
public class Test01 {
	public static void main(String[] args) {
		//실수(부동소수점수)
		//1. 실수는 double 기본 형태이다.
		//2. 실수는 부정확하다.(각 형태마다 표현 가능한 자리가 정해져 있다.)
		//3. 실수가 포함된 계산은 무조건 실수 결과가 나온다.
		
		//float a = 1.5;
		float a = 1.5f;
		double b = 1.5;
		
		System.out.println(a);
		System.out.println(b);
		
		System.out.println(1.5+2.5);
		System.out.println(10 / 3);
		System.out.println(10.0 / 3);
	}
}
