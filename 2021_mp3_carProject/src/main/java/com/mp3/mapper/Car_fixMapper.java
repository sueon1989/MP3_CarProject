package com.mp3.mapper;


import java.util.List;

import com.mp3.domain.Car_fixVO;
import com.mp3.domain.MemberVO;

public interface Car_fixMapper {
//	// ���� ���� ����
//		public Car_fixVO Car_Spending(String member_id);
	// ����/��Ÿ ��� ����
	public Car_fixVO car_fixlist(String member_id);
	// �� ���� ���	
		public int car_fix(Car_fixVO car_fix);

	// ������ ���� ���� �����ϱ�
		public int car_fixUpdate(Car_fixVO car_fix);
}
