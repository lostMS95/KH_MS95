package oop.modifier2;

public class Phone {
	// 멤버 변수 - 멤버 변수는 private으로 잠금 처리
	private String name;
	private String telecom;
	private int period;
	private int price;

	// 멤버 메소드
	public void setName(String name) {
		this.name = name;
	}

	public void setTelecom(String telecom) {
		switch (telecom) {
		case "SKT":
		case "KT":
		case "LGU+":
		case "알뜰폰":
			this.telecom = telecom;
		}
	}

	public void setPeriod(int period) {
		switch (period) {
		case 24:
		case 30:
		case 36:
			this.period = period;
		}
	}

	public void setPrice(int price) {
		if (price > 0) {
			this.price = price;
		}
	}

	public void init(String name, String telecom, int period, int price) {
		this.setName(name);
		this.setTelecom(telecom);
		this.setPeriod(period);
		this.setPrice(price);
	}

	public String getName() {

		return this.name;
	}

	public String getTelecom() {
		return this.telecom;
	}

	public int getPeriod() {

		return this.period;
	}

	public int getPrice() {
		return this.price;
	}

	public void showInfo() {
		System.out.println("<휴대폰 정보>");
		System.out.println(this.name);
		System.out.println(this.telecom);
		System.out.println(this.period);
		System.out.println(this.price);
	}
}
