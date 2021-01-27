package com.mp3.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
//@RequestMapping("/Intro") 
public class CommonController {
	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {

		log.info("access Denied : " + auth);

		model.addAttribute("msg", "Access Denied");
	}

	@GetMapping("/customLogin")
	public String loginInput(String error, String logout, Model model) {


		if (error != null) {
			model.addAttribute("error", "정확한 ID/PW를 입력해주세요");
		}

		if (logout != null) {
			model.addAttribute("logout", "로그아웃이 정상적으로 완료되었습니다");
		}
		
		log.info("error: " + error);
		log.info("logout: " + logout);
		return "/common/auth/customLogin";
	}

	@GetMapping("/customLogout")
	public String logoutGET() {

		log.info("custom logout");
		return "/common/auth/customLogout";
	}
	
	//서비스소개 페이지 연결
	@GetMapping("/ServiceInfo")
	public String ServiceInfo() {

		return "/common/Intro/ServiceInfo";
	}

//	@PostMapping("/customLogout")
//	public void logoutPost() {
//
//		log.info("post custom logout");
//	}
}
