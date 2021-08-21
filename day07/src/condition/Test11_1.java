package condition;
import java.lang.*;
public class Test11_1 {
	public static void main(String[] args) {
		
		//입력
		int second = 7700;
		
		//출력
		if(second <= 10) {
			System.out.println("방금 전");
		}
		else if(second < 60) {
			System.out.println(second+"초 전");
		}
		else if(second < 60 * 60) {
			System.out.println(second / 60 + "분 전");
		}
		else if(second < 24 * 60 * 60) {
			System.out.println(second / 60 / 60 + "시간 전");
		}
		else {
			System.out.println(second / 60 / 60 / 24 + "일 전");
		}
	}
}
