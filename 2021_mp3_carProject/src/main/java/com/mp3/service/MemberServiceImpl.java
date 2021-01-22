package com.mp3.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import com.mp3.domain.AuthVO;
import com.mp3.domain.MemberVO;
import com.mp3.mapper.MemberMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {
	
//	@Autowired
//	단일 파라미터를 받는 생성자의 경우, 필요한 파라미터를 자동으로 주입
	private MemberMapper mapper;
	
	// 목록(리스트)
	@Override
	public List<MemberVO> getList() {
		
		log.info("목록(리스트)......");
		return mapper.getList();
	}

	// 아이디 중복체크
	@Override
	public boolean checkId(MemberVO member) {
		
		boolean checkId = mapper.checkId(member) == 1;
		return checkId;
	}

	// 등록 - insert 처리 (SelectKey 사용)
	@Override
	public boolean register(MemberVO member, AuthVO auth) {
		log.info("회원등록......"+member);
		
		boolean register_member = mapper.insertSelectKey(member) == 1;
		boolean register_auth = mapper.insertAuth(auth) == 1;
		
		if (register_member == true && register_auth == true) {
			return true;
		} else {
			return false;
		}
	}

	// 조회 (한 행) - read (select) 처리
	@Override
	public MemberVO get(String userid) {
		
		log.info("조회......"+userid);
		return mapper.read(userid);
	}

		
	
	
	// 수정 - update 처리
	@Override
	public boolean modify(MemberVO member) {
		log.info("수정예정......"+member);
		return mapper.update(member) == 1;	}

	// 삭제 - delete 처리
	@Override
	public boolean remove(String member_id) {
		log.info("삭제......"+member_id);
		
		
		boolean deleteAuth = mapper.deleteAuth(member_id) == 1;
		boolean deleteMember = mapper.deleteMember(member_id) == 1;
		
		if (deleteAuth == true && deleteMember == true) {
			return true;
		} else {
			return false;
		}
	}

}
