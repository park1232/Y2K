package com.world.Y2K.model.vo.chat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ChatMessage {

	private String roomId;            // 방 번호
    private String messageId;        // 메세지 번호
    private String message;            // 메세지 내용
    private String name;            // 보낸이 이름
    private String email;            // 보낸이 이메일
    private int unReadCount;        // 안 읽은 메세지 수
    private int sessionCount;        // 현재 세션 수
	
	
}
