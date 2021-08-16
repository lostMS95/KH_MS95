package decimal;
import java.lang.*;
public class Test04_1 {
	public static void main(String[] args) {
		//하루에 1시간 30분씩 20일간 공부했을 때의 총 공부 시간을 계산해서 출력하세요
		
		//입력(준비)
		int hour = 1, minute = 30;
		int period = 20;
		
		//처리
		int total = hour * 60 + minute; //하루의 총 시간(분)
		int totalTime = total * period;
		int totalDay = totalTime / 60 / 24;
		int totalHour  = totalTime/ 60 % 24;
		int totalMinute = totalTime%60;
		
		//출력
		System.out.println(totalDay + "일");
		System.out.println(totalHour + "시간");
		System.out.println(totalMinute + " 분 ");
	}
}
