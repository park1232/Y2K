package com.world.Y2K.controller.chat;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.world.Y2K.model.vo.chat.ChatMessage;
import com.world.Y2K.model.vo.chat.ChatSession;
import com.world.Y2K.service.chat.ChatService;

import lombok.RequiredArgsConstructor;

/*@RequiredArgsConstructor*/
@Controller
public class ChatController {
	
	//@Autowired
	/*ChatService chatSevice;
	
	@Autowired
	private ChatSession chatSession;
	

	 @RequestMapping(value="{roomId}.ch")
	    public void messageList(@PathVariable String roomId, String userEmail, Model model, HttpServletResponse response) throws JsonIOException, IOException {
	        
	        List<ChatMessage> mList = chatService.messageList(roomId);
	        response.setContentType("application/json; charset=utf-8");
	 
	        // 안읽은 메세지의 숫자 0으로 바뀌기
	        ChatMessage message = new ChatMessage();
	        message.setEmail(userEmail);
	        message.setRoomId(roomId);
	        chatService.updateCount(message);
	        
	        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
	        gson.toJson(mList,response.getWriter());
	    }*/
	    
	
}