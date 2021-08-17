package decimal;
import java.lang.*;
public class Test03 {
		public static void main(String[] args) {
			//1번문제
			//- 3시간 35분은 몇 분인지 계산하여 출력해보세요
			
			//입력(준비)
			int hour = 3, minute = 35;
			
			//처리 : 1시간은 60분이다
			int wMinute = hour * 60;
			int total = wMinute + minute;
			
			//출력(결과)
			System.out.println(total);
	
			//2번문제
			//- 사람처럼 풀 수도, 컴퓨터처럼 풀 수도 있다.
			
			//입력
			int yesterdayHour= 2, yesterdayMinute = 50;
			int nowHour = 4, nowMinute = 30;
			
			//처리1 : 사람이 푸는 방식(비추천)
			int totalHour = yesterdayHour + nowHour+  (yesterdayMinute + nowMinute) / 60;
			int totalMinute = (yesterdayMinute + nowMinute) % 60;
			
			//출력1
			System.out.println(totalHour + "시간" + totalMinute + "분");
			
			//처리2 : 컴퓨터가 푸는 방식(가장 낮은 단위로 변환하여 계산 후 복원)
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
