package input;
import java.lang.*;
import java.util.Scanner;
public class Test05 {
	public static void main(String[] args) {
		// 입력(준비)
		int inHour = 12;
		int inMinute = 30;
		int outHour = 15;
		int outMinute = 20;

		int pricePerHour = 1000;

		// 처리(계산) - 시간은 가장 작은 단위로 변환하여 계산한다
		int outTime = outHour * 60 + outMinute;
		int inTime = inHour * 60 + inMinute;

		int useTime = outTime - inTime;

		int useHour = useTime / 60;
		int useMinute = useTime % 60;

		float pricePerMinute = pricePerHour / 60f;
		// int pricePerMinute = pricePerHour / 60;
		int price = (int) (pricePerMinute * useTime);
		
		price = price / 100 * 100;

		// 출력(결과)
		System.out.println("이용시간 : 총 " + useHour + "시간 " + useMinute + "분");
		System.out.println("이용요금 : " + price + "원");
	}
}
