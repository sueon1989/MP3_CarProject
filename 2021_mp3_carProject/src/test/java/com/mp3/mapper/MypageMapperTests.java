package com.mp3.mapper;

import java.sql.Date;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.mp3.domain.MemberVO;

import com.mp3.domain.MemberVO;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)	// ���� �׽�Ʈ �ڵ尡 �������� �����ϴ� ������ �� ��
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MypageMapperTests {
	
	@Autowired
	private MypageMapper mapper;
	
	// ȸ�� ���(����Ʈ)
	@Test
	public void testGetList() {
		mapper.getList().forEach(member -> log.info(member));
	}
	
	//�� ���� ����
	@Test
	public void myInfoRead() {
		MemberVO member= mapper.myInfoRead(292L);	// member_no 95�� ���� ȣ��
		log.info(member);
		
	}
	
//	//Ż�� ��й�ȣ Ȯ��
//	@Test
//	public void myInfoDeletePassCheck() {
//		MemberVO member= mapper.myInfoDeletePassCheck(1L);			
//		log.info(member);
//	}
//	
	// Ż��	 (ȸ����ȣ ���)
	@Test
	public void myInfoDelete() {
		mapper.myInfoDelete_auth(292L);
		mapper.myInfoDelete_member(292L);
		log.info(mapper.myInfoDelete_auth(292L));
		log.info(mapper.myInfoDelete_member(292L));
	
	}
		
	
	//ȸ������ ����
		@Test
		public void myInfoUpdate() {
			MemberVO member = new MemberVO();			
			member.setMember_no(7L);
			member.setMember_id("1111");
			member.setMember_pass("1111");
			member.setMember_name("���翵");
			member.setMember_gender("��");
			member.setMember_birth(Date.valueOf("2017-12-30"));	
			member.setMember_phone("010-7777-7777");
			member.setMember_address("����Ư����");
			member.setMember_mail("123123123123@mp3.com");
			member.setMember_mailaccept("no");	
			mapper.myInfoUpdate(member);
		}
		
		
		
		
	
	
	/*		@Test
public void testInsert() {
		MemberVO memberVO = new MemberVO();
		memberVO.setMember_id("jaeyoungTest11");
		memberVO.setMember_pass("Test");
		memberVO.setMember_name(" Test");
		memberVO.setMember_gender("��");
		memberVO.setMember_birth("2020-11-11");
		memberVO.setMember_phone("010-1111-5555");
		memberVO.setMember_address("ȸ������ Test");
		memberVO.setMember_mail("ȸ������@Test");
		memberVO.setMember_mailaccept("Test");
		mapper.insert(memberVO);		
		log.info(memberVO);		
	
	}*/
}

