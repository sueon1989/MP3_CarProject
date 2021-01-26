package com.mp3.service;

import java.util.List;

import com.mp3.domain.WeatherVO;

// 담당자: kim
public interface WeatherService {

//	public List<WeatherVO> getList();		// 날씨목록

	public WeatherVO getNowDate(WeatherVO weather);	// 현재날짜, 위치정보 
	public WeatherVO getNowLocation(WeatherVO weather);
	public WeatherVO getWeatherAPI(String serviceKey, String baseDate, String baseTime, int nx, int ny);	// 날씨API조회
	public boolean register(WeatherVO weather);				// 날씨DB등록
	public WeatherVO getWeatherInfo(WeatherVO weather);	// 날씨정보 표시
}
