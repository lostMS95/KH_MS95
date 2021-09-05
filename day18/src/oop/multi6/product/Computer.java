package oop.multi6.product;

public class Computer extends Electronic implements Brokenable {

	public Computer(String name) {
		super(name);

	}

	@Override
	public void on() {
		System.out.println("컴퓨터 전원 on");

	}

	@Override
	public void off() {
		System.out.println("컴퓨터 전원 off");

	}

}
