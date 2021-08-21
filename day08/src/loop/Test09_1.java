package loop;
//import java.lang.*;
public class Test09_1 {
	public static void main(String[] args) {
		//Q : 1부터 99까지 369게임 결과를 출력
		
		for(int i = 1 ; i <= 99 ; i++) {
			boolean first = i / 10 == 3 || i / 10 == 6 || i / 10 == 9;//10의자리에 3,6,9가 있는가?
			boolean second = i % 10 == 3 || i % 10 == 6 || i % 10 == 9;//1의자리에 3,6,9가 있는가?
			//System.out.println(i + " , first = " + first + " , second = " + second);
			
			//if(!first && !second) {//10의자리에도 없고, 1의자리에도 없는경우
			if(!(first || second)) {//10의자리나 1의자리에 있는 경우가 아니라면
				System.out.println(i);
			}
			else {
				if(first) {
					System.out.print("짝");
				}
				if(second) {
					System.out.print("짝");
				}
				System.out.println();
			}
		}
	}
}
