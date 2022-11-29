package com.world.Y2K.service.mypage;

import org.springframework.ui.Model;

import com.world.Y2K.service.login.auth.UserDetailsImpl;

public interface BackgroundChangeService {

	String backgroundChange(String skinName, UserDetailsImpl userDetails,Model model);

}
