import java.lang.*;
public class Calculate4 {
	public static void main(String[] args) {
		//문제점
		//1. 무슨값이 얼마인지 알 수 없다
		//2. 매번 식을 입력해야 한다(해결)
		//3. 자장면, 짬뽕, 개수 등이 변하면 식을 일일이 고쳐야 한다(해결)

		int c = 5000;
		int d = 2;
		int e = 6000;
		int f = 2;

		int a = c * d;//a라는 이름으로 c * d의 결과를 저장하세요
		int b = e * f;//b라는 이름으로 e * f의 결과를 저장하세요

		System.out.println(a);
		System.out.println(b);
		System.out.println(a + b);
		//System.out.println((a) + (b));
	}
}
