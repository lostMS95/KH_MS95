package oop.poly2;

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
		int phone = IPHONE11;
		int action = CALL_ACTION;

		if (phone == GALAXY21S && action == CAMERA_ACTION) {
			Galaxy21s a = new Galaxy21s();
			a.camera();
		} else if (phone == GALAXY21S && action == GALLERY_ACTION) {
			Galaxy21s a = new Galaxy21s();
			a.gallery();
		} else if (phone == GALAXY21S && action == CALL_ACTION) {
			Galaxy21s a = new Galaxy21s();
			a.call();
		} else if (phone == GALAXY21S && action == SMS_ACTION) {
			Galaxy21s a = new Galaxy21s();
			a.sms();
		} else if (phone == GALAXYFOLD3 && action == CAMERA_ACTION) {
			GalaxyFold3 b = new GalaxyFold3();
			b.camera();
		} else if (phone == GALAXYFOLD3 && action == GALLERY_ACTION) {
			GalaxyFold3 b = new GalaxyFold3();
			b.gallery();
		} else if (phone == GALAXYFOLD3 && action == CALL_ACTION) {
			GalaxyFold3 b = new GalaxyFold3();
			b.call();
		} else if (phone == GALAXYFOLD3 && action == SMS_ACTION) {
			GalaxyFold3 b = new GalaxyFold3();
			b.sms();
		} else if (phone == IPHONE11 && action == CAMERA_ACTION) {
			IPhone11 c = new IPhone11();
			c.camera();
		} else if (phone == IPHONE11 && action == GALLERY_ACTION) {
			IPhone11 c = new IPhone11();
			c.gallery();
		} else if (phone == IPHONE11 && action == CALL_ACTION) {
			IPhone11 c = new IPhone11();
			c.call();
		} else if (phone == IPHONE11 && action == SMS_ACTION) {
			IPhone11 c = new IPhone11();
			c.sms();
		} else if (phone == IPHONE12 && action == CAMERA_ACTION) {
			IPhone12 d = new IPhone12();
			d.camera();
		} else if (phone == IPHONE12 && action == GALLERY_ACTION) {
			IPhone12 d = new IPhone12();
			d.gallery();
		} else if (phone == IPHONE12 && action == CALL_ACTION) {
			IPhone12 d = new IPhone12();
			d.call();
		} else if (phone == IPHONE12 && action == SMS_ACTION) {
			IPhone12 d = new IPhone12();
			d.sms();
		}

	}
}
