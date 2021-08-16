import java.lang.*;
public class Calculate5 {
	public static void main(String[] args) {
		//문제점
		//1. 무슨값이 얼마인지 알 수 없다(해결)
		//2. 매번 식을 입력해야 한다(해결)
		//3. 자장면, 짬뽕, 개수 등이 변하면 식을 일일이 고쳐야 한다(해결)

		int chinaNoodlePrice = 5000;
		int chinaNoodleCount = 2;
		int champonPrice = 6000;
		int champonCount = 2;

		int chinaNoodleTotal = chinaNoodlePrice * chinaNoodleCount;
		int champonTotal = champonPrice * champonCount;

		int total = chinaNoodleTotal + champonTotal;

		System.out.println(chinaNoodleTotal);
		System.out.println(champonTotal);
		System.out.println(total);
	}
}