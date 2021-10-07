package jdbc.test;

import java.util.List;

import jdbc.beans.ExamDao;
import jdbc.beans.ExamDto;

public class Test12 {
	public static void main(String[] args) throws Exception {
		
		//exam 목록 조회
		
		//입력 : 없음
		
		//처리
		ExamDao examDao = new ExamDao(); //시험지정보
		List<ExamDto>list = examDao.select(); //시험지정보 목록
		
		//출력
		System.out.println("개수 : " +list.size());
		for(ExamDto examDto : list) {
			System.out.print(examDto.getExamId());
			System.out.print("  /  ");
			System.out.print(examDto.getStudent());
			System.out.print("  /  ");
			System.out.print(examDto.getSubject());
			System.out.print("  /  ");
			System.out.print(examDto.getType());
			System.out.print("  /  ");
			System.out.print(examDto.getScore());
			System.out.println();
		}
		
	}
}
