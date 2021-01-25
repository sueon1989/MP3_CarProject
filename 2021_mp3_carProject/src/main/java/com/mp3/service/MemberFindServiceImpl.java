package com.mp3.service;





import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.HtmlEmail;
import org.springframework.stereotype.Service;

import com.mp3.domain.MemberVO;
import com.mp3.mapper.MemberFindMapper;
import com.mp3.mapper.MemberMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class MemberFindServiceImpl implements MemberFindService {
	
	private MemberFindMapper mapper;
	private MemberMapper mapper1;
	


	
	@Override
	public void send_mail(MemberVO member,String div) {		
		// 이메일 발송
			log.debug("메일보내기");
			// Mail Server 설정
			String charSet = "utf-8";
			String hostSMTP = "smtp.naver.com";
			String hostSMTPid = "ghgh4075@naver.com";
			String hostSMTPpwd = "##";

			// 보내는 사람 EMail, 제목, 내용
			String fromEmail = "ghgh4075@naver.com";
			String fromName = "main";
			String subject = "";
			String msg = "";
			
			if(div.equals("MemverIDFindMail")) {
				subject = " 회원 정보로 가입된 아이디 입니다.";
				msg += "<div align='center' style='border:1px solid black; font-family:verdana'>";
				msg += "<h3 style='color: blue;'>";
				msg += member.getMember_name() + "님의 가입된 아이디 입니다.</h3>";
				msg += "<p>가입된 아이디 : ";
				msg += member.getMember_id() + "</p><br>";
				
				msg += "<p>비밀번호 찾기.";
				msg += "<form method='get' action='http://localhost:8081/memberFind/findIdInputMail'>";
				msg += "<input type='submit' value='비밀번호 찾기'></form></p><br>";
				
				msg += "<p>로그인 하러가기.";
				msg += "<form method='get' action='http://localhost:8081/customLogin'>";
				msg += "<input type='submit' value='로그인 하러가기'></form></p></div>";	
				log.info(msg);
			}	
			else if(div.equals("MemverPassFindMail")) {
				subject = " 임시 비밀번호 입니다.";
				msg += "<div align='center' style='border:1px solid black; font-family:verdana'>";
				msg += "<h3 style='color: blue;'>";
				msg += member.getMember_id() + "님의 임시 비밀번호 입니다. 비밀번호를 변경하여 사용하세요.</h3>";
				msg += "<h3><p>임시 비밀번호 : ";
				msg += member.getMember_pass() + "</p></h3>";				
				
				msg += "<form method='get' action='http://localhost:8081/customLogin'>";
				msg += "<h2><input type='submit' value='로그인 하러가기'></h2></form></div>";	
			}
		
			// 받는 사람 E-Mail 주소
			String mail = member.getMember_mail();
			try {
				HtmlEmail email = new HtmlEmail();
				email.setDebug(true);
				email.setCharset(charSet);
				email.setSSL(true);
				email.setHostName(hostSMTP);
				email.setSmtpPort(587);

				email.setAuthentication(hostSMTPid, hostSMTPpwd);
				email.setTLS(true);
				email.addTo(mail, charSet);
				email.setFrom(fromEmail, fromName, charSet);
				email.setSubject(subject);
				email.setHtmlMsg(msg);
				email.send();
			} catch (Exception e) {
				System.out.println("메일발송 실패 : " + e);
			}
		}
	//아이디 찾기
	@Override
	public MemberVO MemverIDFindMail(MemberVO member) {
		mapper.MemverIDFindMail(member);
			//메일 발송
			send_mail(member, "MemverIDFindMail");
			log.info(member);		
			
		return member;
	}
	
	//비밀번호 찾기	
	@Override
	public MemberVO MemverPassFindMail(MemberVO member) {
		boolean checkId = mapper1.checkId(member) == 1;
		
			String member_pw= "";
			for (int i = 0; i < 12; i++) {
				member_pw += (char) ((Math.random() * 26) + 97);
			}
				member.setMember_pass(member_pw);		
				mapper.MemverPassFindMail(member);
				// 비밀번호 변경 메일 발송
			
				send_mail(member, "MemverPassFindMail");
				log.info(member);	
				
		return 	member;	
	}
	
	
}	
	
	
	
	
	
	

