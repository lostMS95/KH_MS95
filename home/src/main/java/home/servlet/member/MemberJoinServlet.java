package home.servlet.member;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import home.beans.MemberDao;
import home.beans.MemberDto;
import home.beans.MemberProfileDao;
import home.beans.MemberProfileDto;

//회원 가입 처리 서블릿
//= 입력창의 전송형태에 따라 메소드를 선택할 수 있다.
//= service()는 모든 방식을 수용하는 메소드
//= doGet()은 GET 방식만 수용하는 메소드
//= doPost()는 POST 방식만 수용하는 메소드
@WebServlet(urlPatterns ="/member/join.kh")
public class MemberJoinServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//입력 : MemberDto
			//= 문제점 : POST 방식으로 전송될 경우 유니코드가 ASCII코드로 변경되어 전송된다.
			//= 해결책 : 수신한 데이터를 원래의 인코딩방식으로 변환하도록 지시한다.
			//= 주의 : 반드시 수신 전에 복원명령을 작성해야 한다.
			
			String savePath = "D:/upload/member";
			int maxSize = 10 * 1024 * 1024;
			String encoding = "UTF-8";
			DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();//이게 없으면 중복이름저장이 안됨
			MultipartRequest mRequest = 
					new MultipartRequest(req, savePath, maxSize, encoding, policy);
			
			MemberDto memberDto = new MemberDto();
			memberDto.setMemberId(mRequest.getParameter("memberId"));
			memberDto.setMemberPw(mRequest.getParameter("memberPw"));
			memberDto.setMemberNick(mRequest.getParameter("memberNick"));
			memberDto.setMemberBirth(mRequest.getParameter("memberBirth"));
			memberDto.setMemberEmail(mRequest.getParameter("memberEmail"));
			memberDto.setMemberPhone(mRequest.getParameter("memberPhone"));
			
			//처리 : MemberDao
			MemberDao memberDao = new MemberDao();
			memberDao.insert(memberDto);
			
			if(mRequest.getFile("attach") != null) {
				MemberProfileDto memberProfileDto = new MemberProfileDto();
				memberProfileDto.setMemberId(memberDto.getMemberId());
				memberProfileDto.setMemberProfileSavename(mRequest.getFilesystemName("attach"));
				memberProfileDto.setMemberProfileUploadname(mRequest.getOriginalFileName("attach"));
				memberProfileDto.setMemberProfileType(mRequest.getContentType("attach"));
				File target = mRequest.getFile("attach");
				memberProfileDto.setMemberProfileSize(target == null ? 0L : target.length());
			
				MemberProfileDao memberProfileDao = new MemberProfileDao();
				memberProfileDao.insert(memberProfileDto); 
			}
			
			
			
			
			//출력 : 리다이렉트
			resp.sendRedirect("join_success.jsp");
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500); //사용자에게 500번 상태값을 전송(500은 Internal server error)
			
		}
	}
}
