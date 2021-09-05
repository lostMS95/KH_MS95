package oop.inner2;

public class Police {
	private Gun gun;

	public void setGun(Gun gun) {
		this.gun = gun;
	}

	public Gun getGun() {
		return gun;
	}

	// 경찰만이 권총을 사용할 수 있도록
	// = 경찰 클래스 내부에 권총 클래스를 구현
	// = 경찰 외부에서는 Gun이 있는지 알 수 없음
	private class Gun {
		// 클래스이므로 이 안에 구성요소를 모두 가질 수 있다.
		// = 멤버 변수, 메소드, 생성자, 중첩클래스
	}
}