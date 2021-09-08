package api.util.date;

public class Test01 {
	public static final int JANUARY = 0;
	public static final int FEBRUARY = 1;
	public static final int MARCH = 2;
	public static final int APRIL = 3;
	public static final int MAY = 4;
	public static final int JUNE = 5;
	public static final int JULY = 6;
	public static final int AUGUST = 7;
	public static final int SEPTEMBER = 8;
	public static final int OCTOBER = 9;
	public static final int NOVEMBER = 10;
	public static final int DECEMBER = 11;

	public static void main(String[] args) {
		// System.currentTimeMillis()를 이용해서 현재 날짜를 구하는 방법
		// = java.util을 이용하지 않고 하면 얼마나 힘들까?

		long current = System.currentTimeMillis();
//		System.out.println("current = " + current);

		// 연도 계산
		int yearValue = (int) (current / 1000 / 60 / 60 / 24 / 365);
		int year = yearValue + 1970;

		// 윤년 계산
		boolean yun = year % 400 == 0 || year % 100 != 0 && year % 4 == 0;

		// 월별 일자 계산
		int[] dayOfMonth = new int[12];
		dayOfMonth[JANUARY] = 31;
		if (yun) {
			dayOfMonth[FEBRUARY] = 29;
		} else {
			dayOfMonth[FEBRUARY] = 28;
		}
		dayOfMonth[MARCH] = 31;
		dayOfMonth[APRIL] = 30;
		dayOfMonth[MAY] = 31;
		dayOfMonth[JUNE] = 30;
		dayOfMonth[JULY] = 31;
		dayOfMonth[AUGUST] = 31;
		dayOfMonth[SEPTEMBER] = 30;
		dayOfMonth[OCTOBER] = 31;
		dayOfMonth[NOVEMBER] = 30;
		dayOfMonth[DECEMBER] = 31;

		// 1970년부터 지금까지 윤년 카운트
		int yunCount = 0;
		for (int i = 1970; i <= year; i++) {
			boolean y = i % 400 == 0 || i % 100 != 0 && i % 4 == 0;
			if (y) {
				yunCount++;
			}
		}

//		System.out.println("yunCount = " + yunCount);

		int dayOfUntilLastYear = yearValue * 365 + yunCount;
		int dayOfYear = (int) (current / 1000 / 60 / 60 / 24) - dayOfUntilLastYear + 1;
//		System.out.println("dayOfYear = " + dayOfYear);
		int month = 1;
		int total = 0;
		for (int i = 0; i < dayOfMonth.length; i++) {
			if (total + dayOfMonth[i] > dayOfYear) {
				break;
			} else {
				total += dayOfMonth[i];
				month++;
			}
		}

		int day = dayOfYear - total;
//		System.out.println("total = " + total);

		System.out.println("year = " + year);
		System.out.println("month = " + month);
		System.out.println("day = " + day);

		// 결과 만들기
		StringBuilder builder = new StringBuilder();

		// 연도가 4자리가 아니면 4자리가 될때까지 0으로 채운다
		for (int i = year; i < 1000; i *= 10) {
			builder.append(0);
		}
		builder.append(year);

		// 대시 추가
		builder.append('-');

		// 월이 2자리가 아니면 2자리가 될때까지 0으로 채운다
		if (month < 10) {
			builder.append(0);
		}
		builder.append(month);

		// 대시 추가
		builder.append('-');

		// 일이 2자리가 아니면 2자리가 될때까지 0으로 채운다
		if (day < 10) {
			builder.append(0);
		}
		builder.append(day);

		String result = builder.toString();
		System.out.println("result = " + result);

	}
}
