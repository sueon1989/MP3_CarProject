package com.mp3.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mp3.domain.GpsVO;
import com.mp3.domain.MemberVO;
import com.mp3.service.MypageService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/mypage") 
public class MypageController {
	
	BCryptPasswordEncoder encoder;
	
	@Autowired
	private MypageService service;
	
	
	 //내정보 보기 페이지http://localhost:8082/#ui-elements
	 @GetMapping("/myInfoRead")
	  public String myInfoRead() {
		 return "/member/mypage/myInfoRead";
	  }
	 
	 //map test
	 @GetMapping("/mapTest")
	  public String mapTest(Model model,String Latitude,String Longitude) {
		 model.addAttribute("Latitude", Latitude);
		 model.addAttribute("Longitude", Longitude);
		 return "/member/mypage/mapTest";
	  }
	 
	 //map View
	 @GetMapping("/mapView")
		public String mapView(/* GpsVO gps, */Model model) {
		 GpsVO gps = service.mapView();
		 model.addAttribute("Latitude", gps.getLatitude());
		 log.info(gps.getLatitude()+"****gps.getLatitude()값 로그인포");
		 model.addAttribute("Longitude", gps.getLongitude());
		 log.info(gps.getLongitude()+"****gps.getLongitude()값 로그인포");
		 return "/member/mypage/mapView";
	  }
	 
	 
	 //map test
	 @GetMapping("/ViewTest")
		public String ViewTest(/* GpsVO gps, */Model model) {
		 GpsVO gps = service.mapView();
		 model.addAttribute("Latitude", gps.getLatitude());
		 log.info(gps.getLatitude()+"****gps.getLatitude()값 로그인포");
		 model.addAttribute("Longitude", gps.getLongitude());
		 log.info(gps.getLongitude()+"****gps.getLongitude()값 로그인포");
		 return "/member/mypage/ViewTest";
	  }
	 
	 //map test
	 @GetMapping("/ViewTest1")
		public String ViewTest1(/* GpsVO gps, */Model model) {
		 GpsVO gps = service.mapView();
		 model.addAttribute("Latitude", gps.getLatitude());
		 log.info(gps.getLatitude()+"****gps.getLatitude()값 로그인포");
		 model.addAttribute("Longitude", gps.getLongitude());
		 log.info(gps.getLongitude()+"****gps.getLongitude()값 로그인포");
		 return "/member/mypage/ViewTest1";
	  }
	 

	 

	 //map test
	 @GetMapping("/mapResult")
	  public String mapResult(Model model,String Latitude,String Longitude) {
		 GpsVO gps = new GpsVO();
		 model.addAttribute("Latitude", Latitude);
		 model.addAttribute("Longitude", Longitude);
		 log.info("1");
		 gps.setLatitude(Latitude);
		 gps.setLongitude(Longitude);
		 log.info("2");
		 service.gps(Latitude, Longitude);
		 log.info("3");
		 return "/member/mypage/mapResultTest";
	  }	 


	 
	 //내 차량 정보 상세보기 페이지
	 @GetMapping("/myInfoCar")
	  public String myInfoCar() {
		 return "/member/mypage/myInfoCar";
	  }
	 
	 
	 //내 정보 탈퇴 페이지
	 //비밀번호 확인 페이지
	 @GetMapping("/myInfoDelete")
	  public String myInfoDelete() {
		 return "/member/mypage/myInfoDelete";
	  }
	 

	 //비밀번호 입력확인 페이지
	 @PostMapping("/myInfoDeletePassCheck")
	  public String myInfoDeletePassCheck(Model model,String Deletenum ,String Deletenum1,Long member_no,String member_id) {
//		 model.addAttribute("message",service.myInfoDeletePassCheck(member_no));
		 String message=null;
		 MemberVO member = new MemberVO();
		 member.setMember_no(member_no);
		 member.setMember_id(member_id);
		 member.setMember_pass_user(Deletenum);
		 log.info(matches(Deletenum, Deletenum1)+"매치 로그 메세지 보기 !~!~!~!");
//		 encoder.matches(rawPassword, encodedPassword)
//		 log.info("매치 함수 이용 비교 결과 : " + encoder.matches(Deletenum, Deletenum1));
		 encoder.hashCode();
		 log.info("사용자가 입력한 비밀번호 확인 : " +Deletenum + "    ");
		 log.info("페이지에서 보낸 비밀번호 확인 : " +Deletenum1 + "    ");
		 log.info("페이지에서 보낸 값으로 바뀐 번호 확인 : " +member_no + "    ");
		 log.info("DB에 저장되 있던 "+member_no+"의 비밀번호"+ member.getMember_pass());
		 log.info(member.getMember_pass()+"가져온 비밀번호 !!!!!!!");
		 member.setMember_pass_user(Deletenum);
		 log.info("사용자가 입력한 회원번호"+member.getMember_pass_user());
		 log.info("원래 비밀번호"+member.getMember_pass());
		 if (matches(member.getMember_pass_user(), member.getMember_pass())==true) {
				log.info("컨트롤러 화면 : 비밀번호 확인 성공 !!");
				 service.myInfoDeletePassCheck(member_no,Deletenum,Deletenum1);
				 service.DeleteNum(Deletenum);
				message = "회원탈퇴 성공입니다";
				model.addAttribute("message",message);
				return "/member/mypage/myInfoDeletePassCheck";
			} else {
				log.info("컨트롤러 화면 : 비밀번호 확인 실패 !!");
				message = "비밀번호 오류 다시입력";
				model.addAttribute("message",message);
				return "/member/mypage/myInfoDelete";
			}
	
	 }
	 
	 
	 
	 
	 
	 private boolean matches(String member_pass_user, String member_pass) {
	// TODO Auto-generated method stub
	return false;
}


	//내 정보 탈퇴 결과 페이지
	 @GetMapping("/myInfoDeleteFinished")
	  public String myInfoDeleteFinished(Model model,Long member_no) {
		 log.info("결과결과결과결과결과"+member_no);
		
		 return "/member/mypage/myInfoDeleteFinished";
	  }
	
	 
	 // 수정할 회원번호 입력 페이지
	 @GetMapping("/myInfoUpdate")
	  public String myInfoUpdate(Model model,Long member_no) {
		 model.addAttribute("member",member_no);
		 log.info("수정할 회원 번호 :"+member_no);
		
		 return "/member/mypage/myInfoUpdate";
	 }
	 
	 //내정보 수정 확인 페이지
	 @PostMapping("/myInfoUpdatePassCheck")
	  public String myInfoUpdatePassCheck(Model model,Long member_no,String member_id,String member_name,
		String member_gender,Date member_birth,String member_phone,String member_address,String member_mail,String member_mailaccept) {
		 MemberVO member = new MemberVO();
		 member.setMember_no(member_no);
		 member.setMember_id(member_id);
		 member.setMember_name(member_name);
		 member.setMember_gender(member_gender);
//		 member.setMember_birth(member_birth);
		 member.setMember_phone(member_phone);
		 member.setMember_address(member_address);
		 member.setMember_mail(member_mailaccept);
		 member.setMember_mailaccept(member_mailaccept);
		 model.addAttribute("member",service.myInfoUpdatePassCheck(member));
		 log.info("수정된 회원 정보 :"+member);
		 return "/member/mypage/myInfoUpdatePassCheck";
	  }
	 
	 
	 
	 
	 
		// 패스워드 체크
//		@ResponseBody
//		@RequestMapping(value="/passChk", method = RequestMethod.POST)
//		public String passChk(Model model,String Deletenum ,String Deletenum1,String member_id) throws Exception {
//			MemberVO member = new MemberVO();
//			member.setMember_id(member_id);
//			member.setMember_pass_user(Deletenum);
//			member.setMember_pass(Deletenum1);
//			int result = service.passChk(member);
//			model.addAttribute(result);
//			return "/member/mypage/myInfoUpdatePassCheck";
//		}
//		//회원탈퇴 아이디로 체크
//		 @PostMapping("/passID")
//		  public String passID(Model model,String Deleteid ,String Deletenum1,Long member_no) {
////			 model.addAttribute("message",service.myInfoDeletePassCheck(member_no));
//			 String message=null;
//			 MemberVO member = new MemberVO();
//			 member.setMember_no(member_no);
//			 member.setMember_id(Deleteid);
//			 String result = service.passID(Deleteid);
//			 log.info("사용자가 입력한 아이디 확인 : " +Deleteid + "    ");
//			 log.info("페이지에서 보낸 비밀번호 확인 : " +Deletenum1 + "    ");
//			 log.info("페이지에서 보낸 값으로 바뀐 번호 확인 : " +member_no + "    ");
//			 member.setMember_id(Deleteid);
//			 log.info("사용자가 입력한 id  : "+member.getMember_id());
//			 if (result =="성공") {
//					log.info("컨트롤러 화면 : 비밀번호 확인 성공 !!");
//					message = "회원탈퇴 성공입니다";
//					model.addAttribute("message",message);
//					return "/member/mypage/myInfoDeletePassCheck";
//				} else {
//					log.info("컨트롤러 화면 : 비밀번호 확인 실패 !!");
//					message = "비밀번호 오류 다시입력";
//					model.addAttribute("message",message);
//					return "/member/mypage/myInfoDelete";
//				}
//		 }
}










