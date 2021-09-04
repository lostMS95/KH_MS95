package oop.poly3;

import java.util.Scanner;

public class Test02 {
	public static final int GALAXY21S = 1;
	public static final int GALAXYFOLD3 = 2;
	public static final int IPHONE11 = 3;
	public static final int IPHONE12 = 4;

	public static final int CAMERA_ACTION = 1;
	public static final int GALLERY_ACTION = 2;
	public static final int CALL_ACTION = 3;
	public static final int SMS_ACTION = 4;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("<기종 선택>");
		System.out.println("(1) 갤럭시21s");
		System.out.println("(2) 갤럭시폴드3");
		System.out.println("(3) 아이폰11");
		System.out.println("(4) 아이폰12");
		System.out.print("선택 : ");
		int phone = sc.nextInt();
		System.out.println("<기능 선택>");
		System.out.println("(1) 카메라촬영");
		System.out.println("(2) 갤러리보기");
		System.out.println("(3) 전화걸기");
		System.out.println("(4) 문자보내기");
		System.out.print("선택 : ");
		int action = sc.nextInt();
		sc.close();

		Phone p;
		if (phone == GALAXY21S) {
			p = new Galaxy21s();
		} else if (phone == GALAXYFOLD3) {
			p = new GalaxyFold3();
		} else if (phone == IPHONE11) {
			p = new IPhone11();
		} else if (phone == IPHONE12) {
			p = new IPhone12();
		} else {
			p = null;
		}

		if (action == CAMERA_ACTION) {
			p.camera();
		} else if (action == GALLERY_ACTION) {
			p.gallery();
		} else if (action == CALL_ACTION) {
			p.call();
		} else if (action == SMS_ACTION) {
			p.sms();
		}

	}
}