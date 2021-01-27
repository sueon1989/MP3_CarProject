package com.mp3.service;

import org.springframework.stereotype.Service;

import com.mp3.domain.Car_fixVO;
import com.mp3.mapper.CarRegistrationMapper;
import com.mp3.mapper.Car_fixMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class Car_fixServiceImpl implements Car_fixService {
	private Car_fixMapper mapper;
	@Override
	
	public boolean car_fix(Car_fixVO car_fix) {
		boolean fix = mapper.car_fix(car_fix) == 1;
		if(fix == true) {
			return true;
		}else
			return false;
	}
	

	@Override
	public boolean car_fixUpdate(Car_fixVO car_fix) {
		return mapper.car_fixUpdate(car_fix) == 1;
	
	}


//	@Override
//	public Car_fixVO car_fixlist(String member_id) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
