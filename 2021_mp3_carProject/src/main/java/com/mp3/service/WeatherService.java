package com.mp3.service;

import java.util.List;

import com.mp3.domain.WeatherVO;

// �����: kim
public interface WeatherService {

//	public List<WeatherVO> getList();		// �������
	public WeatherVO get(String baseDate, String baseTime, String nx, String ny);	// ������ȸ
	
}
