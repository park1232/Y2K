package com.world.Y2K.service.photo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.world.Y2K.model.vo.Photo;
import com.world.Y2K.service.login.auth.UserDetailsImpl;

public interface PhotoImageStore {

	void insertImage(Photo p, MultipartFile file, UserDetailsImpl userDetails);

	void updateAll(Photo p, MultipartFile file, HttpServletRequest request);



	
}
