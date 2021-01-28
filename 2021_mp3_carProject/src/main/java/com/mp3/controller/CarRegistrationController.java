
package com.mp3.controller;

import java.security.Principal;

import org.apache.logging.log4j.core.tools.picocli.CommandLine.Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mp3.domain.CarRegistrationVO;
import com.mp3.domain.CustomUser;
import com.mp3.domain.MemberVO;
import com.mp3.service.CarRegistrationService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j		
@RequestMapping("/mycar/*")	// /memberFind�� �����ϴ� ��� ó���� MemberController�� ó���ϵ��� ����
@AllArgsConstructor
public class CarRegistrationController {
	
	private CarRegistrationService service;
	@GetMapping("/carReg1_company")
	public String  car_Mycar() {
		return "member/mycar/carReg1_company";
	}
	
	@PostMapping("/carReg1_company")
	public String  Mycar(CarRegistrationVO carRegistration,Model model){
		model.addAttribute("Mycar",service.Mycar(carRegistration));
		return "member/mycar/carReg1_company";
		
	}



	
	@GetMapping("/myCarUpdate")
	public String  car_myCarUpdate(Principal principal,Model model) {
		log.info("�̰� �α��ε� ���� ���̵��!"+principal.getName());
	
		String member_id=principal.getName();
		if(member_id != null) {
			CarRegistrationVO carRegistrationVO= new CarRegistrationVO();
			carRegistrationVO.setMember_id(member_id);
			CarRegistrationVO carRegistration = service.Mycarlist(member_id);
			model.addAttribute("Mycarlist",service.Mycarlist(member_id));
			log.info("���� ���ô�"+carRegistration);
			
		}
		return "member/mycar/myCarUpdate";	
	
	}
	
	@PostMapping("/myCarUpdate")
	public String  myCarUpdate1(CarRegistrationVO carRegistration,Model model){
		
		model.addAttribute("carUpdate",service.MycarUpdate(carRegistration));
		
		log.info("���� ����ʹ�."+service.MycarUpdate(carRegistration));
		return "member/mycar/myCarUpdate";
		
	}


	

////	http://localhost:8081/mycar/myCarlist?member_id=user963852
//	@PostMapping("/myCarlist")
//	public String Mycarlist(String member_id , Model model){
//	
//		CarRegistrationVO carRegistrationVO= new CarRegistrationVO();
//		carRegistrationVO.setMember_id(member_id);
//		CarRegistrationVO carRegistration = service.Mycarlist(member_id);
//		model.addAttribute("Mycarlist",service.Mycarlist(member_id));
//		log.info("���� ���ô�"+carRegistration);
//		return "member/mycar/myCarlist";
//	}
//
//}
}
