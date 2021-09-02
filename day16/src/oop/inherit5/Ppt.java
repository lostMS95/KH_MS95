package oop.inherit5;

public class Ppt extends File {
	// +@ 구현

	private int pageSize;

	public void setPageSize(int pageSize) {
		if (pageSize < 0) {
			return;
		}
		this.pageSize = pageSize;
	}

	public int getPageSize() {
		return this.pageSize;
	}

	public void information() {
		System.out.println("[파일 정보 확인]");
//		System.out.println("파일명 : " + this.getFileName());//내꺼에 없으므로 부모클래스 탐색
		System.out.println("파일명 : " + super.getFileName());// 부모클래스 탐색
//		System.out.println("파일 크기 : " + this.getFileSize() + "bytes");
		System.out.println("파일 크기 : " + super.getFileSize() + "bytes");
//		System.out.println("프레젠테이션 크기 : " + this.pageSize + "장");
		System.out.println("프레젠테이션 크기 : " + this.getPageSize() + "장");
//		System.out.println("프레젠테이션 크기 : " + super.getPageSize() + "장");//error(없음)
	}
}