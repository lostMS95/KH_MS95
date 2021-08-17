package realnumber;
import java.lang.*;
public class Test03_2 {
	public static void main(String[] args) {
		
		//입력(준비)
		int price = 159000;//결제금액
		int rate = 25;//할인율
		
		//처리
		double discount = price * (100-rate)/100.0;
		
		int result = (int)discount;//강제 변환(double을 int에 딱 맞게 강제로 변환)
		
		//출력(결과)
		System.out.println(result);
	}
}