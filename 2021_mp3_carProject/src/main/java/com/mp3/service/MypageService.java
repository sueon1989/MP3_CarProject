package com.mp3.service;

import com.mp3.domain.MemberVO;

public interface MypageService {

	//���������� ȸ����ȣ�� ������ �󼼺���
	public MemberVO myInfoRead(Long member_no);
	
	//���������� ȸ��Ż�� ��й�ȣ Ȯ��
	public boolean myInfoDeletePassCheck(Long member_no);
	
	
	// ���������� �� ���� ����
	public boolean myInfoUpdate(MemberVO member);
	
	
//	//���������� ȸ�� Ż��
//	public boolean myInfoDeleteFinished(Long member_no);
//	
}
