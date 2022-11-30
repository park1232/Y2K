package com.world.Y2K.controller.mypage;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.world.Y2K.exception.PhotoException;
import com.world.Y2K.model.vo.Photo;
import com.world.Y2K.model.vo.ProfilePhoto;
import com.world.Y2K.service.login.auth.UserDetailsImpl;
import com.world.Y2K.service.mypage.BackgroundChangeService;
import com.world.Y2K.service.mypage.ContentChangeService;
import com.world.Y2K.service.mypage.MoveMypageViewSerivce;
import com.world.Y2K.service.mypage.OnloadEntityService;
import com.world.Y2K.service.mypage.ProfileUploadService;
import com.world.Y2K.service.mypage.TitleChangeService;
import com.world.Y2K.service.photo.PhotoImageStore;

@Controller
public class MyPageController {

	@Autowired
	private OnloadEntityService onloadEntityService;
	
	@Autowired
	private MoveMypageViewSerivce moveMypageViewService;
	
	@Autowired
	private BackgroundChangeService backgroundChangeService; 
	
	@Autowired
	private ProfileUploadService profileUploadService;
	@Autowired
	private TitleChangeService titleChangeService;
	
	@Autowired
	private ContentChangeService contentChangeService;
	
	
	
	
	@GetMapping("/mypage.my")
	public ModelAndView moveMypageView(Authentication authentication) {
		return moveMypageViewService.moveMypageView(authentication);
//		return "mypage/mypage";
	}
	
	@ResponseBody
	@GetMapping("/onload.my")
	public HashMap<String, Object> getOnloadEntity(Long userNo){
	
		return onloadEntityService.getOnloadEntity(userNo);
	}
	
	@GetMapping("/background-change.my")
	public String backgroundChange(String skinName, Authentication authentication, Model model) {
		return backgroundChangeService.backgroundChange(skinName, getUserDetails(authentication),model );
	}
	
	@GetMapping("/title-change.my")
	public String titleChange(String inputTitle,  Authentication authentication ,Model model) {
		return titleChangeService.titleChange(inputTitle, getUserDetails(authentication),model);
	}
	
	@GetMapping("/content-change.my")
	public String contentChange(String inputContent,  Authentication authentication, Model model) {
		return contentChangeService.contentChange(inputContent, getUserDetails(authentication), model);
	}
	
	@GetMapping("/profile-upload.my")
	public String moveProfileUploadView() {
		return "mypage/profileupload";
	}
	
	@PostMapping("/input-profile.my")
	public String profileUpload(@ModelAttribute ProfilePhoto p, @RequestParam(value="file", required=false)MultipartFile file,
			HttpServletRequest request, Model model, Authentication authntication) {
		return profileUploadService.profileUpload(model,file,p,getUserDetails(authntication));


	}
	
	
	
	
	private UserDetailsImpl getUserDetails(Authentication authentication){
		return (UserDetailsImpl)authentication.getPrincipal();
	}
}
