
package com.mp3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mp3.domain.CarRegistrationVO;
import com.mp3.service.CarRegistrationService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j		
@RequestMapping("/mycar/*")	// /memberFind로 시작하는 모든 처리를 MemberController가 처리하도록 지정
@AllArgsConstructor
public class CarRegistrationController {
	
	private CarRegistrationService service;
	@GetMapping("/carReg1_company")
	public String  car_Mycar() {
		return "member/mycar/carReg1_company";
	}
	
	@PostMapping("/carReg1_company")
	public void  Mycar(CarRegistrationVO carRegistration,Model model){
		model.addAttribute("Member",service.Mycar(carRegistration));
		
		
	}
	
}
	
