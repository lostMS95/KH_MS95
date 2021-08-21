package condition2;
import java.lang.*;
public class Test03_2 {
	public static void main(String[] args) {
		
		//입력
		int score = 85;
		
		//처리
		String grade;
		switch(score / 10) {
		case 10://100점대
		case 9://90점대
			grade = "A등급";
			break;
		case 8://80점대
		case 7://70점대
			grade = "B등급";
			break;
		default:
			grade = "C등급";
			break;
		}
		
		//출력
		System.out.println(grade);
		
	}
}
