package com.mp3.mapper;

import java.sql.Date;

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
public class MemberMapperTests {
	
	@Autowired
	private MemberMapper mapper;
	
	// ȸ�� ���(����Ʈ)
	@Test
	public void testGetList() {
		mapper.getList().forEach(member -> log.info(member));
	}
	
	// ȸ�� ��ȸ - read (select) ó��
	@Test
	public void testRead() {
		
		// �����ϴ� ȸ��ID�� �׽�Ʈ
		MemberVO member = mapper.read("admin90"); 
		
		log.info("ȸ����ȸ: "+member);
	}
	
	// ȸ������ ��ȸ - read (select) ó��
	@Test
	public void testReadAuth() {
		
		// �����ϴ� ȸ��ID�� �׽�Ʈ
		AuthVO auth = mapper.readAuth("user2001"); 
		
		log.info("������ȸ: "+auth);
		log.info("������ȸ: "+auth.getMember_auth());
	}
	

    //���̵� �ߺ�üũ
	@Test
	public void testCheckId() {
		
		// �����ϴ� ȸ��ID�� �׽�Ʈ
		MemberVO member = new MemberVO();
		member.setMember_id("admin90");

		log.info("���̵� �ߺ�üũ ���: "+mapper.checkId(member));
		// �ߺ�ID�� ������ 0, ������ 1 ��ȯ
	}
	
	
	
	// ȸ�� ���1 - insert ó��
	// ȸ�� ���2 - @SelectKey ��� (�ڵ����� �߰��Ǵ� PK �� Ȯ��)
	@Test
	public void testInsert() {
		
		MemberVO member = new MemberVO();

		// �����ϴ� ȸ�� id�� �ߺ����� �ʰ� �׽�Ʈ
		member.setMember_id("user2001");
		member.setMember_pass("1234");
		member.setMember_name("ȫ�浿");
		member.setMember_gender("��");
		member.setMember_birth(Date.valueOf("2010-12-25"));	// String�� Date�� ��ȯ
		member.setMember_phone("010-1245-1231");
		member.setMember_address("���ν�");
		member.setMember_mail("aaa123@mp3.com");
		member.setMember_mailaccept("yes");	
		
//		mapper.insert(member);
		mapper.insertSelectKey(member);
		
		log.info("ȸ������ �Ϸ�: "+member);
	}

	// ȸ�� ���� ��� - insert ó��
	@Test
	public void testInsertAuth() {
		
		AuthVO auth = new AuthVO();
		
		auth.setMember_id("user000011");
//		auth.setMember_auth("ROLE_USER");
		
		log.info(mapper.insertAuth(auth));
		log.info("ȸ������ �Է� �Ϸ�: "+auth);
	}
	
	
	
	// ȸ�� ���� - delete ó��
	@Test
	public void testDelete() {

		// �����ϴ� ȸ�� ��ȣ�� �׽�Ʈ
		log.info("���� �׽�Ʈ DELETE COUNT: "+ mapper.delete(109L));
	}
	
	// ȸ�� ���� - update ó��
	@Test
	public void testUpdate() {
		
		MemberVO member = new MemberVO();
		
		// �����ϴ� ȸ�� ��ȣ�� �׽�Ʈ
		member.setMember_no(1L);
		member.setMember_id("user1111");
		member.setMember_pass("1234");
		member.setMember_name("ȫ�浿");
		member.setMember_gender("��");
		member.setMember_birth(Date.valueOf("2010-12-25"));	// String�� Date�� ��ȯ
		member.setMember_phone("010-1245-1231");
		member.setMember_address("���ν�");
		member.setMember_mail("12aaa@mp3.com");
		member.setMember_mailaccept("yes");	
		
		log.info("���� �׽�Ʈ UPDATE COUNT: "+ mapper.update(member));
		log.info(member);
	}
	

	// ���� test
//	@Test
//	public void test1() {
//		
//		// �����ϴ� ȸ����ȣ�� �׽�Ʈ
//		MemberVO member = mapper.test("ȫ�浿", "aaa123@mp3.com");
//		
//		log.info(member.getMember_id());
//	}
	

}
