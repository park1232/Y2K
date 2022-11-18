package com.world.Y2K.test.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.world.Y2K.test.model.vo.Test;

@Repository
public class TestDAO {

	public List<Test> test(SqlSessionTemplate sqlSession) {
		return sqlSession.selectList("testMapper.selectList");
		
	}

}
