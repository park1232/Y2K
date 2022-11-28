package com.world.Y2K.model.vo.chat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;




//방번호와 사용자 - 상대방의 정보가 담겨있다.
//roomId로 채팅방을 구분하며,
//unReadCount를 통해 읽었는지 파악 할 수 있게 해준다.


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ChatRoom {
    
    private String roomId;        // 방 번호 랜덤
    
    private String userEmail;    // 사용자 이메일 이거 필수인가..?
    private String userName;    // 사용자 이름
    private String masterEmail; // 상대방 이메일
    private String masterName;    // 상대방 이름
 
    
}