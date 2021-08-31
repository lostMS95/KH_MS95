package oop.method6;

public class Student {

	String name;
	String level;
	int kor;
	int eng;
	int math;

	void init(String name, String level, int kor, int eng, int math) {
		this.setName(name);
		this.setLevel(level);
		this.setKor(kor);
		this.setEng(eng);
		this.setMath(math);
	}

	void setName(String name) {
		this.name = name;
	}

	void setLevel(String level) {
		this.level = level;
	}

	void setKor(int kor) {
		if (kor > 0 && kor <= 100) {
			this.kor = kor;
		}
	}

	void setEng(int eng) {
		this.eng = eng;
		if (eng > 0 && eng <= 100) {
		}
	}

	void setMath(int math) {
		if (math > 0 && math <= 100) {
			this.math = math;
		}
	}

	String getName() {
		return this.name;
	}

	String getLevel() {
		return this.level;
	}

	int getKor() {

		return this.kor;
	}

	int getEng() {
		return this.eng;
	}

	int getMath() {
		return this.math;
	}

	int getTotal() {
		return this.getKor() + this.getEng() + this.getMath();
	}

	float getAver() {
		return this.getTotal() / 3.0f * 100 / 100;
	}

	String getGrade() {
		if (this.getAver() >= 90) {
			return "A";
		} else if (this.getAver() >= 80) {
			return "B";
		} else if (this.getAver() >= 70) {
			return "C";
		} else {
			return "F";
		}
	}

	void showInfo() {
		System.out.println("<성적 정보>");
		System.out.println("이름 :" + this.name);
		System.out.println("학년 : " + this.level);
		System.out.println("국어점수 : " + this.kor + "점");
		System.out.println("국어점수 : " + this.eng + "점");
		System.out.println("국어점수 : " + this.math + "점");
		System.out.println("총점 : " + this.getTotal() + "점");
		System.out.println("평균 : " + this.getAver() + "점");
		System.out.println("등급 : " + this.getGrade());
	}
}
