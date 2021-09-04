package oop.poly3;

public class Test01 {
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
		int phone = IPHONE12;
		int action = SMS_ACTION;
		
//		Phone p = 갤럭시21s객체 or 갤럭시폴드3객체 or 아이폰11객체 or 아이폰12객체;
			Phone p;
		if(phone == GALAXY21S) {
			p = new Galaxy21s();
		}
		else if(phone == GALAXYFOLD3) {
			p = new GalaxyFold3();
		}
		else if(phone == IPHONE11) {
			p = new IPhone11();
		}
		else if(phone == IPHONE12) {
			p = new IPhone12();
		}
		else {
			p = null;
		}
		
		//행동 조건 : 휴대폰이 뭐든 다 똑같은 기능이 있습니다.
		if(action == CAMERA_ACTION) {
			p.camera();
		}
		else if(action == GALLERY_ACTION) {
			p.gallery();
		}
		else if(action == CALL_ACTION) {
			p.call();
		}
		else if(action == SMS_ACTION) {
			p.sms();
		}
		
	}
}