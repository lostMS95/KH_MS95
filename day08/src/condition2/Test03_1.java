package condition2;
import java.lang.*;
public class Test03_1 {
	public static void main(String[] args) {
		
		//입력
		int score = 85;
		
		//처리
		String grade;
		switch(score) {
		case 100: case 99: case 98: case 97: case 96: case 95: case 94: case 93: case 92: case 91: case 90:
			grade = "A등급";
			break;
		case 89: case 88: case 87: case 86: case 85: case 84: case 83: case 82: case 81: case 80:
		case 79: case 78: case 77: case 76: case 75: case 74: case 73: case 72: case 71: case 70:
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
