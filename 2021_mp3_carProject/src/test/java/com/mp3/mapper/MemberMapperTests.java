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

// 담당자: kim
@RunWith(SpringJUnit4ClassRunner.class)	// 현재 테스트 코드가 스프링을 실행하는 역할을 할 것
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemberMapperTests {
	
	@Autowired
	private MemberMapper mapper;
	
	// 회원 목록(리스트)
	@Test
	public void testGetList() {
		mapper.getList().forEach(member -> log.info(member));
	}
	
	// 회원 조회 - read (select) 처리
	@Test
	public void testRead() {
		
		// 존재하는 회원ID로 테스트
		MemberVO member = mapper.read("admin90"); 
		
		log.info("회원조회: "+member);
	}
	
	// 회원권한 조회 - read (select) 처리
	@Test
	public void testReadAuth() {
		
		// 존재하는 회원ID로 테스트
		AuthVO auth = mapper.readAuth("user2001"); 
		
		log.info("권한조회: "+auth);
		log.info("권한조회: "+auth.getMember_auth());
	}
	

    //아이디 중복체크
	@Test
	public void testCheckId() {
		
		// 존재하는 회원ID로 테스트
		MemberVO member = new MemberVO();
		member.setMember_id("admin90");

		log.info("아이디 중복체크 결과: "+mapper.checkId(member));
		// 중복ID가 없으면 0, 있으면 1 반환
	}
	
	
	
	// 회원 등록1 - insert 처리
	// 회원 등록2 - @SelectKey 사용 (자동으로 추가되는 PK 값 확인)
	@Test
	public void testInsert() {
		
		MemberVO member = new MemberVO();

		// 존재하는 회원 id와 중복되지 않게 테스트
		member.setMember_id("user2001");
		member.setMember_pass("1234");
		member.setMember_name("홍길동");
		member.setMember_gender("남");
		member.setMember_birth(Date.valueOf("2010-12-25"));	// String을 Date로 변환
		member.setMember_phone("010-1245-1231");
		member.setMember_address("용인시");
		member.setMember_mail("aaa123@mp3.com");
		member.setMember_mailaccept("yes");	
		
//		mapper.insert(member);
		mapper.insertSelectKey(member);
		
		log.info("회원가입 완료: "+member);
	}

	// 회원 권한 등록 - insert 처리
	@Test
	public void testInsertAuth() {
		
		AuthVO auth = new AuthVO();
		
		auth.setMember_id("user000011");
//		auth.setMember_auth("ROLE_USER");
		
		log.info(mapper.insertAuth(auth));
		log.info("회원권한 입력 완료: "+auth);
	}
	
	
	
	// 회원 삭제 - delete 처리
	@Test
	public void testDelete() {

		// 존재하는 회원 번호로 테스트
		log.info("삭제 테스트 DELETE COUNT: "+ mapper.delete(109L));
	}
	
	// 회원 수정 - update 처리
	@Test
	public void testUpdate() {
		
		MemberVO member = new MemberVO();
		
		// 존재하는 회원 번호로 테스트
		member.setMember_no(1L);
		member.setMember_id("user1111");
		member.setMember_pass("1234");
		member.setMember_name("홍길동");
		member.setMember_gender("남");
		member.setMember_birth(Date.valueOf("2010-12-25"));	// String을 Date로 변환
		member.setMember_phone("010-1245-1231");
		member.setMember_address("용인시");
		member.setMember_mail("12aaa@mp3.com");
		member.setMember_mailaccept("yes");	
		
		log.info("수정 테스트 UPDATE COUNT: "+ mapper.update(member));
		log.info(member);
	}
	

	// 준택 test
//	@Test
//	public void test1() {
//		
//		// 존재하는 회원번호로 테스트
//		MemberVO member = mapper.test("홍길동", "aaa123@mp3.com");
//		
//		log.info(member.getMember_id());
//	}
	

}
