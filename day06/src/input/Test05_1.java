package input;
import java.lang.*;
import java.util.Scanner;
public class Test05_1 {
	public static void main(String[] args) {
		//입력(준비)
		Scanner sc = new Scanner(System.in);
		
		System.out.println("시작 시각 입력");
		int inHour =  sc.nextInt();
		int inMinute = sc.nextInt();
		
		System.out.println("종료 시각 입력");
		int outHour = sc.nextInt();
		int outMinute = sc.nextInt();
		
		sc.close();
		
		int pricePerHour = 1000;
		
		//처리(계산) - 시간은 가장 작은 단위로 변환하여 계산한다
		int outTime = outHour * 60 + outMinute;
		int inTime = inHour * 60 + inMinute;
		
		int useTime = outTime - inTime;
		
		int useHour = useTime / 60;
		int useMinute = useTime % 60;
		
		float pricePerMinute = pricePerHour / 60f;
		//int pricePerMinute = pricePerHour / 60;
		int price = (int)(pricePerMinute * useTime);
		
		System.out.println("price = " + price);
		//price = price / 100 * 100;//버림
		//price = (price + 50) / 100 * 100;//반올림
		price = (price + 99) / 100 * 100;//올림
		
		//출력(결과)
		System.out.println("이용시간 : 총 "+useHour+"시간 "+useMinute+"분");
		System.out.println("이용요금 : "+price+"원");
	}
}
