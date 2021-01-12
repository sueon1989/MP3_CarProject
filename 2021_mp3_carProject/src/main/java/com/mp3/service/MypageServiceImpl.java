package com.mp3.service;

import org.springframework.stereotype.Service;
import com.mp3.mapper.MypageMapper;
import com.mp3.service.MypageServiceImpl;

import com.mp3.domain.MemberVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class MypageServiceImpl implements MypageService {

	private MypageMapper mapper;

	// 내 정보 보기 Service
	@Override
	public MemberVO myInfoRead(Long member_no) {

		MemberVO memberVO = mapper.myInfoRead(member_no);
		log.info("마이페이지 내정보 상세보기");
		return memberVO;
	}

	// 내 정보 탈퇴 Service
	@Override
	public boolean myInfoDeletePassCheck(Long member_no) {
		MemberVO member = new MemberVO();
		log.info(member_no + "회원 탈퇴");
		member.setMember_no(3L);
		log.info("멤버 넘버 "+member_no);
		boolean myInfoDelete_auth = mapper.myInfoDelete_auth(member_no) == 1;
		boolean myInfoDelete_member = mapper.myInfoDelete_member(member_no) == 1;
		if (myInfoDelete_auth == true && myInfoDelete_member == true) {
			return true;
		} else {
			return false;
		}
	}

	
	// 마이페이지 내 정보 수정
	@Override
	public boolean myInfoUpdate(MemberVO member) {
		mapper.myInfoUpdate(member);
		log.info("마이페이지 내 정보 수정"+member);
		return mapper.myInfoUpdate(member) == 1;	
		
	}

	
	
	
//	// 내 정보 탈퇴시 비밀번호 확인
//	@Override
//	public boolean myInfoDeleteFinished(Long member_no) {
//		MemberVO member = new MemberVO();
//		if (member.getMember_pass_user().equals(member.getMember_pass())) {
//			log.info("서비스 화면 : 비밀번호 확인 성공 !!");
//			return true;
//		} else {
//			log.info("서비스 화면 : 비밀번호 확인 실패 !!");
//			return false;
//		}
//
//	}

}
