package com.mp3.mapper;


import com.mp3.domain.Car_fixVO;

public interface Car_fixMapper {
//	// ���� ���� ����
//		public Car_fixVO Car_Spending(String member_id);
//	// ����/��Ÿ ��� ����
//		public Car_fixVO Car_fixlist(String member_id);
	// �� ���� ���	
		public int car_fix(Car_fixVO car_fix);

	// ������ ���� ���� �����ϱ�
		public int car_fixUpdate(Car_fixVO car_fix);
}
