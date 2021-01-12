package com.mp3.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mp3.domain.MemberVO;
import com.mp3.service.MypageService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/mypage") 
public class MypageController {
	
	@Autowired
	private MypageService service;
	
	//회원 정보 관리 페이지 (Test용)
	@GetMapping("/myInfo")
	public String myinfo() {
		
		return "/member/mypage/myInfo";
	}
	
	//회원번호 입력 페이지 (Test용 ! 최종구현은 로그인 되있는 회원번호를 가져와서 myInfoReadFinished로 바로 보낼것)
	 @GetMapping("/myInfoRead")
	  public String myInfoRead() {
		 return "/member/mypage/myInfoRead";
	  }
	 //내정보 보기 페이지
	 //(최종 구현은 myInfo,myInfoRead 삭제 후 myInfoReadFinished페이지 바로가!  이 페이지에myInfo페이지 링크 추가 )
	 @GetMapping("/myInfoReadFinished")
	  public String myInfoReadFinished(Model model, Long member_no) {
		 model.addAttribute("member",service.myInfoRead(member_no));
		 return "/member/mypage/myInfoReadFinished";
	  }
	 
	 
	 //내 정보 탈퇴 페이지
	 @GetMapping("/myInfoDelete")
	  public String myInfoDelete() {
		 return "/member/mypage/myInfoDelete";
	  }
	 
	 //비밀번호 입력확인 페이지
	 @GetMapping("/myInfoDeletePassCheck")
	  public String myInfoDeletePassCheck(Model model,String Deletenum ,Long member_no) {
		 model.addAttribute("message",service.myInfoDeletePassCheck(member_no));
		 String message=null;
		 MemberVO member = new MemberVO();
		 member.setMember_pass("1234");
		 log.info(member.getMember_pass()+"가져온 비밀번호 !!!!!!!");
		 member.setMember_pass_user(Deletenum);
		 log.info("사용자가 입력한 회원번호"+member.getMember_pass_user());
		 log.info("원래 비밀번호"+member.getMember_pass());
		 if (member.getMember_pass_user().equals(member.getMember_pass())) {
				log.info("컨트롤러 화면 : 비밀번호 확인 성공 !!");
				message = "회원탈퇴 성공입니다";
				model.addAttribute("message",service.myInfoDeletePassCheck(member_no));
				return "/member/mypage/myInfoDeleteFinished";
			} else {
				log.info("컨트롤러 화면 : 비밀번호 확인 실패 !!");
				message = "비밀번호 오류 다시입력";
				model.addAttribute("message",message);
				return "/member/mypage/myInfoDelete";
				
			}
	
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
	 
	 //내정보 수정페이지
	 @GetMapping("/myInfoUpdateList")
	  public String myInfoUpdateList(Model model,Long member_no) {
		 model.addAttribute("member",service.myInfoRead(member_no));
		 log.info("수정할 회원 번호 :"+member_no);
		 return "/member/mypage/myInfoUpdateList";
	  }
	 
	 //내정보 수정 확인 페이지
	 @GetMapping("/myInfoUpdatePassCheck")
	  public String myInfoUpdatePassCheck(Model model,Long member_no,String member_id,String member_name,
			  String member_gender/*,Date member_birth*/,String member_phone,String member_address,String member_mail,String member_mailaccept) {
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
		 model.addAttribute("member",service.myInfoUpdate(member));
		 log.info("수정된 회원 정보 :"+member);
		 return "/member/mypage/myInfoUpdatePassCheck";
	  }
	 

}







