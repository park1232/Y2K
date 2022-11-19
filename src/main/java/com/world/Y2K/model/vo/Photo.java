package com.world.Y2K.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Photo {
	
	private Long photoNo;
	private String photoName;
	private String renameName;
	private String photoPath;
	private String photoStatus;
	private String photoComent;
}
