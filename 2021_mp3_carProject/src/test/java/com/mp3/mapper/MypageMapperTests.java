package com.mp3.mapper;

import java.sql.Date;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mp3.domain.CarVO;
import com.mp3.domain.GpsVO;
import com.mp3.domain.MemberVO;

import com.mp3.domain.MemberVO;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)	// 현재 테스트 코드가 스프링을 실행하는 역할을 할 것
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MypageMapperTests {
	
	@Autowired
	private MypageMapper mapper;
	
	// 회원 목록(리스트)
	@Test
	public void testGetList() {
		mapper.getList().forEach(member -> log.info(member));
	}
	
	//내 정보 보기
	@Test
	public void myInfoRead() {
		MemberVO member= mapper.myInfoRead(292L);	// member_no 95번 정보 호출
		log.info(member);
		
		
	}
	
	//내 차 정보 보기
	@Test
	public void myInfoCar() {
		CarVO car= mapper.myInfoCar(2L);	// car_no 2번 정보 호출
		log.info(car);
				
	}
	
	//gps 저장하기 
	@Test
	public void gps() {
		mapper.gps("999","98899999");
		
				
	}
	
	
	
	
//	//탈퇴 비밀번호 확인
//	@Test
//	public void myInfoDeletePassCheck() {
//		MemberVO member= mapper.myInfoDeletePassCheck(1L);			
//		log.info(member);
//	}
//	
	// 탈퇴	 (회원번호 사용)
	@Test
	public void myInfoDelete() {
		mapper.myInfoDelete_auth(292L);
		mapper.myInfoDelete_member(292L);
		log.info(mapper.myInfoDelete_auth(292L));
		log.info(mapper.myInfoDelete_member(292L));
	
	}
		
	
	//회원정보 수정
		@Test
		public void myInfoDeletePassCheck() {
			MemberVO member = new MemberVO();			
			member.setMember_no(7L);
			member.setMember_id("1111");
			member.setMember_pass("1111");
			member.setMember_name("이재영");
			member.setMember_gender("여");
			member.setMember_birth(Date.valueOf("2017-12-30"));	
			member.setMember_phone("010-7777-7777");
			member.setMember_address("서울특별시");
			member.setMember_mail("123123123123@mp3.com");
			member.setMember_mailaccept("no");	
			mapper.myInfoUpdatePassCheck(member);
		}
		
		
		//회원탈퇴 비밀번호 체크
		@Test
		public void passChk() {
			MemberVO member = new MemberVO();
			member.setMember_id("user2021");
			member.setMember_pass("$2a$10$dZAzGOxPMPyxm7YRVDkS/eSL7HIIlWumniiDDJ/LS694jPHu6naKe");
			mapper.passChk(member);
			
		}
		
		
		@Test
	    //탈퇴시 아이디로 체크
	    public void passID() {
			MemberVO member= new MemberVO();
			member.setMember_id("user2021");
	    	mapper.passID("user2021");
			log.info(mapper.passID("user2021"));
	    }

		
		
	
	
	/*		@Test
public void testInsert() {
		MemberVO memberVO = new MemberVO();
		memberVO.setMember_id("jaeyoungTest11");
		memberVO.setMember_pass("Test");
		memberVO.setMember_name(" Test");
		memberVO.setMember_gender("남");
		memberVO.setMember_birth("2020-11-11");
		memberVO.setMember_phone("010-1111-5555");
		memberVO.setMember_address("회원가입 Test");
		memberVO.setMember_mail("회원가입@Test");
		memberVO.setMember_mailaccept("Test");
		mapper.insert(memberVO);		
		log.info(memberVO);		
	
	}*/
}

