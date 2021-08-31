package oop.constructor4;

public class Test01 {
	public static void main(String[] args) {
		
		Hotel a = new Hotel("스탠다드룸",4,100000,200000,250000);
		Hotel b = new Hotel("슈페리어룸",4,150000,250000,300000);
		Hotel c = new Hotel("디럭스룸",6,300000,550000);
		Hotel d = new Hotel("프리미어룸",8,1000000);
		
		
		
		
		a.showInfo();
		b.showInfo();
		c.showInfo();
		d.showInfo();
	}
}
