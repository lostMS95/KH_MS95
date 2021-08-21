package loop;
//import java.lang.*;
public class Test06 {
	public static void main(String[] args) {
		//Q : 1부터 10까지 존재하는 짝수를 출력하세요
		//= 2, 4, 6, 8, 10
		//= 2부터 10까지 2씩증가
		
		for(int i = 2 ; i <= 10 ; i += 2) {
			System.out.println("i = " + i);
		}
		
		System.out.println("---------------");
		
		for(int i = 1 ; i <= 10 ; i++) {
			if(i % 2 == 0) {
				System.out.println("i = " + i);
			}
			else {
				
			}
		}
	}
}