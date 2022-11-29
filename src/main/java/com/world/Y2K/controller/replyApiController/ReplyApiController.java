package com.world.Y2K.controller.replyApiController;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.world.Y2K.model.dto.ReplyDto;
import com.world.Y2K.service.login.auth.UserDetailsImpl;
import com.world.Y2K.service.reply.ReplyService;

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
			//System.out.println("controller : " +replyDto.getNickName());
			return replyService.insertReply(replyDto.getContent(), replyDto.getBoardNo(), replyDto.getNickName(),userDetails.getMember().getUserNo());

	}
	
	@ResponseBody
	@PostMapping("/api/reply/delete")
	public void replyDelete(@RequestParam("replyNo") Long replyNo,
			HttpServletResponse response, Model model,
			Authentication authentication){
			response.setContentType("application/json; charset=UTF-8");
			UserDetailsImpl userDetails = (UserDetailsImpl)authentication.getPrincipal();
			
			/*
			 * System.out.println(userDetails);
			 * 
			 * System.out.println(model);
			 * 
			 * System.out.println(replyNo);
			 */
			//System.out.println(userDetails.getMember().getUserNo());
			
			replyService.deleteReply(userDetails.getMember().getUserNo(), replyNo);
			
			//return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
