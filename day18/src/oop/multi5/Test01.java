package oop.multi5;

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