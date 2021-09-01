package oop.inherit3;

public class Test01 {
	public static void main(String[] args) {
		// 각 브라우저의 객체를 생성하고 기능들을 실행
		Chrome a = new Chrome();
		Edge b = new Edge();
		Whale c = new Whale();

		a.setUrl("www.naver.com");
		System.out.println(a.getUrl());
		a.refresh();
		a.move();
		a.develop();
		a.chromeStore();

		b.setUrl("www.daum.com");
		System.out.println(b.getUrl());
		b.refresh();
		b.move();
		b.fullScreen();

		c.setUrl("www.google.com");
		System.out.println(c.getUrl());
		c.refresh();
		c.move();
		c.papago();
		c.naverSearch();

	}
}
