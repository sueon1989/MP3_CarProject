package com.mp3.mapper;


import java.util.List;

import com.mp3.domain.Car_fixVO;
import com.mp3.domain.MemberVO;

public interface Car_fixMapper {
//	// 지출 내역 보기
//		public Car_fixVO Car_Spending(String member_id);
	// 정비/기타 목록 보기
	public Car_fixVO car_fixlist(String member_id);
	// 내 정비 등록	
		public int car_fix(Car_fixVO car_fix);

	// 내차량 정비 정보 수정하기
		public int car_fixUpdate(Car_fixVO car_fix);
}
