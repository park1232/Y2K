package com.world.Y2K.service.photo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.world.Y2K.model.vo.Photo;
import com.world.Y2K.model.vo.Reply;

public interface PhotoService{
	
	List<Photo> photoList(Long userNo);

//	void insertImage(Photo p, MultipartFile file, HttpServletRequest request);

	Photo selectImg(Long boardNo);

	int deletetImg(Long boardNo);

	void updateComent(Photo p);

//	int insertPreply(Reply r);

	ArrayList<Reply> selectReply(Long boardNo);
	
	
}
