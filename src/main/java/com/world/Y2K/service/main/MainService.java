package com.world.Y2K.service.main;

import java.util.ArrayList;

import com.world.Y2K.model.vo.Reply;

public interface MainService {

	ArrayList<Reply> replyList(Long boardNo);

	void insertReply(Reply r);

}
