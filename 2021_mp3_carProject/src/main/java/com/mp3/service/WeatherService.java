package com.mp3.service;

import java.util.List;

import com.mp3.domain.WeatherLocationVO;
import com.mp3.domain.WeatherVO;

// �����: kim
public interface WeatherService {

//	public List<WeatherVO> getList();		// �������

	public WeatherVO getNowDate();							// ���糯¥
	public String getGpsAdd();								// GPS �ּ�����
	public WeatherLocationVO getNowLocation(String gpsAdd);	// ������ġ
	
//	public WeatherVO getWeatherAPI(String serviceKey, String baseDate, String baseTime, int nx, int ny);	
	public WeatherVO getWeatherAPI(String serviceKey, WeatherVO weather);	// ����API��ȸ
	
	public boolean register(WeatherVO weather);				// ����DB���
	public WeatherVO getWeatherInfo(WeatherVO weather);		// �������� ǥ��
	
}
