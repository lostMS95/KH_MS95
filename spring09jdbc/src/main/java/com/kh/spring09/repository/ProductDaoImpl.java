package com.kh.spring09.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring09.entity.ProductDto;

@Repository
public class ProductDaoImpl implements ProductDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insert(ProductDto productDto) {
		String sql = "insert into product values(product_seq.nextval,?, ?, ?, to_date(?,'YYYY-MM-DD'), to_date(?, 'YYYY-MM-DD'))";
		Object[] param = {
				productDto.getName(),
				productDto.getType(),
				productDto.getPrice(),
				productDto.getMade(),
				productDto.getExpire()
		};
		jdbcTemplate.update(sql,param);
	}
}