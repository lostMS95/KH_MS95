package jdbc.test;

import java.util.Scanner;

import jdbc.beans.ProductDao;
import jdbc.beans.ProductDto;

public class Test06 {
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		ProductDto productDto = new ProductDto();
		System.out.print("변경할 상품 번호 : ");
		productDto.setNo(sc.nextInt());
		System.out.print("변경할 가격값 : ");
		productDto.setPrice(sc.nextInt());
		sc.close();

		ProductDao productDao = new ProductDao();
		boolean isSuccess = productDao.updatePrice(productDto);

		if (isSuccess) {
			System.out.println("가격 변경 성공");
		} else {
			System.out.println("존재하지 않는 상품 번호");
		}
	}
}
