package com.kh.spring20.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring20.entity.CertificationDto;

@Repository
public class CertificationDaoImpl implements CertificationDao{
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insert(CertificationDto certificationDto) {
		sqlSession.insert("certification.insert",certificationDto);
		
	}

}