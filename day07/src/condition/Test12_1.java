package condition;
import java.lang.*;
import java.util.Scanner;
public class Test12_1 {
	public static void main(String[] args) {
		//입력(준비)
		Scanner sc =new Scanner(System.in);
		System.out.println("연도 입력 : ");
		int year = sc.nextInt();
		System.out.println("달 입력 : ");
		int month = sc.nextInt();
		
		//처리(계산)
		//int day = 31 or 30 or 29 or 28;
		int day;
		if(month == 2) {
			boolean is400 = year % 400 == 0;
			boolean is4 = year % 4 == 0;
			boolean is100 = year % 100 == 0;
			if(is400 || (is4 && !is100)) {//윤년이면 : [1] 400의 배수라면 or [2] 4의 배수이면서 100의 배수가 아니라면
				day = 29;
			}
			else {
				day = 28;
			}
		}
		else if(month == 4 || month == 6 || month == 9 || month == 11) {//작은달이면 : 4, 6, 9, 11
			day = 30;
		}
		else {//큰달이면 : 1, 3, 5, 7, 8, 10, 12
			day = 31;
		}
		
		
		//출력(결과)
		System.out.println(day);
	}
}
