package oop.keyword9;

public class Account {
	// 정적데이터 - static 변수
	private static float basic;

	public static float getBasic() {
		return basic;
	}

	public static void setBasic(float basic) {
		Account.basic = basic;
		if (basic < 0f) {
			return;
		}
	}

	// 동적 데이터 - 멤버 변수
	private String name;
	private float prefer;
	private int balance;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrefer() {
		return prefer;
	}

	public void setPrefer(float prefer) {
		if (prefer < 0) {
			return;
		}
		this.prefer = prefer;
	}

	public int getBalance() {
		return balance;

	}

	public void setBalance(int balance) {
		if (balance < 0) {
			return;
		}
		this.balance = balance;
	}

	public Account(String name, float prefer, int balance) {
		this.name = name;
		this.prefer = prefer;
		this.balance = balance;
	}

	public void showInfo() {
		System.out.println(this.name);
		System.out.println(Account.basic);
		System.out.println(this.prefer);
		System.out.println(this.balance);
	}

}
