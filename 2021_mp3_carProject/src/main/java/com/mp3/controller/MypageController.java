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
	
	
	 //������ ���� ������http://localhost:8082/#ui-elements
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
		 log.info(gps.getLatitude()+"****gps.getLatitude()�� �α�����");
		 model.addAttribute("Longitude", gps.getLongitude());
		 log.info(gps.getLongitude()+"****gps.getLongitude()�� �α�����");
		 return "/member/mypage/mapView";
	  }
	 
	 
	 //map test
	 @GetMapping("/ViewTest")
		public String ViewTest(/* GpsVO gps, */Model model) {
		 GpsVO gps = service.mapView();
		 model.addAttribute("Latitude", gps.getLatitude());
		 log.info(gps.getLatitude()+"****gps.getLatitude()�� �α�����");
		 model.addAttribute("Longitude", gps.getLongitude());
		 log.info(gps.getLongitude()+"****gps.getLongitude()�� �α�����");
		 return "/member/mypage/ViewTest";
	  }
	 
	 //map test
	 @GetMapping("/ViewTest1")
		public String ViewTest1(/* GpsVO gps, */Model model) {
		 GpsVO gps = service.mapView();
		 model.addAttribute("Latitude", gps.getLatitude());
		 log.info(gps.getLatitude()+"****gps.getLatitude()�� �α�����");
		 model.addAttribute("Longitude", gps.getLongitude());
		 log.info(gps.getLongitude()+"****gps.getLongitude()�� �α�����");
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


	 
	 //�� ���� ���� �󼼺��� ������
	 @GetMapping("/myInfoCar")
	  public String myInfoCar() {
		 return "/member/mypage/myInfoCar";
	  }
	 
	 
	 //�� ���� Ż�� ������
	 //��й�ȣ Ȯ�� ������
	 @GetMapping("/myInfoDelete")
	  public String myInfoDelete() {
		 return "/member/mypage/myInfoDelete";
	  }
	 

	 //��й�ȣ �Է�Ȯ�� ������
	 @PostMapping("/myInfoDeletePassCheck")
	  public String myInfoDeletePassCheck(Model model,String Deletenum ,String Deletenum1,Long member_no,String member_id) {
//		 model.addAttribute("message",service.myInfoDeletePassCheck(member_no));
		 String message=null;
		 MemberVO member = new MemberVO();
		 member.setMember_no(member_no);
		 member.setMember_id(member_id);
		 member.setMember_pass_user(Deletenum);
		 log.info(matches(Deletenum, Deletenum1)+"��ġ �α� �޼��� ���� !~!~!~!");
//		 encoder.matches(rawPassword, encodedPassword)
//		 log.info("��ġ �Լ� �̿� �� ��� : " + encoder.matches(Deletenum, Deletenum1));
		 encoder.hashCode();
		 log.info("����ڰ� �Է��� ��й�ȣ Ȯ�� : " +Deletenum + "    ");
		 log.info("���������� ���� ��й�ȣ Ȯ�� : " +Deletenum1 + "    ");
		 log.info("���������� ���� ������ �ٲ� ��ȣ Ȯ�� : " +member_no + "    ");
		 log.info("DB�� ����� �ִ� "+member_no+"�� ��й�ȣ"+ member.getMember_pass());
		 log.info(member.getMember_pass()+"������ ��й�ȣ !!!!!!!");
		 member.setMember_pass_user(Deletenum);
		 log.info("����ڰ� �Է��� ȸ����ȣ"+member.getMember_pass_user());
		 log.info("���� ��й�ȣ"+member.getMember_pass());
		 if (matches(member.getMember_pass_user(), member.getMember_pass())==true) {
				log.info("��Ʈ�ѷ� ȭ�� : ��й�ȣ Ȯ�� ���� !!");
				 service.myInfoDeletePassCheck(member_no,Deletenum,Deletenum1);
				 service.DeleteNum(Deletenum);
				message = "ȸ��Ż�� �����Դϴ�";
				model.addAttribute("message",message);
				return "/member/mypage/myInfoDeletePassCheck";
			} else {
				log.info("��Ʈ�ѷ� ȭ�� : ��й�ȣ Ȯ�� ���� !!");
				message = "��й�ȣ ���� �ٽ��Է�";
				model.addAttribute("message",message);
				return "/member/mypage/myInfoDelete";
			}
	
	 }
	 
	 
	 
	 
	 
	 private boolean matches(String member_pass_user, String member_pass) {
	// TODO Auto-generated method stub
	return false;
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
	 
	 //������ ���� Ȯ�� ������
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
		 log.info("������ ȸ�� ���� :"+member);
		 return "/member/mypage/myInfoUpdatePassCheck";
	  }
	 
	 
	 
	 
	 
		// �н����� üũ
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
//		//ȸ��Ż�� ���̵�� üũ
//		 @PostMapping("/passID")
//		  public String passID(Model model,String Deleteid ,String Deletenum1,Long member_no) {
////			 model.addAttribute("message",service.myInfoDeletePassCheck(member_no));
//			 String message=null;
//			 MemberVO member = new MemberVO();
//			 member.setMember_no(member_no);
//			 member.setMember_id(Deleteid);
//			 String result = service.passID(Deleteid);
//			 log.info("����ڰ� �Է��� ���̵� Ȯ�� : " +Deleteid + "    ");
//			 log.info("���������� ���� ��й�ȣ Ȯ�� : " +Deletenum1 + "    ");
//			 log.info("���������� ���� ������ �ٲ� ��ȣ Ȯ�� : " +member_no + "    ");
//			 member.setMember_id(Deleteid);
//			 log.info("����ڰ� �Է��� id  : "+member.getMember_id());
//			 if (result =="����") {
//					log.info("��Ʈ�ѷ� ȭ�� : ��й�ȣ Ȯ�� ���� !!");
//					message = "ȸ��Ż�� �����Դϴ�";
//					model.addAttribute("message",message);
//					return "/member/mypage/myInfoDeletePassCheck";
//				} else {
//					log.info("��Ʈ�ѷ� ȭ�� : ��й�ȣ Ȯ�� ���� !!");
//					message = "��й�ȣ ���� �ٽ��Է�";
//					model.addAttribute("message",message);
//					return "/member/mypage/myInfoDelete";
//				}
//		 }
}










