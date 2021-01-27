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

@Controller	// �������� ������ �ν�
@Log4j		
@RequestMapping("/memberFind/*")	// /memberFind�� �����ϴ� ��� ó���� MemberController�� ó���ϵ��� ����
@AllArgsConstructor	
public class MemberFindController {
	
	private MemberFindService service;
	

	
//	���̵� ã�� �� 
	@GetMapping("/findIdInputMail")
	public String loginMail() {
		return "/common/auth/findIdInputMail";
	}
	
//	���̵� ã�� �� 
	@PostMapping("/findIdInputMail")
	public String find_id_Mail(MemberVO member ,Model model){
		log.info("�̸���"+member.getMember_name()+"���ϰ�"+member.getMember_mail());
		model.addAttribute("result", service.MemverIDFindMail(member));
		
		return "/common/auth/findIdInputMail";
	}

		// ��й�ȣ ã��
	@GetMapping("/findPassInputMail")
	public String find_pw_Mail() {
		 return"common/auth/findPassInputMail" ;
	}
	
//	 // ��й�ȣ ã��
	@PostMapping("/findPassInputMail")
	public String find_pw_Mail(MemberVO member, Model model) {
		log.info("���̵�"+member.getMember_id()+"�̸� ��"+member.getMember_name()+"���� ��");
		model.addAttribute("result", service.MemverPassFindMail(member));
		return"common/auth/findPassInputMail" ;
		 		
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

