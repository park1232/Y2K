package com.world.Y2K.controller.test;

import java.util.Map;

public interface ReplyService {

	Map<String, Object> insertReply(String content, Long boardNo, String rNickName,Long userNo);

}
