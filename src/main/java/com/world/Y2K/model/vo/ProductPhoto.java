package com.world.Y2K.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ProductPhoto {
	private Long productPhotoNo;
	private String ProductPhotoName;
	private String productReNameName;
	private String productPhotoPath;
	private String productPhotoStatus;
	private Long productNo;
}
