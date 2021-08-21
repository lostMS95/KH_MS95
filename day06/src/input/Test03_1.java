package input;
import java.lang.*;
import java.util.Scanner;
public class Test03_1 {
	public static void main(String[] args) {
		//입력(준비)
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		int korean = sc.nextInt();
		int english = sc.nextInt();
		sc.close();
		
		//처리(계산)
		int total = korean + english;
		float average = total / 2f;
		
		//출력(결과)
		System.out.println("이름 : " + name);
		System.out.println("총점 : " + total + "점");
		System.out.println("평균 : " + average + "점");
	}
}
