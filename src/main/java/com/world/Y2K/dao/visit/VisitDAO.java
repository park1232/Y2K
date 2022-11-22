package com.world.Y2K.dao.visit;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.world.Y2K.model.vo.Reply;

@Repository("vDAO")
public class VisitDAO {
	
public int insertVisit(SqlSessionTemplate sqlSession, Reply r) {
		
		return 0;
	}
}
