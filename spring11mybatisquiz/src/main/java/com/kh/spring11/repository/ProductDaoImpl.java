package com.kh.spring11.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring11.entity.ProductDto;

@Repository
public class ProductDaoImpl implements ProductDao{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insert(ProductDto productDto) {
		//mapper 중에서 product라는 namespace의 insert이라는 구문을 찾고
		//productDto를 전달시켜서 실행하라!
		sqlSession.insert("product.insert",productDto);
	}

	@Override
	public List<ProductDto> list() {
		//mapper 중에서 product라는 namespace의 list이라는 구문을  찾아라
		return sqlSession.selectList("product.list");
	}

	@Override
	public ProductDto get(int no) {
		//mapper 중에서 product라는 namespace의 get이라는 구문을 찾고
		//no를 전달시켜서 실행하라!
		return sqlSession.selectOne("product.get",no);
		
	}
}