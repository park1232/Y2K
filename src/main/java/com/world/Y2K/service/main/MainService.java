package com.world.Y2K.service.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.world.Y2K.model.dto.Member;
import com.world.Y2K.model.vo.Reply;

public interface MainService {

	ArrayList<Reply> replyList(Long userNo);
	
	Map<String,Object> insertReply(String content, String nickName, Long replyWriter, Long own);

	int boardCount(Long userNo);

	int photoCount(Long userNo);

	int visitCount(Long userNo);

	int dCount(Long userNo);

	void deleteReply(Long userNo, Long replyNo);

	Member owner(Long userNo);

	ArrayList<HashMap<String, Object>> boardList(Long userNo);

	ArrayList<HashMap<String, Object>> photoList(Long userNo);

	ArrayList<HashMap<String, Object>> diaryList(Long userNo);

	ArrayList<HashMap<String, Object>> visitList(Long userNo);

}
