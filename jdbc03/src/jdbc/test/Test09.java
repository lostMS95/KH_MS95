package jdbc.test;

import jdbc.beans.ExamDao;

public class Test09 {
	public static void main(String[] args) throws Exception {
		// exam 데이터 삭제 예제

		int examId = 5;

		ExamDao examDao = new ExamDao();
		boolean success = examDao.delete(examId);

		if (success) {
			System.out.println("삭제 완료");
		} else {
			System.out.println("존재하지 않는 번호");
		}
	}
}
