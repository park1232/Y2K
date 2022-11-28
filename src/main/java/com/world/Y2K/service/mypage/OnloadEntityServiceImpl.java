package com.world.Y2K.service.mypage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.world.Y2K.dao.mypage.MypageDAO;
import com.world.Y2K.model.dto.Mypage;

@Service
public class OnloadEntityServiceImpl implements OnloadEntityService{

	@Autowired
	private MypageDAO mypageDAO;
	
	@Override
	public Mypage getOnloadEntity(Long userNo) {
		return mypageDAO.getOnloadEntity(userNo);
		
	}



	
	
}
