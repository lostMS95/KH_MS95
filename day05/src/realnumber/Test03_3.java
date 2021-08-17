package realnumber;
import java.lang.*;
public class Test03_3 {
	public static void main(String[] args) {
		
		//입력(준비)
		int price = 159000;//결제금액
		int rate = 30;//할인율
		
		//처리
		int result = price * (100-rate) / 100;
		//int result = price / 100 * (100-rate);//나누기를 먼저하면 손실 발생 가능성 있음
		
		//출력(결과)
		System.out.println(result);
	}
}