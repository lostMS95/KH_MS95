package jdbc.test;

import java.util.Scanner;

import jdbc.beans.ProductDao;

public class Test10 {
	public static void main(String[] args) throws Exception {
		
		Scanner sc= new Scanner(System.in);
		System.out.print("삭제할 상품번호 : ");
		int no = sc.nextInt();
		sc.close();
		
		ProductDao productDao = new ProductDao();
		boolean result = productDao.delete(no);
		
		if(result) {
			System.out.println("삭제완료");
		}
		else {
			System.out.println("해당하는 상품없음");
		}
	}
}
