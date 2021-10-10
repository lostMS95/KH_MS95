package jdbc.test;

import jdbc.beans.ProductDao;
import jdbc.beans.ProductDto;

public class Test20 {
	public static void main(String[] args) throws Exception {
		
		int no = 1;
		
		ProductDao productDao = new ProductDao();
		ProductDto productDto = productDao.select(no);
		
		if(productDto == null) {
			System.out.println("해당하는 정보가 없습니다.");
		}
		else {
			System.out.print(productDto.getNo() +"/");
			System.out.print(productDto.getName() +"/");
			System.out.print(productDto.getType() +"/");
			System.out.print(productDto.getPrice() +"/");
			System.out.print(productDto.getMadeDate() +"/");
			System.out.println(productDto.getExpireDate());
		}
		
	}
}
