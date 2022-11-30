package com.world.Y2K.model.vo;

import java.sql.Date;

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
public class Diary {
	private Long boardNo;
	private String mood;
	private String weather;
	private String privacyBounds;
	private String location;
	private String diaryDate;
	private String diaryContent;
	private Date createDate;
	private Date modifyDate;
	private String diaryStatus;
	private Long diaryWriter;
	private Long own;
}
