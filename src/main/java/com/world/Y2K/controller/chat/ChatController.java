package com.world.Y2K.controller.chat;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@ServerEndpoint("/websocket")
public class ChatController extends Socket{

	private Logger logger = LoggerFactory.getLogger(ChatController.class);
	
	//chat.ch/user로 바꾸기 
	
	
	private static final List<Session> session = new ArrayList<Session>();
	
	public ChatController() {}
	
	
	@GetMapping("/testchat.ch")
	public String chat(Model model) {
		
		logger.info("[Controller] : testchat.do");
		
		return "testchat";
	}
	
	@OnOpen
	public void open(Session newUser) {
		
	
	}
	
	@OnMessage
	public void getMsg(Session recieveSession, String msg) {
				for (int i = 0; i < session.size(); i++) {
		            if (!recieveSession.getId().equals(session.get(i).getId())) {
		                try {
		                    session.get(i).getBasicRemote().sendText("상대 : "+msg);
		                } catch (IOException e) {
		                    e.printStackTrace();
		                }
		            }else{
		                try {
		                    session.get(i).getBasicRemote().sendText("나 : "+msg);
		                } catch (IOException e) {
		                    e.printStackTrace();
		                }
		            }
		        }
		    }
	
	
	
	
	
	
	
	
	
	
	
	
	
//	안되면 핸들러 수정해보기	
//	<websocket:handlers>
//	<websocket:mapping handler="당신의 handler 이름" path="당신의 path" />
//	<websocket:handshake-interceptors>
//		<beans:bean class="org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor" />
//	</websocket:handshake-interceptors>
//	<websocket:sockjs/>
//	</websocket:handlers>
	
	
	
	
	
	
}
