package api.regex;

import java.util.regex.Pattern;

public class Test02 {
	public static void main(String[] args) {
		//정규 표현식(REGEX, REGular EXpression)
		//= 문자열을 검사하는 식

		String phoneNumber = "010-1212-3434";
//		String regex = "^010-[0123456789][0123456789][0123456789][0123456789]-[0123456789][0123456789][0123456789][0123456789]$";
//		String regex = "^01[016-9]-[0-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]$";
//		String regex = "^01[016-9]-[0-9]{4}-[0-9]{4}$";
		String regex = "^01[016-9](-[0-9]{4}){2}$";

		boolean result = Pattern.matches(regex, phoneNumber);
		System.out.println("result = " + result);
	}
}