package com.world.Y2K.service.main;

import java.util.ArrayList;
import java.util.Map;

import com.world.Y2K.model.vo.Board;
import com.world.Y2K.model.vo.Reply;

public interface MainService {

	ArrayList<Reply> replyList(Long userNo);
	
	Map<String,Object> insertReply(String content, String nickName, Long replyWriter, Long own);

	int boardList(Long userNo);

	int photoList(Long userNo);

	int visitList(Long userNo);

	int dList(Long userNo);

	void deleteReply(Long userNo, Long replyNo);

}
