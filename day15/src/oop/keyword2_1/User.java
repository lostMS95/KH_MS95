package oop.keyword2_1;

public class User {

	private String title;
	private final int width;
	private final int height;

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}
	//생성자 몰아주기 : 코드의 중복을 감소시키 위해 다 설정하는 생성자에게 모든 데이터설정을 위임

	//생성옵션 1 : 아무것도 설정하지 않고 생성
	public User() {//기본 생성자 : 외부에서 어떠한 값도 받지 않는 생성자
		this("Untitle", 600, 400);
	}
	public User(String title, int width, int height) {
		this.setTitle(title);
		
		if(width > 0) {
			this.width = width;
		}
		else {
			this.width = 600;
		}
		
		if(height > 0) {
			this.height =  height;
		}
		else {
			this.height = 400;
		}
	}

	public User(int width, int height) {
		this("Untitle", width, height);
	}

	public User(String title) {
		this(title, 600, 400);
	}

	public void showInfo() {
		System.out.println(this.title);
		System.out.println(this.width);
		System.out.println(this.height);
	}

}
