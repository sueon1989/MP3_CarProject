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

	// �� ���� ���� Service
	@Override
	public MemberVO myInfoRead(Long member_no) {

		MemberVO memberVO = mapper.myInfoRead(member_no);
		log.info("���������� ������ �󼼺���");
		return memberVO;
	}

	// �� ���� Ż�� Service
	@Override
	public boolean myInfoDeletePassCheck(Long member_no) {
		MemberVO member = new MemberVO();
		log.info(member_no + "ȸ�� Ż��");
		member.setMember_no(3L);
		log.info("��� �ѹ� "+member_no);
		boolean myInfoDelete_auth = mapper.myInfoDelete_auth(member_no) == 1;
		boolean myInfoDelete_member = mapper.myInfoDelete_member(member_no) == 1;
		if (myInfoDelete_auth == true && myInfoDelete_member == true) {
			return true;
		} else {
			return false;
		}
	}

	
	// ���������� �� ���� ����
	@Override
	public boolean myInfoUpdate(MemberVO member) {
		mapper.myInfoUpdate(member);
		log.info("���������� �� ���� ����"+member);
		return mapper.myInfoUpdate(member) == 1;	
		
	}

	
	
	
//	// �� ���� Ż��� ��й�ȣ Ȯ��
//	@Override
//	public boolean myInfoDeleteFinished(Long member_no) {
//		MemberVO member = new MemberVO();
//		if (member.getMember_pass_user().equals(member.getMember_pass())) {
//			log.info("���� ȭ�� : ��й�ȣ Ȯ�� ���� !!");
//			return true;
//		} else {
//			log.info("���� ȭ�� : ��й�ȣ Ȯ�� ���� !!");
//			return false;
//		}
//
//	}

}
