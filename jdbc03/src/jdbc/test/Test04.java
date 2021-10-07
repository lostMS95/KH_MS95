package jdbc.test;

import jdbc.beans.ExamDao;
import jdbc.beans.ExamDto;

public class Test04 {
	public static void main(String[] args) throws Exception {
		// 시험 정보 수정

		// 입력 : ExamDto
		ExamDto examDto = new ExamDto();
		examDto.setExamId(10);
		examDto.setStudent("뮤츠");
		examDto.setSubject("데이터입출력구현");
		examDto.setType("서술형");
		examDto.setScore(100);

		ExamDao examDao = new ExamDao();
		boolean isSuccess = examDao.update(examDto);

		if (isSuccess) {
			System.out.println("변경 완료");
		} else {
			System.out.println("해당 번호 없음");
		}
	}
}
