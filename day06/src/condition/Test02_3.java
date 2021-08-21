package condition;
import java.lang.*;
import java.util.Scanner;
public class Test02_3 {
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
		
		//처리(계산)
		boolean isSummer = month / 3 == 2;
		
		//출력(결과)
		if(isSummer) {
			int total = days * salePrice;
			System.out.println("여름 특가 할인이 적용됩니다!");
			System.out.println("할인된 금액 : " + total + "원");
		}
		else {
			int total = days * originPrice;
			System.out.println("예상 금액 : " + total + "원");
		}
	}
}
