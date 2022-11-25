package com.world.Y2K.controller.test;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.world.Y2K.service.login.auth.UserDetailsImpl;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
public class ReplyApiController {

	private final ReplyService replyService;
		
	
	@PostMapping("/api/reply")
	public Map<String,Object> replySave(
			ReplyDto replyDto,
			BindingResult bindingResult, 
			Authentication authentication){
			UserDetailsImpl userDetails = (UserDetailsImpl)authentication.getPrincipal();
			System.out.println(replyDto);
			System.out.println("controller : " +replyDto.getRNickName());
			return replyService.insertReply(replyDto.getContent(), replyDto.getBoardNo(), replyDto.getRNickName(),userDetails.getMember().getUserNo());

	}
	
	@DeleteMapping("/api/reply/${boardNo}")
	public Map<String, Object> replyDelete(@PathVariable Long boardNo){
		
		//replyService.deleteReply(rNickName);
		
		return null;
	}
	
	
	
}
