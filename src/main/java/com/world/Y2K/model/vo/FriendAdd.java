package com.world.Y2K.model.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class FriendAdd {
	
	private Long friendAddNo;
	private String friendContent;
	private Date createDate;
	private Long userNo;
	private String friendNo;
}
