package com.mp3.service;

import org.apache.ibatis.annotations.Param;

import com.mp3.domain.MemberVO;

public interface MemberFindService {
	//���̵� ã��(�̸���)
		public MemberVO MemverIDFindMail(MemberVO member);	
	
		//��й�ȣ ã��(�̸���)
		public MemberVO MemverPassFindMail(MemberVO member);
		// �̸��� ����
		
		public void send_mail(MemberVO member, String div);
	}
