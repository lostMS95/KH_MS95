package oop.method4;

public class Student {

	// 멤버 변수 - 데이터
	String name;
	String type;
	int score;
	int listScore;

	// 멤버 메소드 - 코드(기능)
	// - 세터 메소드 4개 - setName, setType, setScore, setListScore
	// - init 메소드
	// - showInfo 메소드
	void setName(String name) {
		this.name = name;
	}

	void setType(String type) {
		this.type = type;
	}

	void setScore(int score) {
		if (score > 0 && score <= 100) {
			this.score = score;
		}
	}

	void setListScore(int listScore) {
		if (listScore < 0 || listScore > 100) {
			return; // 메소드 실행을 중지하는 키워드
		}
		this.listScore = listScore;
	}

	void init(String name, String type, int score, int listScore) {
		// 만들어둔 세터 메소드를 이용하면 조건 등을 중복하여 구현하지 않아도 필터링이 가능하다.
		this.setName(name);
		this.setType(type);
		this.setScore(score);
		this.setListScore(listScore);
	}

	void showInfo() {
		System.out.println("<성적 정보>");

		// 일반 정보들은 멤버 변수로 관리해야 한다.
		// = 학생의 고유정보이기 때문
		System.out.println("이름 : " + this.name);
		System.out.println("과목 : " + this.type);
		System.out.println("서술형 : " + this.score + "점");
		System.out.println("체크리스트 : " + this.listScore + "점");

		// 합계,평균,합격/불합격 정보등은 그때그때 계산해야하는 정보이다.
		// = 변경되는 점수가 반영되어야 하기 때문!
		int total = this.score + this.listScore;
		float aver = total / 2.0f;
		System.out.println("평균  : " + aver + "점");

		// boolean isPass = 서술형 40점이상 그리고 체크리스트 40점이상 그리고 평균 60이상;
		boolean isPass = this.score >= 40 && this.listScore >= 40 && aver >= 60;
		if (isPass) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
		}
	}

}
