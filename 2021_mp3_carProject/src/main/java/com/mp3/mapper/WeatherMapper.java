package com.mp3.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mp3.domain.AuthVO;
import com.mp3.domain.MemberVO;
import com.mp3.domain.WeatherLocationVO;
import com.mp3.domain.WeatherVO;

public interface WeatherMapper {

//	// ����DB ��� ����
//	public List<WeatherVO> getList();
	
//	public WeatherVO read(String baseDate, String baseTime, int nx, int ny);
//	public WeatherVO read(Long weather_no);

	// ���� ���� DB���
	public int insertSelectKey(WeatherVO weather);
	
	// ��ġ ��ȸ (�� ��) - read (select) ó��
    public String readGpsAdd();
    
	// ��ġ ��ȸ (�� ��) - read (select) ó��
    public WeatherLocationVO readLocation(@Param("lo1st") String lo1st, @Param("lo2nd") String lo2nd, @Param("lo3rd") String lo3rd);
    
    
	
}
