package com.world.Y2K.service.chat;

import java.util.List;

import com.world.Y2K.model.vo.chat.ChatMessage;
import com.world.Y2K.model.vo.chat.ChatRoom;

public interface ChatService {

	//방번호를 선택하는 메소드
	//방번호를 만들어서 던져줘보자
	//@param roomid
	//@return
	ChatRoom selectChatRoom(String roomId);

	
	
	//채팅 메세지 DB에 저장
	//@param chatMessage
	//@return
	int insertMessage(ChatMessage chatMessage);
	
	
	
	//메세지 내용 리스트 출력
	//@param roomId
	//@return
	List<ChatMessage> messageList(String roomId);
	
	
	
	//채팅방DB저장
	//@param room
	//@return
	int createChat(ChatRoom room);	
	
	
	
	//DB에 채팅방 있는지 확인
	//@param room
	//@return
	ChatRoom searchChatRoom(ChatRoom room);



	void updateCount(ChatMessage message);
	
	
	
	
	
	
	
	
	
}
