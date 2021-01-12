package com.mp3.mapper;


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
public class MemberFindMapperTests {

	@Autowired
	private MemberFindMapper mapper;
	
	
	@Test
	public void MemverIDFindMail() {
		MemberVO member = new MemberVO();
		member.setMember_name("�����10");
		member.setMember_mail("ghgh9795@naver.com");
		mapper.MemverIDFindMail(member);
	 log.info(member);
		
	}
	

	@Test
	public void MemverPassFindMail() {
		MemberVO member = new MemberVO();
		member.setMember_pass("123");
		member.setMember_id("user10");
		member.setMember_name("�����10");
		member.setMember_mail("test@mp3.com");
		mapper.MemverPassFindMail(member); 
	}

	
	
}
