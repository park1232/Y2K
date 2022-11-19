package com.world.Y2K.controller.photo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.world.Y2K.exception.PhotoException;
import com.world.Y2K.model.vo.Photo;
import com.world.Y2K.service.photo.PhotoService;




@Controller
public class PhotoController {
	
	@Autowired
	private PhotoService pService;
	
	@GetMapping("/photo.ph")
	public String photo() {
		
	
		return "photo";
	}
	
	@GetMapping("/show.ph")
	public String test3() {
		
		
		return "show";
	}
	
	@GetMapping("/upload.ph")
	public String upload() {

		return "upload";
	}
	
	@PostMapping("/imageUpload.ph")
	public String imageUpload(@ModelAttribute Photo p,
			@RequestParam("file") MultipartFile files,
			HttpServletRequest request,
			Model model) {
		
		if(files.isEmpty()) {
			throw new PhotoException("이미지가 첨부되지않았습니다.");
		}
		
		pService.insertImage(p, files, request);
		
	
		
		
		return null;
	}
}