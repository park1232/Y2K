package com.world.Y2K.service.photo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.world.Y2K.model.vo.Photo;

public interface PhotoService{
	
	List<Photo> photoList();

//	void insertImage(Photo p, MultipartFile file, HttpServletRequest request);

	Photo selectImg(Long photoNo);

	int deletetImg(Long photoNo);
	
	
}
