package com.world.Y2K.service.visit;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.world.Y2K.dao.visit.VisitDAO;
import com.world.Y2K.model.vo.Reply;
import com.world.Y2K.model.vo.Visit;

@Service("vService")
public class VisitServiceImpl implements VisitService {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private VisitDAO vDAO;
	
	@Override
	public ArrayList<Visit> selectVisitList() {
		return vDAO.selectVisitList(sqlSession);
	}

	@Override
	public int getVisitListCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertVisit(Visit v) {

		return vDAO.insertVisit(sqlSession, v);
	}


}
