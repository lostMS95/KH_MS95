package condition;
import java.lang.*;
public class Test09_1 {
	public static void main(String[] args) {
		//지하철 요금 계산기
		
		//입력(준비)
		int birth = 2015;
		
		//처리(계산)
		int thisYear = 2021;
		int age = thisYear - birth + 1;
		
		//출력(결과)
		System.out.println("나이 : " + age);
		
		if(age >= 20 && age < 65) {//성인이라면
			System.out.println("요금 : 1250원");
		}
		else if(age >= 14 && age < 20) {//청소년이라면
			System.out.println("요금 : 720원");
		}
		else if(age >= 8 && age < 14) {//어린이라면
			System.out.println("요금 : 450원");
		}
		else {//영유아 또는 어르신
			System.out.println("요금 : 0원");
		}
	}
}
