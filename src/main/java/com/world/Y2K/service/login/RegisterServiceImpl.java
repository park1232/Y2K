package com.world.Y2K.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.world.Y2K.dao.login.LoginDAO;
import com.world.Y2K.dao.mypage.MypageDAO;
import com.world.Y2K.dao.skin.SkinDAO;
import com.world.Y2K.model.dto.Member;
import com.world.Y2K.model.vo.User;


@Service("registerService")
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private LoginDAO loginDAO;
	
	@Autowired
	private MypageDAO mypageDAO;
	
	@Autowired
	private SkinDAO skinDAO;
	
	
	@Override
	public int registerMember(User user) {
		
		loginDAO.registerMember(setMember(user));
		
		Member member = loginDAO.findUser(user.getUsername());
		
		if(mypageDAO.checkFirst(member.getUserNo()) == 0 ){
			skinDAO.insertDefault(member.getUserNo());
			return mypageDAO.insertDefault(member.getUserNo());
		}
		return 0;
		
		
	}
	
	private Member setMember(User user) {
		return Member.builder()
				.username(user.getUsername())
				.password(bCryptPasswordEncoder.encode(user.getPassword()))
				.nickName(user.getNickName())
				.email(user.getEmail())
				.status("Y")
				.orange(0L)
				.role("ROLE_USER")
				.provider("LOCAL")
				.providerId("NULL")
				.build();
	}

	
	
}
