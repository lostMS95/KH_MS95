package condition;
import java.lang.*;
import java.util.Scanner;
public class Test09_5 {
	public static void main(String[] args) {
		//지하철 요금 계산기
		
		//입력(준비)
		Scanner sc = new Scanner(System.in);
		System.out.println("출생년도 4자리 입력");
		int birth = sc.nextInt();
		sc.close();
		
		//처리(계산)
		int thisYear = 2021;
		int age = thisYear - birth + 1;
		
		//주의 : 반드시 if 부터 else까지 모두가 존재해야 이런 유형의 계산이 가능
		//int price = 1250 또는 720 또는 450 또는 0;
		int price;
		if(age < 8 || age >= 65) {//영유아 또는 어르신이라면
			price = 0;
		}
		else if(age >= 20) {//성인이라면
			price = 1250;
		}
		else if(age >= 14) {//청소년이라면
			price = 720;
		}
		else {//어린이라면
			price = 450;
		}
		
		//카드 보증금 500원 추가
		if(age >= 8 && age < 65) {
			price = price + 500;
		}
		
		//출력(결과)
		System.out.println("나이 : " + age);
		System.out.println("요금 : " + price + "원");
		
	}
}
