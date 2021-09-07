package api.regex;

import java.util.regex.Pattern;

public class Test04 {
	public static void main(String[] args) {

		String mail = "rmsdn0415@nnnnaver.co.kr";
		String regex = "^[a-z]([a-z\\d-_]){4,19}@[a-z]{8,10}(\\.com|\\.co\\.kr|\\.net)$";

		boolean result = Pattern.matches(regex, mail);

		if (result) {
			System.out.println("올바른 형식의 이메일입니다");
		} else {
			System.out.println("이메일을 정확하게 작성하세요");
		}
	}
}
