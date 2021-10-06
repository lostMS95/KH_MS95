package jdbc.test;

import jdbc.beans.ProductDao;

public class Test02 {
	public static void main(String[] args) throws Exception {
		//상품 정보 등록
				String name = "메로나이슬";
				String type = "주류";
				int price = 2500;
				String made = "2021-10-06";
				String expire = "2022-10-06";
		
		//객체 생성
		ProductDao productDao = new ProductDao();
		
		productDao.insert(name, type, price ,made,expire );
		System.out.println("추가완료!");
		
	}
}
