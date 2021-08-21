package condition2;
import java.lang.*;
public class Test01_1 {
	public static void main(String[] args) {
		//if문의 단점
		//= 규칙이 없는 경우 조건식이 매우 길어진다
		//= 순차적으로 질의하므로 하단의 구문이 느리게 실행된다
		
		//이러한 단점들을 보완할 수 있는 구문이 switch~case 구문
		
		int value = 10;
		if(value == 5) {
			System.out.println("5");
		}
		else if(value == 10) {
			System.out.println("10");
		}
		else {
			System.out.println("기타");
		}
	}
}
