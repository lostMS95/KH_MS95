package jdbc.test;

import jdbc.beans.ExamDao;
import jdbc.beans.ExamDto;

public class Test04_1 {
	public static void main(String[] args) throws Exception {
		// 질문 답변 : 시험 정보 수정(이름만)

		// 입력 : ExamDto
		ExamDto examDto = new ExamDto();
		examDto.setExamId(10);
		examDto.setStudent("포포링");

		ExamDao examDao = new ExamDao();
		boolean isSuccess = examDao.update(examDto);

		if (isSuccess) {
			System.out.println("변경 완료");
		} else {
			System.out.println("해당 번호 없음");
		}
	}
}
