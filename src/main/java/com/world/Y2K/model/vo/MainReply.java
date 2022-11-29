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
public class MainReply {

	private Long replyNo;
	private String content;
	private Date mCreateDate;
	private Date mModifyDate;
	private Long replyWriter;
	private String nickName;
	private String mReplyStatus;
	private Long own;
}
