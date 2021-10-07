package jdbc.test;

import jdbc.beans.ProductDao;
import jdbc.beans.ProductDto;

public class Test05 {
	public static void main(String[] args) throws Exception {
		
		ProductDto productDto = new ProductDto();
		productDto.setNo(34);
		productDto.setName("요맘떼");
		productDto.setType("아이스크림");
		productDto.setPrice(1200);
		productDto.setMade("2021-05-01");
		productDto.setExpire("2021-10-31");
		
		ProductDao productDao = new ProductDao();
		boolean isSuccess = productDao.update(productDto);
		
		if(isSuccess) {
			System.out.println("상품정보가 수정되었습니다");
		}
		else {
			System.out.println("해당 상품은 존재하지 않습니다");
		}
	}
}
