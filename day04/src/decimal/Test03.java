package decimal;

import java.lang.*;
public class Test03 {
		public static void main(String[] args) {
			//1번문제
			
			//입력
			int hour = 3, minute = 35;
			
			
			//처리
			int wMinute = hour * 60;
			int total = wMinute + minute;
			
			//출력
			System.out.println(total);
	
			//2번문제
			
			//입력
			int yesterdayHour= 2, yesterdayMinute = 50;
			int nowHour = 4, nowMinute = 30;
			
			//처리
			int totalHour = yesterdayHour + nowHour+  (yesterdayMinute + nowMinute) / 60;
			int totalMinute = (yesterdayMinute + nowMinute) % 60;
			
			
			//출력
			System.out.println(totalHour + "시간" + totalMinute + "분");
			
			//두번째 방식 
			int yestrdayTime = yesterdayHour * 60 +  yesterdayMinute;
			int nowTime = nowHour * 60 + nowMinute;
			int totalTime = yestrdayTime + nowTime;
			int totalHour2 = totalTime / 60;
			int totealMinute2 = totalTime % 60;
			
			System.out.println(totalTime);
			System.out.println(totalHour2);
			System.out.println(totealMinute2);
			
			}
}
