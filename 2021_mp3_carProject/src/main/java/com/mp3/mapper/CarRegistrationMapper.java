package com.mp3.mapper;




import com.mp3.domain.CarRegistrationVO;

public interface CarRegistrationMapper {
	//내 차량 정보 보기
	public CarRegistrationVO Mycarlist(String member_id);
	
	// 내 차량 등록	
	public int Mycar(CarRegistrationVO carRegistration);

	//내차량 정보 수정하기
	public int MycarUpdate(CarRegistrationVO carRegistration);
	
}
