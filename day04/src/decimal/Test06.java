package decimal;
import java.lang.*;
public class Test06 {
		public static void main(String[] args) {
		
		//입력(준비)	
		int thisYear = 2021;
		int birth = 19990101;
		
		//처리
		//  /10000 = 뒤 4자리 버림. 1999
		int year = birth/10000;
		//  /100 = 뒤 2자리 버림 199901 -> %100 뒤 2자리 선택.  01
		int month = birth/100%100;
		//  %100 뒤 2자리 선택 01
		int day = birth%100;
		int age = thisYear - year + 1;
		
		//출력(결과)
		System.out.println(year);
		System.out.println(month);
		System.out.println(day);
		System.out.println(age);
	}
}
