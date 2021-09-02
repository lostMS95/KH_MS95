package oop.inherit6;

public class Avi extends MediaFile{
	
	private float speed;
	
	public Avi(String fileName, long fileSize) {
		super(fileName, fileSize);
		this.speed = 1f;
	}
	
	public Avi(String fileName, long fileSize, float speed) {
		super(fileName, fileSize);
		this.speed = speed;
	}

	@Override//annotation(애노테이션). 코드의 역할을 정의하는 기법(ex : 명찰)
	public void execute() {
		System.out.println("영상을 재생합니다");
	}
	
}

