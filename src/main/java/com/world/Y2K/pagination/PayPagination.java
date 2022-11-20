package com.world.Y2K.pagination;

import com.world.Y2K.model.vo.PayPageInfo;

public class PayPagination {
	public static PayPageInfo getPageInfo(int payCurrentPage, int payListCount, int payBoardLimit) {
		int payPageLimit = 3;
		int payMaxPage;
		int payStartPage;
		int payEndPage;
		
		payMaxPage = (int)Math.ceil((double)payListCount/payBoardLimit);
		payStartPage = (payCurrentPage - 1)/payPageLimit*payPageLimit + 1;
		payEndPage = payStartPage + payPageLimit -1;
		if(payMaxPage < payEndPage) {
			payEndPage = payMaxPage;
		}
		
		PayPageInfo pi = new PayPageInfo(payCurrentPage, payListCount, payPageLimit, payMaxPage, payStartPage, payEndPage, payBoardLimit);
		
		return pi;
	}
}
