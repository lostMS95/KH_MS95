package jdbc.test;

import java.util.List;
import java.util.Scanner;

import jdbc.beans.ProductDao;
import jdbc.beans.ProductDto;

public class Test17 {
	public static void main(String[] args) throws Exception {
		//product 검색
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("항목 입력 : ");
		String column = sc.nextLine();
		System.out.print("키워드 : ");
		String keyword = sc.nextLine();
		sc.close();

		ProductDao productDao = new ProductDao();
		List<ProductDto> list = productDao.select(column, keyword);

		for (ProductDto pd : list) {
			System.out.print(pd.getNo() +"/");
			System.out.print(pd.getName() +"/");
			System.out.print(pd.getType() +"/");
			System.out.print(pd.getPrice() +"/");
			System.out.print(pd.getMadeDate() +"/");
			System.out.println(pd.getExpireDate());
		}
	}
}
