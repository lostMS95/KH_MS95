package oop.multi6;

import oop.multi5.Computer;
import oop.multi5.Electronic;
import oop.multi6.box.AllInOneBox;

public class Test03 {
	public static void main(String[] args) {
		//all-in-one-box(제네릭 클래스)의 사용법
		
		//AllInOneBox의 E를 String으로 설정하여 생성
		AllInOneBox<String> box1 = new AllInOneBox<String>();
		box1.setValue("hello");
		System.out.println(box1.getValue());
		
		AllInOneBox<Electronic> box2 = new AllInOneBox<Electronic>();
		Computer c = new Computer("슈퍼컴퓨터");
		box2.setValue(c);
		System.out.println(box2.getValue());
}
}