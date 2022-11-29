package com.world.Y2K.service.mypage;

import org.springframework.ui.Model;

import com.world.Y2K.service.login.auth.UserDetailsImpl;

public interface TitleChangeService {

	String titleChange(String inputTitle, UserDetailsImpl userDetails, Model model);

}
