package com.world.Y2K.model.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class Reply {
	private Long replyId;
	private String replyContent;
	private String nickName;
	private Date r_CreateDate;
	private Date r_ModifyDate;
	private String replyStatus;
	private Long replyWriter;
	private Long r_boardNo;
	private String replyTypeId;
	
}
