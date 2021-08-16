package decimal;
import java.lang.*;
public class Test02 {
	public static void main(String[] args) {
		
		//입력(준비)
		int kimbabPrice = 1000;
		int kimbabCount = 5;
	
	
		//계산
		int freeCount =kimbabCount / 2;
		int payCount = kimbabCount - freeCount;
		int totalPrice = payCount * kimbabPrice;
			
		//출력(결과) - 영수증
		//System.out.println(payCount);
		//System.out.println(freeCount);
		System.out.println(totalPrice);
	}
}
