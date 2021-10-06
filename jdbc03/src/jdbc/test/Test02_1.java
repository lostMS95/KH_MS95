package jdbc.test;

import jdbc.beans.ProductDao;
import jdbc.beans.ProductDto;

public class Test02_1 {
	public static void main(String[] args) throws Exception {
		//상품 정보 등록
		
		ProductDto productDto = new ProductDto();
		productDto.setName("야채타임");
		productDto.setType("과자");
		productDto.setPrice(5000);
		productDto.setMade("2021-09-21");
		productDto.setExpire("2021-12-31");
		
		ProductDao productDao = new ProductDao();
		
		productDao.insert(productDto);
		System.out.println("끝");
		
	}
}
