package com.mp3.mapper;

import org.apache.ibatis.annotations.Param;

import com.mp3.domain.MemberVO;

public interface MemberFindMapper {
	
	//���̵� ã��(�̸���)
	public MemberVO MemverIDFindMail(MemberVO member);					

	//��й�ȣ ã��(�̸���)
	public int MemverPassFindMail(MemberVO member);
	
	//�̸� �ߺ�üũ
	public int namecheck(MemberVO member);
	

	

}
