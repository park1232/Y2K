package com.world.Y2K.test.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.world.Y2K.test.model.dao.TestDAO;
import com.world.Y2K.test.model.vo.Test;

@Service
public class TestServiceImpl implements TestService{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private TestDAO testDAO;
	
	
	@Override
	public List<Test> test() {
		return testDAO.test(sqlSession);
	}

}
