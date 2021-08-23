package loop;

public class Test12 {
	public static void main(String[] args) {

		int push = 10;
		int total = 0;

		for (int i = 1; i <= 30; i++) {

			System.out.println(i + "일차 :" + push + "개");
			total += push;
			push += 3;

		}
		System.out.println("총 갯수 : " + total + "개");
	}
}
