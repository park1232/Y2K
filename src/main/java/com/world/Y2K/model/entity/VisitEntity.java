package com.world.Y2K.model.entity;

import java.sql.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VisitEntity {
	
	private Long visitNo;
	private String nickName;
	private String path;
	private Date createDate;
	private String visitContent;

}
