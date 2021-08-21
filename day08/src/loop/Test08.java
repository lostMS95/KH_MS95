package loop;
//import java.lang.*;
public class Test08 {
	public static void main(String[] args) {
		
		//1부터 99 사이의 5가 포함된 숫자 출력
		//= 범위는 그대로 두고 조건을 추가하여 출력
		
		for(int i = 1 ; i < 100 ; i ++) {
			//boolean first = i >= 50 && i < 60;
			boolean first = i / 10 == 5;
			boolean second = i % 10 == 5;
			if(first || second) {
				System.out.println("i = " + i);
			}
		}
		
	}
}
