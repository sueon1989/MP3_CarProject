package com.mp3.service;

import java.util.List;

import com.mp3.domain.AuthVO;
import com.mp3.domain.MemberVO;

// �����: kim
public interface MemberService {

	public List<MemberVO> getList();				// ȸ����� (������)
	boolean register(MemberVO member, AuthVO auth);	// ȸ������
	public MemberVO get(String userid);				// ȸ������ ��ȸ
	public boolean remove(String member_id);		// ȸ��Ż��
	
	public boolean modify(MemberVO member);			// �� ���� ����
	
	public boolean checkId(MemberVO member);			// ���̵� �ߺ�üũ
	
}
