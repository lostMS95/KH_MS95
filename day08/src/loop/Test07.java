package loop;
//import java.lang.*;
public class Test07 {
	public static void main(String[] args) {
		
		//Q : 1부터 100 사이의 7의 배수
		//(1) 반복수를 조절하여 출력하는 방법 : 7, 14, 21, 28, 35, 42, ...
		for(int i = 7 ; i <= 100 ; i += 7) {
			System.out.println("i = " + i);
		}
		
		System.out.println("---------");
		
		//(2) 범위는 그대로 사용하고 조건을 추가하는 방법
		for(int i = 1 ; i <= 100 ; i ++) {
			if(i % 7 == 0) {
				System.out.println("i = " + i);
			}
		}
	}
}
