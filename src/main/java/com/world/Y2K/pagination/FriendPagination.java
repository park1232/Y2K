package com.world.Y2K.pagination;

import com.world.Y2K.model.vo.FriendPageInfo;

public class FriendPagination {
	public static FriendPageInfo getPageInfo(int friendCurrentPage, int friendListCount, int friendBoardLimit) {
		int friendPageLimit = 3;
		int friendMaxPage;
		int friendStartPage;
		int friendEndPage;
		
		friendMaxPage = (int)Math.ceil((double)friendListCount/friendBoardLimit);
		friendStartPage = (friendCurrentPage - 1)/friendPageLimit*friendPageLimit + 1;
		friendEndPage = friendStartPage + friendPageLimit -1;
		if(friendMaxPage < friendEndPage) {
			friendEndPage = friendMaxPage;
		}
		
		FriendPageInfo pi = new FriendPageInfo(friendCurrentPage, friendListCount, friendPageLimit, friendMaxPage, friendStartPage, friendEndPage, friendBoardLimit);
		
		return pi;
	}
}
