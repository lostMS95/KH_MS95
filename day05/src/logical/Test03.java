package logical;
import java.lang.*;
import java.time.LocalDate;
import java.util.Calendar;
public class Test03 {
	public static void main(String[] args) {
		
		//입력(준비)
		int birth = 2000;
		
		//처리(계산)
		int thisYear = 2021;
		//int thisYear = LocalDate.now().getYear();
		//int thisYear = Calendar.getInstance().get(Calendar.YEAR);
		int age = thisYear - birth + 1;
		
		boolean adult = age >= 20;
		
		//출력(결과)
		System.out.println(age);
		System.out.println(adult);
	}
}
