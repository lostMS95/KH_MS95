import java.lang.*;
public class Calculate6 {
	public static void main(String[] args) {
		
		//입력(준비) - 변수 저장
		int adultRerson = 2, adultPrice = 1250;
		int youthRerson = 2,  youthPrice = 720;
		int childRerson = 1, childPrice = 450;
		
		//계산
		int adultTotal = adultRerson * adultPrice;
		int youthTotal = youthRerson * youthPrice;
		int childTotal = childRerson * childPrice;
		int total = adultTotal + youthTotal + childTotal;
		
		//출력
		System.out.println(adultTotal);
		System.out.println(youthTotal);
		System.out.println(childTotal);
		System.out.println(total);
	}
}
