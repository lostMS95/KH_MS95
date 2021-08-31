package oop.constructor4;

public class Hotel {

	// 멤버 변수
	private String room;
	private int person;
	private int low;
	private int middle;
	private int high;

	//멤버 메소드
	public void setRoom(String room) {
		this.room = room;
	}

	public void setPerson(int person) {
		//2명 미만일 경우 2명으로 설정하기 위한 코드
		if (person < 2) {
			person = 2;
		}
		this.person = person;
	}

	public void setLow(int low) {
		if (low < 0) {
			return;
		}
		this.low = low;
	}

	public void setMiddle(int middle) {
		if (middle < 0) {
			return;
		}
		this.middle = middle;
	}

	public void setHigh(int high) {
		if (high < 0) {
			return;
		}
		this.high = high;
	}

	public String getRoom() {
		return this.room;
	}

	public int getPerson() {
		return this.person;
	}

	public int getLow() {
		return this.low;
	}

	public int getMiddle() {
		return this.middle;
	}

	public int getHigh() {
		return this.high;
	}
	
	//생성자
		//[1] 이름 + 인원수 + 비성수기요금 
		//[2] 이름 + 인원수 + 비성수기요금 + 성수기요금
		//[3] 이름 + 인원수 + 비성수기요금 + 준성수기요금 + 성수기요금
	public Hotel(String room, int person, int low) {
		this.setRoom(room);
		this.setPerson(person);
		this.setLow(low);
		this.setMiddle(low);
		this.setHigh(low);
	}

	public Hotel(String room, int person, int low, int high) {
		this.setRoom(room);
		this.setPerson(person);
		this.setLow(low);
		this.setMiddle(high);
		this.setHigh(high);
	}

	public Hotel(String room, int person, int low, int middle, int high) {
		this.setRoom(room);
		this.setPerson(person);
		this.setLow(low);
		this.setMiddle(middle);
		this.setHigh(high);
	}

	public void showInfo() {
		System.out.println("<KH호텔 객실요금>");
		System.out.println(this.room);
		System.out.println(this.person + "명");
		System.out.println(this.low + "원");
		System.out.println(this.middle + "원");
		System.out.println(this.high + "원");
	}

}
