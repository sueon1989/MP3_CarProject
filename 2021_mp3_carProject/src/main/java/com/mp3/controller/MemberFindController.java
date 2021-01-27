package com.mp3.controller;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mp3.domain.MemberVO;
import com.mp3.service.MemberFindService;


import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller	// 스프링의 빈으로 인식
@Log4j		
@RequestMapping("/memberFind/*")	// /memberFind로 시작하는 모든 처리를 MemberController가 처리하도록 지정
@AllArgsConstructor	
public class MemberFindController {
	
	private MemberFindService service;
	

	
//	아이디 찾기 폼 
	@GetMapping("/findIdInputMail")
	public String loginMail() {
		return "/common/auth/findIdInputMail";
	}
	
//	아이디 찾기 폼 
	@PostMapping("/findIdInputMail")
	public String find_id_Mail(MemberVO member ,Model model){
		log.info("이름값"+member.getMember_name()+"메일값"+member.getMember_mail());
		model.addAttribute("result", service.MemverIDFindMail(member));
		
		return "/common/auth/findIdInputMail";
	}

		// 비밀번호 찾기
	@GetMapping("/findPassInputMail")
	public String find_pw_Mail() {
		 return"common/auth/findPassInputMail" ;
	}
	
//	 // 비밀번호 찾기
	@PostMapping("/findPassInputMail")
	public String find_pw_Mail(MemberVO member, Model model) {
		log.info("아이디값"+member.getMember_id()+"이름 값"+member.getMember_name()+"메일 값");
		model.addAttribute("result", service.MemverPassFindMail(member));
		return"common/auth/findPassInputMail" ;
		 		
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

