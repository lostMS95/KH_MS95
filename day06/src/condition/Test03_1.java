package condition;
import java.lang.*;
public class Test03_1 {
	public static void main(String[] args) {
		//복잡한 판정식
		//(ex) 어떤 사람이 청소년인가?
		//= 청소년의 기준을 설정해야 함
		//= 중, 고등학생이라고 할 경우 나이가 14세 부터 19세 까지로 볼 수 있다.
		//= 청소년은 14세 이상 그리고 19세 이하에 해당한다
		
		//입력
		int age = 20;
		
		//처리
		boolean upper = age >= 14;
		boolean lower = age <= 19;
		boolean isTeen = upper && lower;
		
		System.out.println("upper = " + upper);
		System.out.println("lower = " + lower);
		System.out.println("isTeen = " + isTeen);
		
		//출력
		System.out.println("청소년? " + isTeen);
	}
}
