package logical;
import java.lang.*;
public class Test04 {
	public static void main(String[] args) {
		
		//입력(준비)
		int speed = 109;
		int limit = 100;
		int permit = 10;//여유치(%)
		
		//처리(계산)
		int fixLimit = limit * (100 + permit) / 100;
		//int fixLimit = (int) (limit * (1 + permit / 100.0));
		System.out.println(fixLimit);
		boolean over = speed > fixLimit;
		
		//출력(결과)
		System.out.println(over);
	}
}
