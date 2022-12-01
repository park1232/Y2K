package com.world.Y2K.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Mypage {

	private Long myUserNo;
	private String skinPath;
	private String mainTitle;
	private String profilePath;
	private String sideContent;
	private String ownerNickname;
}
