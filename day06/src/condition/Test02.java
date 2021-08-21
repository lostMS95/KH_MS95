package condition;
import java.lang.*;
public class Test02 {
	public static void main(String[] args) {
		//입력(준비)
		int month = 7;
		int days = 10;
		
		//처리(계산)
		boolean isSummer = month / 3 == 2;
		
		//출력(결과)
		if(isSummer) {
			System.out.println("여름 특가 할인이 적용됩니다!");
			System.out.println("할인된 금액 : ???원");
		}
		else {
			System.out.println("예상 금액 : ???원");
		}
	}
}
