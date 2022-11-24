package com.world.Y2K.model.vo;



import java.sql.Date;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;




@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Reply {
	private Long replyNo;
	private String replyContent;
	private Date r_CreateDate;
	private Date r_ModifyDate;
	private String replyStatus;
	private Long replyWriter;
	private String rBoardTypeId;
	
}
