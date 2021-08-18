package total;
import java.lang.*;
public class Test01 {
	public static void main(String[] args) {
		//입력(준비)
		
		int inHour = 12,    inMinute = 34;
		int outHour = 15, outMinute = 21;
		int pay = 500;
		int period = 10;
		int dis = 2;
		
		//처리(계산)
		//1.진입시간, 진출시간을 분으로 환산
		int inTotal = inHour * 60 + inMinute; 
		int outTotal = outHour * 60 + outMinute;
		
		//2. 주차시간 계산
		int timeTotal =  outTotal - inTotal;
		
		//시간 + 분으로 환산
		int hourTotal = timeTotal / 60;
		int minuteTotal = timeTotal % 60;
		
		int perTime = timeTotal /period; 
		int payPerTime = pay * perTime;
		
		
		//2시간 넘었는지 판정
		boolean timeOver = hourTotal >= dis;
		
		//출력(결과)
		System.out.println(hourTotal + "시간" + minuteTotal + "분");
		System.out.println(payPerTime + "원");
		System.out.println(timeOver);
	}
}
