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
	
	//ȸ�� ���� ���� ������ (Test��)
	@GetMapping("/myInfo")
	public String myinfo() {
		
		return "/member/mypage/myInfo";
	}
	
	//ȸ����ȣ �Է� ������ (Test�� ! ���������� �α��� ���ִ� ȸ����ȣ�� �����ͼ� myInfoReadFinished�� �ٷ� ������)
	 @GetMapping("/myInfoRead")
	  public String myInfoRead() {
		 return "/member/mypage/myInfoRead";
	  }
	 //������ ���� ������
	 //(���� ������ myInfo,myInfoRead ���� �� myInfoReadFinished������ �ٷΰ�!  �� ��������myInfo������ ��ũ �߰� )
	 @GetMapping("/myInfoReadFinished")
	  public String myInfoReadFinished(Model model, Long member_no) {
		 model.addAttribute("member",service.myInfoRead(member_no));
		 return "/member/mypage/myInfoReadFinished";
	  }
	 
	 
	 //�� ���� Ż�� ������
	 @GetMapping("/myInfoDelete")
	  public String myInfoDelete() {
		 return "/member/mypage/myInfoDelete";
	  }
	 
	 //��й�ȣ �Է�Ȯ�� ������
	 @GetMapping("/myInfoDeletePassCheck")
	  public String myInfoDeletePassCheck(Model model,String Deletenum ,Long member_no) {
		 model.addAttribute("message",service.myInfoDeletePassCheck(member_no));
		 String message=null;
		 MemberVO member = new MemberVO();
		 member.setMember_pass("1234");
		 log.info(member.getMember_pass()+"������ ��й�ȣ !!!!!!!");
		 member.setMember_pass_user(Deletenum);
		 log.info("����ڰ� �Է��� ȸ����ȣ"+member.getMember_pass_user());
		 log.info("���� ��й�ȣ"+member.getMember_pass());
		 if (member.getMember_pass_user().equals(member.getMember_pass())) {
				log.info("��Ʈ�ѷ� ȭ�� : ��й�ȣ Ȯ�� ���� !!");
				message = "ȸ��Ż�� �����Դϴ�";
				model.addAttribute("message",service.myInfoDeletePassCheck(member_no));
				return "/member/mypage/myInfoDeleteFinished";
			} else {
				log.info("��Ʈ�ѷ� ȭ�� : ��й�ȣ Ȯ�� ���� !!");
				message = "��й�ȣ ���� �ٽ��Է�";
				model.addAttribute("message",message);
				return "/member/mypage/myInfoDelete";
				
			}
	
	 }
	 
	 
	 
	 //�� ���� Ż�� ��� ������
	 @GetMapping("/myInfoDeleteFinished")
	  public String myInfoDeleteFinished(Model model,Long member_no) {
		 log.info("���������������"+member_no);
		
		 return "/member/mypage/myInfoDeleteFinished";
	  }
	
	 
	 // ������ ȸ����ȣ �Է� ������
	 @GetMapping("/myInfoUpdate")
	  public String myInfoUpdate(Model model,Long member_no) {
		 model.addAttribute("member",member_no);
		 log.info("������ ȸ�� ��ȣ :"+member_no);
		
		 return "/member/mypage/myInfoUpdate";
	 }
	 
	 //������ ����������
	 @GetMapping("/myInfoUpdateList")
	  public String myInfoUpdateList(Model model,Long member_no) {
		 model.addAttribute("member",service.myInfoRead(member_no));
		 log.info("������ ȸ�� ��ȣ :"+member_no);
		 return "/member/mypage/myInfoUpdateList";
	  }
	 
	 //������ ���� Ȯ�� ������
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
		 log.info("������ ȸ�� ���� :"+member);
		 return "/member/mypage/myInfoUpdatePassCheck";
	  }
	 

}







