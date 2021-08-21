package condition;
import java.lang.*;
public class Test09_2 {
	public static void main(String[] args) {
		//지하철 요금 계산기
		
		//입력(준비)
		int birth = 1950;
		
		//처리(계산)
		int thisYear = 2021;
		int age = thisYear - birth + 1;
		
		//출력(결과)
		System.out.println("나이 : " + age);
		
		if(age < 8 || age >= 65) {//영유아 또는 어르신
			System.out.println("요금 : 0원");
		}
		else if(age >= 20) {//성인이라면
			System.out.println("요금 : 1250원");
		}
		else if(age >= 14) {//청소년이라면
			System.out.println("요금 : 720원");
		}
		else {//어린이라면
			System.out.println("요금 : 450원");
		}
	}
}
