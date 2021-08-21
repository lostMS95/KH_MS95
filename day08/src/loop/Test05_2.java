package loop;
import java.lang.*;
public class Test05_2 {
	public static void main(String[] args) {
		
		//입력(준비)
		int dan = 3;
		
		//출력(결과)
		for(int i = 1 ; i <= 9 ; i += 1) {
			System.out.println(dan + " X " + i + " = " + (dan * i));
		}
	}
}
