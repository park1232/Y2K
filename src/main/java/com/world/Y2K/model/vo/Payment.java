package com.world.Y2K.model.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class Payment {
	
	private String paymentNo;
	private Date paymentDate;
	private String paymentStatus;
	private Long userNo;
	private String paymentPrice;
	private String paymentName;
}
