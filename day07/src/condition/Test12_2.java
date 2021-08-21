package condition;
import java.util.Calendar;
public class Test12_2 {
	public static void main(String[] args) {
		//입력(준비)
		int year = 2020;
		int month = 2;
		
		//처리(계산)
		Calendar c = Calendar.getInstance();
		c.set(year, month-1, 1);
		int day = c.getActualMaximum(Calendar.DATE);
		
		//출력(결과)
		System.out.println(day);
	}
}
