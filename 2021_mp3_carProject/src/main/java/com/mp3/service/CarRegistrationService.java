package com.mp3.service;

import org.apache.ibatis.annotations.Param;

import com.mp3.domain.CarRegistrationVO;
import com.mp3.domain.MemberVO;

public interface CarRegistrationService {
	
	//내 차량 정보 보기
		public CarRegistrationVO Mycarlist(String member_id);
		
		// 내 차량 등록	
		public boolean Mycar(CarRegistrationVO carRegistration);

		//내차량 정보 수정하기
		public boolean MycarUpdate(CarRegistrationVO carRegistration);
		
}
