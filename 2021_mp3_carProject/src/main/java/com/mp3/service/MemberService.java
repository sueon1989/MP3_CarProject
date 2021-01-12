package com.mp3.service;

import java.util.List;

import com.mp3.domain.AuthVO;
import com.mp3.domain.MemberVO;

// �����: kim
public interface MemberService {

	public List<MemberVO> getList();				// ȸ����� (������)
	boolean register(MemberVO member, AuthVO auth);	// ȸ������
	public MemberVO get(String userid);				// �� ���� ��ȸ
	public boolean modify(MemberVO member);			// �� ���� ����
	public boolean remove(Long member_no);			// ȸ��Ż��
	
	public boolean checkId(MemberVO member);			// ���̵� �ߺ�üũ
	
}
