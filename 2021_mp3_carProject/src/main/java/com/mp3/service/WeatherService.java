package com.mp3.service;

import java.util.List;

import com.mp3.domain.WeatherVO;

// 담당자: kim
public interface WeatherService {

//	public List<WeatherVO> getList();		// 날씨목록
	public WeatherVO get(String baseDate, String baseTime, String nx, String ny);	// 날씨조회
	
}
