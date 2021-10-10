package jdbc.test;

import java.util.List;
import java.util.Scanner;

import jdbc.beans.MemberDao;
import jdbc.beans.MemberDto;

public class Test18_1 {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		System.out.print("항목 입력 : ");
		String column = sc.nextLine();
		System.out.print("키워드 : ");
		String keyword = sc.nextLine();
		sc.close();

		boolean isSearch = (column != null && !column.equals(""))
				&& (keyword !=null && !keyword.equals(""));
		
		System.out.println(isSearch);
		
	
		
		MemberDao memberDao = new MemberDao();
		List<MemberDto> list;
		if(isSearch) {
			list = memberDao.select(column, keyword);
		}
		else {
			list = memberDao.select();
		}
		
//		List<MemberDto> list = memberDao.select(column, keyword);
//		List<MemberDto> list = memberDao.list();
		
		for (MemberDto md : list) {
			System.out.print(md.getMemberId() +"/");
			System.out.print(md.getMemberPw() +"/");
			System.out.print(md.getMemberNick() +"/");
			System.out.print(md.getBirthDate() +"/");
			System.out.print(md.getMemberEmail() +"/");
			System.out.print(md.getMemberPhone() +"/");
			System.out.print(md.getMemberJoin() +"/");
			System.out.print(md.getMemberPoint() +"/");
			System.out.println(md.getMemberGrade());
		}
	}
}
