package realnumber;
import java.lang.*;
public class Test04 {
	public static void main(String[] args) {
		//정수와 실수간의 변환
		//1. 자료형에는 크기(범위)가 존재하며 크기(범위)가 작거나 다를 경우 변환이 어렵다
		
		//- byte는 int보다 작다
		byte a = 10;
		int b = a;//자동 형변환(묵시적 형변환)
		//int b = (int)a;
		System.out.println(b);
		
		int c = 20;
		//byte d = c;//될지 안될지 모르는 경우는 안되는 것으로 간주
		byte d = (byte)c;//c의 데이터를 byte에 맞게 강제로 변환하여 넣어라(강제 형변환, 명시적 형변환)
		System.out.println(d);
		
		//float와 long 중에서 누가 더 큰 형태인지 코드를 통하여 증명
		float e = 1.5f;
		//long f = e;
		long f = (long)e;//강제 형변환, 명시적 형변환
		System.out.println(f);
		
		long g = 10L;
		float h = g;//자동 형변환, 묵시적 형변환
		System.out.println(h);
	}
}