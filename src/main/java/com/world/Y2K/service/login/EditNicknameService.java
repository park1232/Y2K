package com.world.Y2K.service.login;

import org.springframework.web.servlet.ModelAndView;

import com.world.Y2K.exception.MemberException;
import com.world.Y2K.model.dto.Member;

public interface EditNicknameService {

	 ModelAndView editNickname(Member member, String nickname) throws MemberException ;

}
