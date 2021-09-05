package oop.multi6;

import oop.multi6.product.Camera;
import oop.multi6.product.Computer;

public class Test01 {
	public static void main(String[] args) {

		Computer com = new Computer("슈퍼컴퓨터");
		com.on();
		com.off();
		
		Camera cam = new Camera("DSLR카메라");
		
		cam.on();
		cam.off();
}
}