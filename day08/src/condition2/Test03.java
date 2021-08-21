package condition2;
import java.lang.*;
import java.util.Scanner;
public class Test03 {
	public static void main(String[] args) {
		
		//입력
		Scanner sc = new Scanner(System.in);
	    System.out.println("");
		int score = sc.nextInt();
		sc.close();
		
		//처리
		String grade;
		if(score >= 90 && score <= 100) {
			grade = "A등급";
		}
		else if(score >= 70 && score < 90) {
			grade = "B등급";
		}
		else {
			grade = "C등급";
		}
		
		//출력
		System.out.println(grade);
	}
}
