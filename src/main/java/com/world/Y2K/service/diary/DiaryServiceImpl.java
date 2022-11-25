package com.world.Y2K.service.diary;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.world.Y2K.dao.diary.DiaryDAO;
import com.world.Y2K.model.vo.Diary;

@Service("dService")
public class DiaryServiceImpl implements DiaryService{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private DiaryDAO dDAO;
	
	@Override
	public int insertDiary(Diary d) {
		return dDAO.insertDiary(sqlSession, d);
	}

}
