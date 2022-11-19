package com.world.Y2K.service.photo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.world.Y2K.model.vo.Photo;

public interface PhotoService {

	void insertImage(Photo p, MultipartFile file, HttpServletRequest request);
	
	
}
