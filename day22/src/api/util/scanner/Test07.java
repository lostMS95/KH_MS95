package api.util.scanner;

import java.io.File;
import java.util.Scanner;

public class Test07 {
	public static void main(String[] args) {
		// 파일 객체 생성
		File file = new File("readme");
		try {
			Scanner sc = new Scanner(file);

			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}

			sc.close();
		} catch (Exception e) {
			System.err.println("파일이 없습니다");
		}
	}
}