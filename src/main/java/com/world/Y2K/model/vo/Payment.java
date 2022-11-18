package com.world.Y2K.model.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class Payment {
	
	private Long paymentNo;
	private Date paymentDate;
	private String paymentStatus;
	private Long userNo;
}
