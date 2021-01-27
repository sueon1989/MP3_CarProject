package com.mp3.service;

import com.mp3.domain.Car_fixVO;

public interface Car_fixService  {
	
//	public Car_fixVO car_fixlist(String member_id);
	
	public boolean car_fix(Car_fixVO car_fix);
	
	public boolean car_fixUpdate(Car_fixVO car_fix);

}
