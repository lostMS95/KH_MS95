package oop.multi5;

public class Camera extends Electronic implements Brokenable {

	public Camera(String name) {
		super(name);

	}

	@Override
	public void on() {
		System.out.println("카메라 전원 on");

	}

	@Override
	public void off() {
		System.out.println("카메라 전원 off");

	}

}
