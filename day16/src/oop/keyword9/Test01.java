package oop.keyword9;

public class Test01 {
	public static void main(String[] args) {
		
		Account.setBasic(1.2f);
		
		Account a = new Account("유재석",0.3f,5000000);
		Account b = new Account("강호동",0.5f,3500000);
		Account c = new Account("신동엽",0.2f,8000000);
		
		//Account.setBasic(1.3f);//static-way
		//a.setBasic(1.3f);//non static-way
		
		a.showInfo();
		b.showInfo();
		c.showInfo();
		
	}
}
