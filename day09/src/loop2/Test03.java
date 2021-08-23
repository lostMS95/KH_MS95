package loop2;
import java.util.Scanner;
public class Test03 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int total = 0;
		int round = 1; //진행되는 라운드를 표시하기 위한 변수
		
		while (total <=100) {
			
			System.out.println("round " + round +" 숫자 입력");
			int num = sc.nextInt();
			
			total += num;
			System.out.println("현재까지 합 : " + total);

			round++;
			
		}
		
		System.out.println("Game Over");
		sc.close();
	}
}
