package oop.method5;

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

//	원하는 정보를 원하는 형태로 반환하는 메소드
//	= Getter 메소드(게터 메소드)
//	= Setter 메소드처럼 이름을 짓고, Setter 메소드 처럼 변수당 1개씩은 기본적으로 생성
//	= 필요하다면 추가적으로 더 생성할 수도 있다
//	= ex : name의 getter 메소드는 getName이다
//	= return 은 메소드를 중지하는 키워드이며, 우측에 값이 있으면 해당 값을 "호출자"에게 반환
//	= void는 실행 후 반환할 데이터가 없다는 뜻이다(null과 구분할 줄 알아야함)
	String getName() {
		return this.name;// 주인공(this)의 이름을 부른 대상에게 반환하세요
	}

	String getType() {
		return this.type;
	}

	int getScore() {
		return this.score;
	}

	int getListScore() {
		return this.listScore;
	}

	int getTotal() {
		// return this.narrativeScore + this.checklistScore;
		return this.getScore() + this.getListScore();
	}

	float getAverage() {
		// return (this.narrativeScore + this.checklistScore) / 2.0f;
		return this.getTotal() / 2.0f;
	}

	boolean getPass() {
		// return this.narrativeScore >= 40 && this.checklistScore >= 40 &&
		// this.getAverage() >= 60;
		return this.getScore() >= 40 && this.getListScore() >= 40 && this.getAverage() >= 60;
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

		System.out.println("평균  : " + this.getAverage() + "점");

		// boolean isPass = 서술형 40점이상 그리고 체크리스트 40점이상 그리고 평균 60이상;

		if (this.getPass()) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
		}
	}

}
