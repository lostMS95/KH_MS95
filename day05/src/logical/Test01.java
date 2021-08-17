package logical;
import java.lang.*;
public class Test01 {
	public static void main(String[] args) {
		//Q : 시내 과속방지 카메라는 어떤 원리로 작동하게 되는가?
		
		//입력
		int speed = 55;
		
		//처리 - 과속인지 아닌지 판정(50km 이상일 경우 과속)
		System.out.println(speed >= 50);
	}
}
