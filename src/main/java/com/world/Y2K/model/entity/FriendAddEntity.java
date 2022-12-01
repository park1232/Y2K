package com.world.Y2K.model.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FriendAddEntity {

	
	private Long userNo;
	private String nickName;
	private String path;

}
