package com.world.Y2K.service.mypage;

import org.springframework.ui.Model;

import com.world.Y2K.service.login.auth.UserDetailsImpl;

public interface ContentChangeService {

	String contentChange(String inputContent, UserDetailsImpl userDetails, Model model);

}
