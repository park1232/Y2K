package com.world.Y2K.service.reply;

import java.util.Map;

public interface ReplyService {

	Map<String, Object> insertReply(String content, Long boardNo, String nickName, Long own,Long userNo);

	void deleteReply(Long replyNo);

}
