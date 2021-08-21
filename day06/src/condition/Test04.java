package condition;
import java.lang.*;
public class Test04 {
	public static void main(String[] args) {
		//(ex) 지하철 무임승차 대상인가?
		//= 65세 이상 어르신은 무임승차 대상
		//= 7세 이하 영유아는 무임승차 대상
		//= 7세 이하이면서 65세 이상일 수 있는가? 불가능
		//= 7세 이하 또는 65세 이상
		
		//입력
		int age = 75;
		
		//처리
		boolean upper = age >= 65;
		boolean lower = age <= 7;
		System.out.println("upper = " + upper);
		System.out.println("lower = " + lower);
		
		//boolean isFree = upper || lower;
		boolean isFree = age >= 65 || age <= 7;
		System.out.println("무임승차? " + isFree);
	}
}
