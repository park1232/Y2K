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
public class FriendPageInfo {
	private int friendCurrentPage; // 현재페이지
	private int friendListCount; // 총 게시글 개수
	private int friendPageLimit; // 밑에 뜨는 페이지 개수
	private int friendMaxPage; // 페이지의 끝
	private int friendStartPage; // pageLimit 첫번째 페이지
	private int friendEndPage; // pageLimit 마지막페이지
	private int friendBoardLimit; // 한 페이지 당 게시글 개수
}
