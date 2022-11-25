package com.world.Y2K.dao.photo;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.world.Y2K.model.vo.Photo;
import com.world.Y2K.model.vo.Reply;




@Repository("pDAO")
public class PhotoDAO {

	public void insertImage(SqlSessionTemplate sqlSession, Photo p) {
		
		sqlSession.insert("photoMapper.insertPhoto", p);
	}

	public List<Photo> photoList(SqlSessionTemplate sqlSession) {
		
		return sqlSession.selectList("photoMapper.selectPhotoList");
	}

	public Photo selectImg(SqlSessionTemplate sqlSession, Long boardNo) {
		
		return sqlSession.selectOne("photoMapper.selectPhoto", boardNo);
	}

	public int deleteImg(SqlSessionTemplate sqlSession, Long boardNo) {
		
		return sqlSession.update("photoMapper.deletePhoto", boardNo);
	}
	
	public void updateAll(SqlSessionTemplate sqlSession, Photo p) {
		
		sqlSession.update("photoMapper.updateAll", p);
		
	}

	public void updateComent(SqlSessionTemplate sqlSession, Photo p) {

		sqlSession.update("photoMapper.updateComent", p);
	}

	public int insertPreply(SqlSessionTemplate sqlSession, Reply r) {
		return sqlSession.insert("replyMapper.insertPreply", r);
	}

	public ArrayList<Reply> selectReply(SqlSessionTemplate sqlSession, Long boardNo) {
		System.out.println("½ÇÇàµÊ??");
		System.out.println(boardNo);
		return (ArrayList)sqlSession.selectList("photoMapper.selectReply", boardNo);
	}


	
	
	
}
