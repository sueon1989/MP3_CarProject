package com.mp3.service;

import java.util.List;

import com.mp3.domain.WeatherLocationVO;
import com.mp3.domain.WeatherVO;

// 담당자: kim
public interface WeatherService {

//	public List<WeatherVO> getList();		// 날씨목록

	public WeatherVO getNowDate();							// 현재날짜
	public String getGpsAdd();								// GPS 주소정보
	public WeatherLocationVO getNowLocation(String gpsAdd);	// 현재위치
	
//	public WeatherVO getWeatherAPI(String serviceKey, String baseDate, String baseTime, int nx, int ny);	
	public WeatherVO getWeatherAPI(String serviceKey, WeatherVO weather);	// 날씨API조회
	
	public boolean register(WeatherVO weather);				// 날씨DB등록
	public WeatherVO getWeatherInfo(WeatherVO weather);		// 날씨정보 표시
	
}
