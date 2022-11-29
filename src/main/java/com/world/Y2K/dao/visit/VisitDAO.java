package com.world.Y2K.dao.visit;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.world.Y2K.model.vo.Reply;
import com.world.Y2K.model.vo.Visit;

@Repository("vDAO")
public class VisitDAO {
	
	
	public ArrayList<Visit> selectVisitList(SqlSessionTemplate sqlSession) {
		
		return (ArrayList)sqlSession.selectList("visitMapper.selectVisitList");
	}
	
	public int insertVisit(SqlSessionTemplate sqlSession, Visit v) {
		
		return sqlSession.insert("visitMapper.insertVisit", v);
	}
}
