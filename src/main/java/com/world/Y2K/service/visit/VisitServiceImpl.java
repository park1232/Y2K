package com.world.Y2K.service.visit;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.world.Y2K.dao.visit.VisitDAO;
import com.world.Y2K.model.vo.Reply;

@Service("vService")
public class VisitServiceImpl implements VisitService {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private VisitDAO vDAO;
	
	@Override
	public int insertVisit(Reply r) {

		return vDAO.insertVisit(sqlSession, r);
	}
}
