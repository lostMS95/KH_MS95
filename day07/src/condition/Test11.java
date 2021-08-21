package condition;
import java.lang.*;
public class Test11 {
	public static void main(String[] args) {
		
		//입력
		int second = 2 * 24 * 60 * 60;
		
		//출력
		System.out.println("방금 전");
		System.out.println(second+"초 전");
		System.out.println(second / 60 + "분 전");
		System.out.println(second / 60 / 60 + "시간 전");
		System.out.println(second / 60 / 60 / 24 + "일 전");
	}
}
