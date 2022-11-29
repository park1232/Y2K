package com.world.Y2K.service.mypage;

import com.world.Y2K.service.login.auth.UserDetailsImpl;

public interface TitleChangeService {

	String titleChange(String inputTitle, UserDetailsImpl userDetails);

}
