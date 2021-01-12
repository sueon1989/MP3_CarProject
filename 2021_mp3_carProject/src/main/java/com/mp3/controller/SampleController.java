package com.mp3.controller;

import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mp3.domain.MemberVO;
import com.mp3.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/sample/*") 
@Controller
@AllArgsConstructor
public class SampleController {


	private MemberService service;	
	
//	/sample/all
	 @GetMapping("/all")
	  public void doAll() {
	    log.info("do all can access everybody");
	  }

//	  /sample/member
	  @GetMapping("/member")
	  public void doMember() {
	    log.info("logined member");
	  }
	  
//	 /sample/admin
	  @GetMapping("/admin")
//	  @PreAuthorize("isAuthenticated()")
	  public void doAdmin(Model model) {
	    log.info("admin only");
	    List<MemberVO> memberList = service.getList();
	    log.info("회원 목록: "+memberList);
		model.addAttribute("list", memberList);
	  } 
	  
	  

	  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MEMBER')")
	  @GetMapping("/annoMember")
	  public void doMember2() {
	    
	    log.info("logined annotation member");
	  }
	  
	  
	  @Secured({"ROLE_ADMIN"})
	  @GetMapping("/annoAdmin")
	  public void doAdmin2() {

	    log.info("admin annotaion only");
	  }
}
