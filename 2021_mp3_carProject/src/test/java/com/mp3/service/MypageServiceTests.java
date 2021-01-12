package com.mp3.service;

import static org.junit.Assert.assertNotNull;

import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mp3.domain.MemberVO;
import com.mp3.mapper.MypageMapper;
import com.mp3.service.MypageService;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MypageServiceTests {
	
	@Autowired
	private MypageService service;
	private MypageMapper mapper;
	@Test
	public void testExitst() {
		assertNotNull(service);
	}

	//�� ���� ���� ���� �׽�Ʈ
	@Test
	public void testmyInfoRead() {
		MemberVO memberVO = service.myInfoRead(95L);	
		log.info(memberVO);	

	}
	//ȸ��Ż�� ���� �׽�Ʈ
	@Test
	public void testmyInfoDelete() {
		log.info("ȸ�� Ż�� ����" +service.myInfoDeletePassCheck(4L));	

	}
	
	//ȸ��Ż�� ��й�ȣ Ȯ�� �׽�Ʈ
	@Test
	public void testmyInfoDeletePassCheck() {
		service.myInfoDeletePassCheck(1L);	


	}
	//�� ���� ���� Ȯ�� �׽�Ʈ
	@Test
	public void testmyInfoUpdate() {
		//������ȸ�� ��ȣ 
		MemberVO member = service.myInfoRead(7L);
		member.setMember_id("777");
		member.setMember_pass("33333");
		member.setMember_name("���翵11");
		member.setMember_gender("��");
		member.setMember_birth(Date.valueOf("2017-12-30"));	
		member.setMember_phone("010-7777-7777");
		member.setMember_address("����Ư����");
		member.setMember_mail("123123123123@mp3.com");
		member.setMember_mailaccept("no");	
		
		log.info("���������� ������ ���� ���: "+ service.myInfoUpdate(member));
		log.info(member);
	}
	
	
	
	
}















