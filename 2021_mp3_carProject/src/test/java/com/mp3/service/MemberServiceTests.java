package com.mp3.service;

import static org.junit.Assert.assertNotNull;

import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mp3.domain.AuthVO;
import com.mp3.domain.MemberVO;

import lombok.extern.log4j.Log4j;

// �����: kim
@RunWith(SpringJUnit4ClassRunner.class)	// ���� �׽�Ʈ �ڵ尡 �������� �����ϴ� ������ �� ��
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemberServiceTests {
	
	@Autowired
	private MemberService service;
	
	@Test
	public void testExist() {
		
		// MemberService ��ü�� ����� ������ �������� Ȯ��
		log.info("���� "+service);
		assertNotNull(service);
	}

	// ���(����Ʈ)
	@Test
	public void testGetList() {
		
		List<MemberVO> memberList = service.getList();
		for(MemberVO member: memberList) {
			log.info(member);
		}
		
		// ���ٽ����� ǥ�� (���� ���)
		// service.getList().forEach(member -> log.info(member));
	}
	
	// ȸ������ - insert ó�� (SelectKey ���)
	@Test
	public void testRegister() {
		
		MemberVO member = new MemberVO();
		member.setMember_id("user2003");	// �����ϴ� ȸ�� id�� �ߺ����� �ʰ� �׽�Ʈ
		member.setMember_pass("1234");
		member.setMember_name("ȫ�浿");
		member.setMember_gender("��");
		member.setMember_birth(Date.valueOf("2010-12-25"));	// String�� Date�� ��ȯ
		member.setMember_phone("010-1245-1231");
		member.setMember_address("���ν�");
		member.setMember_mail("aaa123@mp3.com");
		member.setMember_mailaccept("yes");	
		
		AuthVO auth = new AuthVO();
		auth.setMember_id("user2003");
		auth.setMember_auth("ROLE_USER");
		
		service.register(member, auth);
		
		log.info("������ ȸ����ȣ: "+member.getMember_no());
		log.info("������ ȸ������: "+member);
		log.info("������ ȸ������: "+auth);
	}
	
    //���̵� �ߺ�üũ
	@Test
	public void testCheckId() {
		
		// �����ϴ� ȸ��ID�� �׽�Ʈ
		MemberVO member = new MemberVO();
		member.setMember_id("admin90");

		log.info("���̵� �ߺ�üũ ���: "+service.checkId(member));
		// �ߺ�ID�� ������ 0, ������ 1 ��ȯ
	}
	
	
	// ��ȸ (�� ��) - read (select) ó��
	@Test
	public void testGet() {
		
		// �����ϴ� ȸ�� ��ȣ�� �׽�Ʈ
		log.info("��ȸ ���: "+ service.get("user10"));
	}
	
//	���� - delete ó��
	@Test
	public void testDelete() {
		
		// �����ϴ� ȸ�� ��ȣ�� �׽�Ʈ
		String member_id = "test1";
		log.info("���� DELETE ���: "+ service.remove(member_id));
	}
	
////	���� - update ó��
//	@Test
//	public void testUpdate() {
//		
//		// Ư���� ȸ���� ���� ��ȸ
//		MemberVO member = service.get("user12");
//
//		// �����ϴ� ȸ�� ��ȣ�� �׽�Ʈ
//		member.setMember_no(1L);
//		member.setMember_id("user12");
//		member.setMember_pass("1234");
//		member.setMember_name("ȫ�浿1");
//		member.setMember_gender("��");
//		member.setMember_birth(Date.valueOf("2010-12-25"));	// String�� Date�� ��ȯ
//		member.setMember_phone("010-1245-1231");
//		member.setMember_address("���ν�");
//		member.setMember_mail("12aaa@mp3.com");
//		member.setMember_mailaccept("yes");	
//		
//		log.info("���� UPDATE ���: "+ service.modify(member));
//		log.info(member);
//	}
}
