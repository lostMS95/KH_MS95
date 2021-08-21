package input;
import java.lang.*;
public class Test03 {
	public static void main(String[] args) {
		//입력(준비)
		String name = "홍길동";
		int korean = 75;
		int english = 80;
		
		//처리(계산)
		int total = korean + english;
		float average = total / 2f;
		
		//출력(결과)
		System.out.println("이름 : " + name);
		System.out.println("총점 : " + total + "점");
		System.out.println("평균 : " + average + "점");
	}
}
