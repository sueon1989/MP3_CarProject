package com.mp3.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mp3.domain.AuthVO;
import com.mp3.domain.MemberVO;
import com.mp3.domain.WeatherLocationVO;
import com.mp3.domain.WeatherVO;

public interface WeatherMapper {

//	// 날씨DB 목록 보기
//	public List<WeatherVO> getList();
	
//	public WeatherVO read(String baseDate, String baseTime, int nx, int ny);
//	public WeatherVO read(Long weather_no);

	// 날씨 정보 DB등록
	public int insertSelectKey(WeatherVO weather);
	
	// 위치 조회 (한 행) - read (select) 처리
    public String readGpsAdd();
    
	// 위치 조회 (한 행) - read (select) 처리
    public WeatherLocationVO readLocation(@Param("lo1st") String lo1st, @Param("lo2nd") String lo2nd, @Param("lo3rd") String lo3rd);
    
    
	
}
