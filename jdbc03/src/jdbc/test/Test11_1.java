package jdbc.test;

import jdbc.beans.MemberDao;
import jdbc.beans.MemberDto;

public class Test11_1 {
	public static void main(String[] args) throws Exception {
			//회원 탈퇴
		
				//입력
				MemberDto memberDto = new MemberDto();
				memberDto.setMemberId("testuser3");
				memberDto.setMemberNick("테스트3");
				memberDto.setMemberGrade("준회원");
				
				//처리
				MemberDao memberDao = new MemberDao();	
				boolean success = memberDao.quit(memberDto);
				
				//출력
				if(success) {
					System.out.println("회원 탈퇴 처리가 완료되었습니다");
				}
				else {
					System.out.println("존재하지 않는 회원입니다");
				}
			}
		}