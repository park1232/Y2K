package com.world.Y2K.service.visit;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.world.Y2K.dao.visit.VisitDAO;
import com.world.Y2K.model.entity.VisitEntity;
import com.world.Y2K.model.vo.Visit;

@Service("vService")
public class VisitServiceImpl implements VisitService {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private VisitDAO vDAO;
	
	@Override
	public ArrayList<VisitEntity> selectVisitList(Long userNo) {
		ArrayList<Visit> list = vDAO.selectVisitList(sqlSession, userNo);
		ArrayList<VisitEntity> visitList = new ArrayList<VisitEntity>();
		for(Visit v : list) {
			VisitEntity visitEntity = VisitEntity.builder()
									  .visitNo(v.getVisitNo())
									  .nickName(v.getNickName())
									  .path("/mainPage.ma?userNo="+v.getVisitWriter())
									  .createDate(v.getCreateDate())
									  .visitContent(v.getVisitContent())
									  .build();
			visitList.add(visitEntity);
		}
		return visitList;
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

	@Override
	public int deleteVisit(Long visitNo) {

		return vDAO.deleteVisit(sqlSession, visitNo);
	}


}
