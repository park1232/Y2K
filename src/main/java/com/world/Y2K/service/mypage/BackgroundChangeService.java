package com.world.Y2K.service.mypage;

import com.world.Y2K.service.login.auth.UserDetailsImpl;

public interface BackgroundChangeService {

	String backgroundChange(String skinName, UserDetailsImpl userDetails);

}
