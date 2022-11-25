package com.world.Y2K.dao.diary;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.world.Y2K.model.vo.Diary;

@Repository
public class DiaryDAO {

	public int insertDiary(SqlSessionTemplate sqlSession, Diary d) {
		return sqlSession.insert("diaryMapper.insertDiary", d);
	}

}
