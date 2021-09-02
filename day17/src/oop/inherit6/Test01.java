package oop.inherit6;

public class Test01 {
	public static void main(String[] args) {
		Ppt f1 = new Ppt("test.pptx", 1200L);
		f1.execute();
		
		Avi f2 = new Avi("test.avi", 10000L);
		f2.execute();
	}
}