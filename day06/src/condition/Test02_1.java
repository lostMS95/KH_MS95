package condition;
import java.lang.*;
public class Test02_1 {
	public static void main(String[] args) {
		//입력(준비)
		int month = 11;
		int days = 10;
		
		//처리(계산)
		boolean isSummer = month / 3 == 2;
		
		//출력(결과)
		if(isSummer) {
			int total = days * 80000;
			System.out.println("여름 특가 할인이 적용됩니다!");
			System.out.println("할인된 금액 : " + total + "원");
		}
		else {
			int total = days * 100000;
			System.out.println("예상 금액 : " + total + "원");
		}
	}
}
