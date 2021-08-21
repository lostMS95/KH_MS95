package condition;
import java.lang.*;
public class Test09_4 {
	public static void main(String[] args) {
		//지하철 요금 계산기
		
		//입력(준비)
		int birth = 1950;
		
		//처리(계산)
		int thisYear = 2021;
		int age = thisYear - birth + 1;
		
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
		price = price + 500;
		
		//출력(결과)
		System.out.println("나이 : " + age);
		System.out.println("요금 : " + price + "원");
		
	}
}
