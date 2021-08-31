package oop.constructor3;

public class User {
	// 멤버 변수
	private String id;
	private String job;
	private int level;
	private int money;

	// 세터 & 게터
	public void setId(String id) {
		this.id = id;
	}

	public void setJob(String job) {
		switch (job) {
		case "전사":
		case "마법사":
		case "궁수":
		}

		this.job = job;
	}

	public void setLevel(int level) {
		if (level < 1) {
			return;
		}
		this.level = level;
	}

	public void setMoney(int money) {
		if (money >= 0) {
			this.money = money;
		}
	}

	public String getIId() {
		return this.id;
	}

	public String getIJob() {
		return this.job;
	}

	public int getLevel() {
		return this.level;
	}

	public int getMoney() {
		return this.money;
	}

	// 생성자
	// [1] 아이디와 직업만 설정하는 생성자. 이 때 레벨은 1, 소지금은 0Gold
	// [2] 아이디, 직업, 레벨, 소지금을 설정할 수 있는 생성자
	public User(String id, String job) {
		this.setId(id);
		this.setJob(job);
		this.setLevel(1);
		this.setMoney(0);
	}

	public User(String id, String job, int level, int money) {
		this.setId(id);
		this.setJob(job);
		this.setLevel(level);
		this.setMoney(money);
	}

	public void showInfo() {
		System.out.println("<게임 캐릭터 정보>");
		System.out.println(this.id);
		System.out.println(this.job);
		System.out.println(this.level);
		System.out.println(this.money);
	}
}
