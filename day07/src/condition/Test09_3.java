package condition;
import java.lang.*;
public class Test09_3 {
	public static void main(String[] args) {
		//지하철 요금 계산기
		
		//입력(준비)
		int birth = 1950;
		
		//처리(계산)
		int thisYear = 2021;
		int age = thisYear - birth + 1;
		
		//출력(결과)
		System.out.println("나이 : " + age);
		
		//만약 카드보증금 500원을 추가해서 출력해야 한다면? 내 머리로 계산해서 적어야 한다.
		if(age < 8 || age >= 65) {//영유아 또는 어르신
			System.out.println("요금 : 500원");
		}
		else if(age >= 20) {//성인이라면
			System.out.println("요금 : 1750원");
		}
		else if(age >= 14) {//청소년이라면
			System.out.println("요금 : 1220원");
		}
		else {//어린이라면
			System.out.println("요금 : 950원");
		}
	}
}
