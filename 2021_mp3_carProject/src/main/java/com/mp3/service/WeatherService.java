package com.mp3.service;

import java.util.List;

import com.mp3.domain.WeatherVO;

// �����: kim
public interface WeatherService {

//	public List<WeatherVO> getList();		// �������

	public WeatherVO getNowDate(WeatherVO weather);	// ���糯¥, ��ġ���� 
	public WeatherVO getNowLocation(WeatherVO weather);
	public WeatherVO getWeatherAPI(String serviceKey, String baseDate, String baseTime, int nx, int ny);	// ����API��ȸ
	public boolean register(WeatherVO weather);				// ����DB���
	public WeatherVO getWeatherInfo(WeatherVO weather);	// �������� ǥ��
}
