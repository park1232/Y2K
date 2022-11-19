package com.world.Y2K.model.vo;

import java.sql.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
	
	private Long userNo;
	private String username;
	private String password;
	private String nickName;
	private Date enrollDate;
	private Date modifyDate;
	private String status;
	private Long point;
	private String role;

}
