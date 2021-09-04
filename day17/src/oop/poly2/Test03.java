package oop.poly2;

public class Test03 {
	public static final int GALAXY21S = 1;
	public static final int GALAXYFOLD3 = 2;
	public static final int IPHONE11 = 3;
	public static final int IPHONE12 = 4;

	public static final int CAMERA_ACTION = 1;
	public static final int GALLERY_ACTION = 2;
	public static final int CALL_ACTION = 3;
	public static final int SMS_ACTION = 4;

	public static void main(String[] args) {
//		int phone = 1 or 2 or 3 or 4;
//		int action = 1 or 2 or 3 or 4;
		int phone = IPHONE11;
		int action = CALL_ACTION;

//		상황별로 조건을 구현하여 코드를 작성(16가지)
		if (phone == GALAXY21S) {
			Galaxy21s a = new Galaxy21s();
			if (action == CAMERA_ACTION) {
				a.camera();
			} else if (action == GALLERY_ACTION) {
				a.gallery();
			} else if (action == CALL_ACTION) {
				a.call();
			} else if (action == SMS_ACTION) {
				a.sms();
			}
		} else if (phone == GALAXYFOLD3) {
			GalaxyFold3 a = new GalaxyFold3();
			if (action == CAMERA_ACTION) {
				a.camera();
			} else if (action == GALLERY_ACTION) {
				a.gallery();
			} else if (action == CALL_ACTION) {
				a.call();
			} else if (action == SMS_ACTION) {
				a.sms();
			}
		} else if (phone == IPHONE11) {
			IPhone11 a = new IPhone11();
			if (action == CAMERA_ACTION) {
				a.camera();
			} else if (action == GALLERY_ACTION) {
				a.gallery();
			} else if (action == CALL_ACTION) {
				a.call();
			} else if (action == SMS_ACTION) {
				a.sms();
			}
		} else if (phone == IPHONE12) {
			IPhone12 a = new IPhone12();
			if (action == CAMERA_ACTION) {
				a.camera();
			} else if (action == GALLERY_ACTION) {
				a.gallery();
			} else if (action == CALL_ACTION) {
				a.call();
			} else if (action == SMS_ACTION) {
				a.sms();
			}
		}

	}
}
