package com.world.Y2K.service.mypage;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.world.Y2K.model.vo.ProfilePhoto;
import com.world.Y2K.service.login.auth.UserDetailsImpl;

public interface ProfileUploadService {

	String profileUpload(Model model,MultipartFile file, ProfilePhoto p, UserDetailsImpl userDetails);


}
