package oop.inherit5;

public class Test01 {
	public static void main(String[] args) {

		Mp3 a = new Mp3();
		Avi b = new Avi();
		Ppt c = new Ppt();

		System.out.println("-----MP3-----");
		a.setFileName("비누.mp3");
		System.out.println(a.getFileName());
		a.setFileSize(1000L);
		System.out.println(a.getFileSize());
		a.setDuration(150);
		System.out.println(a.getDuration());
		a.execute();
		a.forward();
		a.rewind();
		
		System.out.println("-----AVI-----");
		b.setFileName("나홀로집에.AVI");
		System.out.println(b.getFileName());
		b.setFileSize(102432L);
		System.out.println(b.getFileSize());
		b.setSpeed(1.3f);
		
		b.execute();
		b.forward();
		b.rewind();
		
		System.out.println("-----PPT-----");
		c.setFileName("KH정보교육원.PPT");
		System.out.println(c.getFileName());
		c.setFileSize(12345L);
		System.out.println(c.getFileSize());
		c.setPageSize(25);
		c.execute();
		c.information();
	}
}