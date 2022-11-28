package com.world.Y2K.service.mypage;

import org.springframework.security.core.Authentication;
import org.springframework.web.servlet.ModelAndView;

public interface OnloadEntityService {

	ModelAndView getOnloadEntity(Long userNo,  Authentication authentication);

}
