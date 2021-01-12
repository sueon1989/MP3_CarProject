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
//	���� �Ķ���͸� �޴� �������� ���, �ʿ��� �Ķ���͸� �ڵ����� ����
	private MemberMapper mapper;
	
	// ���(����Ʈ)
	@Override
	public List<MemberVO> getList() {
		
		log.info("���(����Ʈ)......");
		return mapper.getList();
	}

	// ���̵� �ߺ�üũ
	@Override
	public boolean checkId(MemberVO member) {
		
		boolean checkId = mapper.checkId(member) == 1;
		return checkId;
	}

	// ��� - insert ó�� (SelectKey ���)
	@Override
	public boolean register(MemberVO member, AuthVO auth) {
		log.info("ȸ�����......"+member);
		
		boolean register_member = mapper.insertSelectKey(member) == 1;
		boolean register_auth = mapper.insertAuth(auth) == 1;
		
		if (register_member == true && register_auth == true) {
			return true;
		} else {
			return false;
		}
	}

	// ��ȸ (�� ��) - read (select) ó��
	@Override
	public MemberVO get(String userid) {
		
		log.info("��ȸ......"+userid);
		return mapper.read(userid);
	}

		
	
	
	// ���� - update ó��
	@Override
	public boolean modify(MemberVO member) {
		log.info("��������......"+member);
		return mapper.update(member) == 1;	}

	// ���� - delete ó��
	@Override
	public boolean remove(Long member_no) {
		log.info("����......"+member_no);
		return mapper.delete(member_no) == 1;
	}

}
