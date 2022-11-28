package com.world.Y2K.service.diary;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.world.Y2K.dao.diary.DiaryDAO;
import com.world.Y2K.model.vo.Diary;
import com.world.Y2K.model.vo.Reply;

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

	@Override
	public ArrayList<Diary> selectDiaryList() {
		return dDAO.selectDiaryList(sqlSession);
	}

	@Override
	public Diary selectDiary(Long bId) {
		return dDAO.selectDiaryList(sqlSession, bId);
	}

	@Override
	public int insertReply(Reply r) {
		return dDAO.insertReply(sqlSession, r);
	}

	@Override
	public ArrayList<Reply> selectReply(Long rboardNo) {
		return dDAO.selectReply(sqlSession, rboardNo);
	}

	@Override
	public int deleteDiary(Long boardNo) {
		return dDAO.deleteDiary(sqlSession, boardNo);
	}

	@Override
	public int updateDiary(Diary d) {
		return dDAO.updateDiary(sqlSession, d);
	}

}
