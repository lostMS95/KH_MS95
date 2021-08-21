package loop;
//import java.lang.*;
public class Test10 {
	public static void main(String[] args) {
		//Q : 1부터 10 사이의 짝수 개수를 구하여 출력
		
		int count = 0;//계수기 역할을 수행할 변수를 0으로 설정
		int total = 0;//누적합계 계산을 위한 변수를 0으로 설정
		
		for(int i = 1 ; i <= 10 ; i++) {
			if(i % 2 == 0) {
				System.out.println("i = " + i);
				count++;//count += 1;//count = count + 1;
				total += i;//합계에 현재 숫자(i)를 더해 넣어라
			}
		}
		
		System.out.println("count = " + count);
		System.out.println("total = " + total);
	}
}
