package com.mp3.service;

import org.springframework.stereotype.Service;

import com.mp3.domain.CarRegistrationVO;
import com.mp3.domain.MemberVO;
import com.mp3.mapper.CarRegistrationMapper;
import com.mp3.mapper.MemberMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class CarRegistrationServiceImpl implements CarRegistrationService {

	private  CarRegistrationMapper mapper;
	
	// 회원정보 보기
	@Override
	public CarRegistrationVO Mycarlist(String member_id) {
		CarRegistrationVO carRegistration = mapper.Mycarlist(member_id);
		
		return carRegistration;
	}

	// 내차 등록하기
	@Override
	public boolean Mycar(CarRegistrationVO carRegistration) {
		boolean Mycar = mapper.Mycar(carRegistration) == 1;
		if(Mycar == true) {
			return true;
		}else
			return false;
	}
	
	// 내차 정보 수정하기
	@Override
	public boolean MycarUpdate(CarRegistrationVO carRegistration) {
		
		return mapper.MycarUpdate(carRegistration)==1;
	}

}
