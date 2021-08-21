package condition;
import java.lang.*;
import java.util.Scanner;
public class Test10 {
	public static void main(String[] args) {
		
		//입력
		int month = 1;
		int days = 5;
		
		//처리
		//int discountRate = 10 or 40 or 30 or 20;
		int discountRate;

		if(month == 3 || month == 4 || month == 5) {//3,4,5월이라면
		//if(month >= 3 && month <= 5) {//3월부터 5월 사이라면
			discountRate = 10;
		}
		else if(month == 6 || month == 7 || month == 8) {//6,7,8월이라면
		//else if(month >= 6 && month <= 8) {//6월부터 8월 사이라면
			discountRate = 40;
		}
		else if(month == 9 || month == 10 || month == 11) {//9,10,11월이라면
		//else if(month >= 9 && month <= 11) { //9월부터 11월 사이라면
			discountRate = 30;
		}
		else {
			discountRate = 20;
		}
		
		//출력
		System.out.println("할인율 : "+discountRate+"%");
		
	}
}