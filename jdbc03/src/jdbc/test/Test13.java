package jdbc.test;

import java.util.List;

import jdbc.beans.ProductDao;
import jdbc.beans.ProductDto;

public class Test13 {
	public static void main(String[] args) throws Exception {
		//product 목록 조회
		
		ProductDao productDao = new ProductDao();
		List<ProductDto> list = productDao.select();

		for (ProductDto pd : list) {
			System.out.println(pd.getNo());
			System.out.println(pd.getName());
			System.out.println(pd.getType());
			System.out.println(pd.getPrice());
//			System.out.println(productDto.getMade().substring(0, 10));
//			System.out.println(productDto.getExpire().substring(0, 10));
			System.out.println(pd.getMadeDate());
			System.out.println(pd.getExpireDate());
		}

	}
}
