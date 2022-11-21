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
public class PayPageInfo {
	private int payCurrentPage; // 현재페이지
	private int payListCount; // 총 게시글 개수
	private int payPageLimit; // 밑에 뜨는 페이지 개수
	private int payMaxPage; // 페이지의 끝
	private int payStartPage; // pageLimit 첫번째 페이지
	private int payEndPage; // pageLimit 마지막페이지
	private int payBoardLimit; // 한 페이지 당 게시글 개수
}
