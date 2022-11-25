package com.world.Y2K.model.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class Visit {
	private int visitNo;
	private String visitContent;
	private Date createDate;
	private Date modifyDate;
	private String visitStatus;
	private int visitWriter;	//유저 고유번호
	
}
