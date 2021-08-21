package condition;
import java.lang.*;
public class Test01_3 {
	public static void main(String[] args) {
		//조건
		
		//입력
		int number = 51;
		
		//처리
		//boolean odd = number % 2 == 1;
		boolean odd = number % 2 != 0;
		boolean even = number % 2 == 0;
		
		//출력
		//== true 라는 식은 +0 또는 *1 처럼 아무런 기능이 없는 논리 비교식이다.
		if(odd){
			System.out.println("홀수입니다");
		}
		if(even){
			System.out.println("짝수입니다");
		}
}
}
