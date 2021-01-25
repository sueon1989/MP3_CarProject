package com.mp3.service;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mp3.domain.MemberVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)	// ���� �׽�Ʈ �ڵ尡 �������� �����ϴ� ������ �� ��
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemberFindServiceTests {
	
	@Autowired
	private MemberFindService service;
	
	@Test
	public void MemverIDFindMail() {
		MemberVO member = new MemberVO();
		member.setMember_name("�����1");
		member.setMember_mail("test@mp3.com");
		service.MemverIDFindMail(member);		
		log.info(member);
	}

	// ��й�ȣ ã���׽�Ʈ
	@Test
	public void MemverPassFindMail() {
		String pw= "";
		for (int i = 0; i < 12; i++) {
			pw += (char) ((Math.random() * 26) + 97);
		}		
		
		MemberVO member = new MemberVO();
		member.setMember_pass("pw");
		member.setMember_id("user1");
		member.setMember_name("�����1");
		member.setMember_mail("test@mp3.com");
		service.MemverPassFindMail(member); 
		log.info(member);
		
	}
}	
	

