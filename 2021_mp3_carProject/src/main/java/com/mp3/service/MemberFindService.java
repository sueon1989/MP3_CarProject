package com.mp3.service;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;

import com.mp3.domain.MemberVO;

public interface MemberFindService {
	//���̵� ã��(�̸���)
		public boolean MemverIDFindMail(MemberVO member);	
	
		//��й�ȣ ã��(�̸���)
		public boolean MemverPassFindMail(MemberVO member);
		// �̸��� ����
		public void send_mail(MemberVO member, String div);
		//�̸� üũ
		public boolean namecheck(MemberVO member);
	}
