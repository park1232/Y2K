package com.world.Y2K.model.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProfilePhoto {
	
	private String photoName;
	private String renameName;
	private String photoPath;
	private String photoStatus;
	private Long userNo;
}
