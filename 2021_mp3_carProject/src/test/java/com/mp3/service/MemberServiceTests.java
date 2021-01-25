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

// 담당자: kim
@RunWith(SpringJUnit4ClassRunner.class)	// 현재 테스트 코드가 스프링을 실행하는 역할을 할 것
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemberServiceTests {
	
	@Autowired
	private MemberService service;
	
	@Test
	public void testExist() {
		
		// MemberService 객체가 제대로 주입이 가능한지 확인
		log.info("서비스 "+service);
		assertNotNull(service);
	}

	// 목록(리스트)
	@Test
	public void testGetList() {
		
		List<MemberVO> memberList = service.getList();
		for(MemberVO member: memberList) {
			log.info(member);
		}
		
		// 람다식으로 표현 (교재 방법)
		// service.getList().forEach(member -> log.info(member));
	}
	
	// 회원가입 - insert 처리 (SelectKey 사용)
	@Test
	public void testRegister() {
		
		MemberVO member = new MemberVO();
		member.setMember_id("user2003");	// 존재하는 회원 id와 중복되지 않게 테스트
		member.setMember_pass("1234");
		member.setMember_name("홍길동");
		member.setMember_gender("남");
		member.setMember_birth(Date.valueOf("2010-12-25"));	// String을 Date로 변환
		member.setMember_phone("010-1245-1231");
		member.setMember_address("용인시");
		member.setMember_mail("aaa123@mp3.com");
		member.setMember_mailaccept("yes");	
		
		AuthVO auth = new AuthVO();
		auth.setMember_id("user2003");
		auth.setMember_auth("ROLE_USER");
		
		service.register(member, auth);
		
		log.info("생성된 회원번호: "+member.getMember_no());
		log.info("생성된 회원정보: "+member);
		log.info("생성된 회원권한: "+auth);
	}
	
    //아이디 중복체크
	@Test
	public void testCheckId() {
		
		// 존재하는 회원ID로 테스트
		MemberVO member = new MemberVO();
		member.setMember_id("admin90");

		log.info("아이디 중복체크 결과: "+service.checkId(member));
		// 중복ID가 없으면 0, 있으면 1 반환
	}
	
	
	// 조회 (한 행) - read (select) 처리
	@Test
	public void testGet() {
		
		// 존재하는 회원 번호로 테스트
		log.info("조회 결과: "+ service.get("user10"));
	}
	
//	삭제 - delete 처리
	@Test
	public void testDelete() {
		
		// 존재하는 회원 번호로 테스트
		String member_id = "test1";
		log.info("삭제 DELETE 결과: "+ service.remove(member_id));
	}
	
////	수정 - update 처리
//	@Test
//	public void testUpdate() {
//		
//		// 특정한 회원을 먼저 조회
//		MemberVO member = service.get("user12");
//
//		// 존재하는 회원 번호로 테스트
//		member.setMember_no(1L);
//		member.setMember_id("user12");
//		member.setMember_pass("1234");
//		member.setMember_name("홍길동1");
//		member.setMember_gender("남");
//		member.setMember_birth(Date.valueOf("2010-12-25"));	// String을 Date로 변환
//		member.setMember_phone("010-1245-1231");
//		member.setMember_address("용인시");
//		member.setMember_mail("12aaa@mp3.com");
//		member.setMember_mailaccept("yes");	
//		
//		log.info("수정 UPDATE 결과: "+ service.modify(member));
//		log.info(member);
//	}
}
