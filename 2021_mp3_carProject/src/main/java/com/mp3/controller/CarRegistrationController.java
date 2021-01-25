
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
	public String  Mycar(CarRegistrationVO carRegistration,Model model){
		model.addAttribute("Mycar",service.Mycar(carRegistration));
		return "member/mycar/carReg1_company2";
		
	}
	

	@GetMapping("/myCarUpdate")
	public String  car_myCarUpdate() {
		return "member/mycar/myCarUpdate";
	}
	
	@PostMapping("/myCarUpdate")
	public String  myCarUpdate(CarRegistrationVO carRegistration,Model model){
		model.addAttribute("MycarUpdate",service.MycarUpdate(carRegistration));
		return "member/mycar/myCarUpdate1";
		
	}
	
	@GetMapping("/myCarlist")
	public String car_Mycarlist(){
		return "member/mycar/myCarlist";
	}
	
	@PostMapping("/myCarlist")
	public String Mycarlist(String member_id,Model model){
		model.addAttribute("Mycarlist",service.Mycarlist(member_id));
		return "member/mycar/myCarlist";
	}
	
	
}
	
