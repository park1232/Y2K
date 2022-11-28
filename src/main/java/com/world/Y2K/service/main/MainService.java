package com.world.Y2K.service.main;

import java.util.ArrayList;
import java.util.Map;

import com.world.Y2K.model.vo.Reply;

public interface MainService {

	ArrayList<Reply> replyList(Long userNo);
	
	Map<String,Object> insertReply(String content, String nickName, Long replyWriter);

}
