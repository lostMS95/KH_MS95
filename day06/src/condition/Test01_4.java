package condition;
import java.lang.*;
public class Test01_4 {
	public static void main(String[] args) {
		// 조건

		// 입력
		int number = 51;

		// 처리
		// = 홀수인지 또는 짝수인지 단 한 번만 물어보면 알 수 있다.
		// = 판정을 한 번만 수행
		boolean even = number % 2 == 0;

		// 출력
		// == true 라는 식은 +0 또는 *1 처럼 아무런 기능이 없는 논리 비교식이다.
		// if(even == false){
		if (!even) {// even이 아니라면(!는 논리 부정 연산)
			System.out.println("홀수입니다");
		}
		if (even) {
			System.out.println("짝수입니다");
		}
	}
}
