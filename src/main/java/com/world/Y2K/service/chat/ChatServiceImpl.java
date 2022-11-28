package com.world.Y2K.service.chat;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.world.Y2K.dao.chat.ChatDAO;
import com.world.Y2K.dao.photo.PhotoDAO;
import com.world.Y2K.model.vo.chat.ChatMessage;
import com.world.Y2K.model.vo.chat.ChatRoom;

@Service("chatSevice")
public class ChatServiceImpl implements ChatService{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private ChatDAO chatDAO;
	
	
	
	@Override
	public ChatRoom selectChatRoom(String roomId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertMessage(ChatMessage chatMessage) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ChatMessage> messageList(String roomId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createChat(ChatRoom room) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ChatRoom searchChatRoom(ChatRoom room) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCount(ChatMessage message) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
