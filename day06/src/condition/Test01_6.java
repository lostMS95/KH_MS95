package condition;
import java.lang.*;
public class Test01_6 {
	public static void main(String[] args) {
		// 조건

		// 입력
		int number = 51;

		// 처리
		// = 홀수인지 또는 짝수인지 단 한 번만 물어보면 알 수 있다.
		// = 판정을 한 번만 수행
		boolean even = number % 2 == 0;

		// 출력
		// = 둘 중 하나만 실행되도록 그룹 처리
		if (even) {
			System.out.println("짝수입니다");
		} else {
			System.out.println("홀수입니다");
		}
	}
}
