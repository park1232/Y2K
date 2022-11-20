package com.world.Y2K.model.dto;

import java.sql.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Member {

	private Long userNo;
	private String username;
	private String password;
	private String nickName;
	private Date enrollDate;
	private Date modifyDate;
	private String status;
	private Long orange;
	private String role;
	private String provider;
	private String providerId;
	
	
	
}
