package condition;
import java.lang.*;
import java.util.Scanner;
public class Test02_5 {
	public static void main(String[] args) {
		//입력(준비)
		Scanner sc = new Scanner(System.in);
		System.out.println("여행갈 달을 숫자로 입력");
		int month = sc.nextInt();
		System.out.println("여행갈 기간을 일단위로 입력");
		int days = sc.nextInt();
		sc.close();
		
		int salePrice = 80000;
		int originPrice = 100000;
		
		//밖에 생성하면 안에서 추가 생성이 불가능하다
		int total;
		
		//처리(계산)
		//boolean isSummer = month / 3 == 2;
		boolean isSummer = month >= 6 && month <= 8;
		
		//출력(결과)
		if(isSummer) {
			total = days * salePrice;
			System.out.println("여름 특가 할인이 적용됩니다!");
			System.out.println("할인된 금액 : " + total + "원");
		}
		else {
			total = days * originPrice;
			System.out.println("예상 금액 : " + total + "원");
		}
	}
}
