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
	
	// ȸ������ ����
	@Override
	public CarRegistrationVO Mycarlist(String member_id) {
		CarRegistrationVO carRegistration = mapper.Mycarlist(member_id);
		
		return carRegistration;
	}

	// ���� ����ϱ�
	@Override
	public boolean Mycar(CarRegistrationVO carRegistration) {
		boolean Mycar = mapper.Mycar(carRegistration) == 1;
		if(Mycar == true) {
			return true;
		}else
			return false;
	}
	
	// ���� ���� �����ϱ�
	@Override
	public boolean MycarUpdate(CarRegistrationVO carRegistration) {
		
		return mapper.MycarUpdate(carRegistration)==1;
	}

}
