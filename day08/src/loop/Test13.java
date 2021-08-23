package loop;

public class Test13 {
	public static void main(String[] args) {

		long coin = 1;
		long total30 = 0;
		long total40 = 0;

		for (int i = 1; i <= 40; i++) {
			System.out.println(i + "일차 :" + coin + "원");
			if (i <= 30) {
				total30 += coin;
				coin *= 2;
			} else {
				total40 += coin;
				coin *= 2;
			}
		}
		System.out.println("30일 총 수입 : " + total30 + "원");
		System.out.println("40일 총 수입 : " + total40 + "원");

	}
}
