package com.world.Y2K.handle;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.world.Y2K.model.vo.chat.ChatMessage;
import com.world.Y2K.model.vo.chat.ChatRoom;
import com.world.Y2K.service.chat.ChatService;



@Controller
public class WebSocketHandler extends TextWebSocketHandler implements InitializingBean {
	
	@Autowired
	private ChatService chatService;
	
	private final ObjectMapper objectMapper = new ObjectMapper();

	// 채팅방 목록 <방 번호, ArrayList<session> >이 들어간다.
    private Map<String, ArrayList<WebSocketSession>> RoomList = new ConcurrentHashMap<String, ArrayList<WebSocketSession>>();
    
    // session, 방 번호가 들어간다.
    private Map<WebSocketSession, String> sessionList = new ConcurrentHashMap<WebSocketSession, String>();
    
    private static int i;
    
    
    /**
     * websocket 연결 성공 시
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        i++;
        System.out.println(session.getId() + " 연결 성공 => 총 접속 인원 : " + i + "명");
    }
    
    /**
     * websocket 연결 종료 시
     */
    
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
    			i--;
    			
    			System.out.println(session.getId() + "연결 종료 => 총 접속 인원 : "+ i + "명");
    			
    			//sessionList에 session이 있다면
    			
    			if(sessionList.get(session) != null) {
    				//해당 session의 방 번호를 가져와서 방을 찾고 그 방의 ArrayList<session>에서 해당 session을 지운다.
    				
    				RoomList.get(sessionList.get(session)).remove(session);
    				sessionList.remove(session);
    		
    			}
    }
    
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
    	
    	//전달 받은 메세지
    	String msg = message.getPayload();
    	
    	//Json객체 -> java
    	 // 출력값 : [roomId=123, messageId=love, message=asdf, name=조현재, email=Ssanto@gmail.com, unReadCount=0]
        ChatMessage chatMessage = objectMapper.readValue(msg,ChatMessage.class);
        
        // 받은 메세지에 담긴 roomId로 해당 채팅방을 찾아온다.
        ChatRoom chatRoom = chatService.selectChatRoom(chatMessage.getRoomId());
        
        // 채팅 세션 목록에 채팅방이 존재하지 않고, 처음 들어왔고, DB에서의 채팅방이 있을 때
        // 채팅방 생성
        if(RoomList.get(chatRoom.getRoomId()) == null && chatMessage.getMessage().equals("ENTER-CHAT") && chatRoom != null) {
            
            // 채팅방에 들어갈 session들
            ArrayList<WebSocketSession> sessionTwo = new ArrayList<>();
            // session 추가
            sessionTwo.add(session);
            // sessionList에 추가
            sessionList.put(session, chatRoom.getRoomId());
            // RoomList에 추가
            RoomList.put(chatRoom.getRoomId(), sessionTwo);
            // 확인용
            System.out.println("채팅방 생성");
        }
        
        // 채팅방이 존재 할 때
        else if(RoomList.get(chatRoom.getRoomId()) != null && chatMessage.getMessage().equals("ENTER-CHAT") && chatRoom != null) {
            
            // RoomList에서 해당 방번호를 가진 방이 있는지 확인.
            RoomList.get(chatRoom.getRoomId()).add(session);
            // sessionList에 추가
            sessionList.put(session, chatRoom.getRoomId());
            // 확인용
            System.out.println("생성된 채팅방으로 입장");
        }
    
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
}
