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
		// �̸��� �߼�
			log.debug("���Ϻ�����");
			// Mail Server ����
			String charSet = "utf-8";
			String hostSMTP = "smtp.naver.com";
			String hostSMTPid = "ghgh4075@naver.com";
			String hostSMTPpwd = "##";

			// ������ ��� EMail, ����, ����
			String fromEmail = "ghgh4075@naver.com";
			String fromName = "main";
			String subject = "";
			String msg = "";
			
			if(div.equals("MemverIDFindMail")) {
				subject = " ȸ�� ������ ���Ե� ���̵� �Դϴ�.";
				msg += "<div align='center' style='border:1px solid black; font-family:verdana'>";
				msg += "<h3 style='color: blue;'>";
				msg += member.getMember_name() + "���� ���Ե� ���̵� �Դϴ�.</h3>";
				msg += "<p>���Ե� ���̵� : ";
				msg += member.getMember_id() + "</p><br>";
				
				msg += "<p>��й�ȣ ã��.";
				msg += "<form method='get' action='http://localhost:8081/memberFind/findIdInputMail'>";
				msg += "<input type='submit' value='��й�ȣ ã��'></form></p><br>";
				
				msg += "<p>�α��� �Ϸ�����.";
				msg += "<form method='get' action='http://localhost:8081/customLogin'>";
				msg += "<input type='submit' value='�α��� �Ϸ�����'></form></p></div>";	
				log.info(msg);
			}	
			else if(div.equals("MemverPassFindMail")) {
				subject = " �ӽ� ��й�ȣ �Դϴ�.";
				msg += "<div align='center' style='border:1px solid black; font-family:verdana'>";
				msg += "<h3 style='color: blue;'>";
				msg += member.getMember_id() + "���� �ӽ� ��й�ȣ �Դϴ�. ��й�ȣ�� �����Ͽ� ����ϼ���.</h3>";
				msg += "<h3><p>�ӽ� ��й�ȣ : ";
				msg += member.getMember_pass() + "</p></h3>";				
				
				msg += "<form method='get' action='http://localhost:8081/customLogin'>";
				msg += "<h2><input type='submit' value='�α��� �Ϸ�����'></h2></form></div>";	
			}
		
			// �޴� ��� E-Mail �ּ�
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
				System.out.println("���Ϲ߼� ���� : " + e);
			}
		}
	//���̵� ã��
	@Override
	public MemberVO MemverIDFindMail(MemberVO member) {
		mapper.MemverIDFindMail(member);
			//���� �߼�
			send_mail(member, "MemverIDFindMail");
			log.info(member);		
			
		return member;
	}
	
	//��й�ȣ ã��	
	@Override
	public MemberVO MemverPassFindMail(MemberVO member) {
		boolean checkId = mapper1.checkId(member) == 1;
		
			String member_pw= "";
			for (int i = 0; i < 12; i++) {
				member_pw += (char) ((Math.random() * 26) + 97);
			}
				member.setMember_pass(member_pw);		
				mapper.MemverPassFindMail(member);
				// ��й�ȣ ���� ���� �߼�
			
				send_mail(member, "MemverPassFindMail");
				log.info(member);	
				
		return 	member;	
	}
	
	
}	
	
	
	
	
	
	

