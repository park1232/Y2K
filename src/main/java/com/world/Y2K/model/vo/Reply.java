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
	private String nickName;
	private Date rCreateDate;
	private Date rModifyDate;
	private String replyStatus;
	private Long replyWriter;
	private Long rboardNo;

}
