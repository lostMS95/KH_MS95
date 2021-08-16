package decimal;
import java.lang.*;
public class Test05 {
	public static void main(String[] args) {
		//- PC방에서 7시 50분부터 9시 15분까지 이용한 손님이 있습니다.
		//- 이 손님의 총 이용시간을 계산하여 출력하세요
		//- 1시간 이용요금이 600원일 때 이 손님이 계산해야 할 금액을 출력하세요
		
		//입력(준비)
		int pay = 600;
		int startHour = 7, startMinute = 50;
		int endHour = 9, endMinute = 15;
		
		//처리
		//- 가장 작은 단위로 변환하여 계산 후 복원
		//- 금액을 분단위로 환산하여 시간과 합산
		int minutePay = pay / 60;
		int startTotal = startHour * 60 + startMinute;
		int endTotal = endHour * 60 + endMinute;
		
		int payTime = endTotal - startTotal;
		int payHour  = payTime /60;
		int payMinute = payTime % 60;
		int payTotal = payTime * minutePay;
		
		//출력(결과)
		System.out.println(payHour + "시간");
		System.out.println(payMinute + "분");
		System.out.println(payTotal + "원");			
	}
}