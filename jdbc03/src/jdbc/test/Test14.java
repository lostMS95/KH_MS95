package jdbc.test;

import java.util.List;

import jdbc.beans.MemberDao;
import jdbc.beans.MemberDto;

public class Test14 {
	public static void main(String[] args) throws Exception {
		
		MemberDao memberDao = new MemberDao();
		List<MemberDto> list = memberDao.select();
		
		for(MemberDto md : list) {
			System.out.print(md.getMemberId() + "/");
			System.out.print(md.getMemberNick() + "/");
			System.out.print(md.getMemberEmail() + "/");
			System.out.println(md.getMemberPhone() + "/");
			
		}
	}
}
