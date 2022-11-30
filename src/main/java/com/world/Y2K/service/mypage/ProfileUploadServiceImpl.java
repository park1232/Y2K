package com.world.Y2K.service.mypage;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.world.Y2K.dao.mypage.MypageDAO;
import com.world.Y2K.exception.PhotoException;
import com.world.Y2K.model.vo.Photo;
import com.world.Y2K.model.vo.ProfilePhoto;
import com.world.Y2K.service.login.auth.UserDetailsImpl;
import com.world.Y2K.service.photo.PhotoImageStore;

@Service
public class ProfileUploadServiceImpl implements ProfileUploadService{

	
	@Autowired
	private PhotoImageStore photoImageStore;
	
	@Autowired
	private MypageDAO mypageDAO;
	

	@Override
	public String profileUpload(Model model,MultipartFile file, ProfilePhoto p, UserDetailsImpl userDetails) {
		if(file.isEmpty()) {
			throw new PhotoException("파일이 비엇습니다.");
		}
		Photo photo = setPhoto(p);
		
		photoImageStore.insertImage(photo, file, userDetails);
		HashMap<String, Object> map = setUpdateProfilePathMap(photo.getRenameName(), userDetails.getMember().getUserNo());
		
		mypageDAO.updateProfilePath(map);
		model.addAttribute("userNo", userDetails.getMember().getUserNo()); 
		
		return "/login/loginSuccess";
	}


	private Photo setPhoto(ProfilePhoto p) {
		return Photo.builder()
				.boardNo(8888L)
				.photoName(p.getPhotoName())
				.renameName(p.getRenameName())
				.photoPath(p.getPhotoPath())
				.photoStatus(p.getPhotoStatus())
				.userNo(p.getUserNo())
				.photoComent("null")
				.build();
	}
	
	private HashMap<String, Object> setUpdateProfilePathMap(String photoName, Long userNo) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("profilePath", "../../../../../../../../../upload/"+photoName);
		map.put("userNo", userNo);
		
		return map;
	}


}
