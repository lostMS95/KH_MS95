package condition;
import java.lang.*;
public class Test01_1 {
	public static void main(String[] args) {
		// 조건

		// 입력
		int number = 51;

		// 처리
		// boolean odd = number % 2 == 1;
		boolean odd = number % 2 != 0;
		boolean even = number % 2 == 0;

		// 출력
		System.out.println("홀수입니다");
		System.out.println("짝수입니다");
	}
}
