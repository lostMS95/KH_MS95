package oop.keyword2;

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


	//생성옵션 1 : 아무것도 설정하지 않고 생성
	public User() {//기본 생성자 : 외부에서 어떠한 값도 받지 않는 생성자
		this.setTitle("Untitle");
		this.width = 600;
		this.height = 400;
	}
	public User(String title, int width, int heigth) {
		this.setTitle(title);
		this.width = width;
		this.height = heigth;
	}

	public User(int width, int heigth) {
		this.setTitle("Untitle");
		this.width = width;
		this.height = heigth;
	}

	public User(String title) {
		this.setTitle(title);
		this.width = 600;
		this.height = 400;
	}

	public void showInfo() {
		System.out.println(this.title);
		System.out.println(this.width);
		System.out.println(this.height);
	}

}
