package com.mp3.service;

import com.mp3.domain.CarRegistrationVO;
import com.mp3.domain.MemberVO;

public interface CarRegistrationService {
	
	//�� ���� ���� ����
		public CarRegistrationVO Mycarlist(String member_id);
		
		// �� ���� ���	
		public boolean Mycar(CarRegistrationVO carRegistration);

		//������ ���� �����ϱ�
		public boolean MycarUpdate(CarRegistrationVO carRegistration);
		
}
