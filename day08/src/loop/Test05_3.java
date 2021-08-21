package loop;
import java.lang.*;
import java.util.Scanner;
public class Test05_3 {
	public static void main(String[] args) {
		
		//입력(준비)
		Scanner sc = new Scanner(System.in);
		System.out.println("단 입력");
		int dan = sc.nextInt();
		sc.close();
		
		//출력(결과)
		for(int i = 1 ; i <= 9 ; i += 1) {
			System.out.println(dan + " X " + i + " = " + (dan * i));
		}
	}
}
