package com.mp3.mapper;


import org.apache.ibatis.annotations.Param;

import com.mp3.domain.CarRegistrationVO;

public interface CarRegistrationMapper {
	//�� ���� ���� ����
	public CarRegistrationVO Mycarlist(String member_id);
	
	// �� ���� ���	
	public int Mycar(CarRegistrationVO carRegistration);

	//������ ���� �����ϱ�
	public int MycarUpdate(CarRegistrationVO carRegistration);
	
}
