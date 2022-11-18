package com.world.Y2K.model.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class Board {
	
	private Long boardNo;
	private String boardTitle;
	private String boardContent;
	private Date createDate;
	private Date modifyDate;
	private Long boardCount;
	private String boardStatus;
	private Long bcId;
	private Long userNo;

}
