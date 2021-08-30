package oop.basic3;

public class Test01 {
	public static void main(String[] args) {

		// 객체생성
		Player first = new Player();
		Player second = new Player();
		Player third = new Player();

		// 초기화
		first.init("김연아", "피겨스케이팅", 2, 0, 1);
		second.init("이상화", "스피드스케이팅", 1, 2, 1);
		third.init("윤성빈", "스켈레톤", 2, 0, 1);

		// 출력
		first.showInfo(); // first를 주인공으로 해서 showInfo 코드 실행!
		second.showInfo(); // second를 주인공으로 해서 showInfo 코드 실행!
		third.showInfo(); // third를 주인공으로 해서 showInfo 코드 실행!

	}
}
