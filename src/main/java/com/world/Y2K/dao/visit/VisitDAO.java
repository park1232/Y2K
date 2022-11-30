package com.world.Y2K.dao.visit;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.world.Y2K.model.vo.Reply;
import com.world.Y2K.model.vo.Visit;

@Repository("vDAO")
public class VisitDAO {
	
	
	public ArrayList<Visit> selectVisitList(SqlSessionTemplate sqlSession, Long own) {
		System.out.println("dao own : " + own);
		return (ArrayList)sqlSession.selectList("visitMapper.selectVisitList", own);
	
	}
	
	public int insertVisit(SqlSessionTemplate sqlSession, Visit v) {
		
		return sqlSession.insert("visitMapper.insertVisit", v);
	}

	public int deleteVisit(SqlSessionTemplate sqlSession, Long visitNo) {
		System.out.println("dao단 : " + visitNo);
		return sqlSession.update("visitMapper.deleteVisit", visitNo);
	}
}
