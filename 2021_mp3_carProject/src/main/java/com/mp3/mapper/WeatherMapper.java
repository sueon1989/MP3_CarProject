package com.mp3.mapper;

import java.util.List;

import com.mp3.domain.AuthVO;
import com.mp3.domain.MemberVO;
import com.mp3.domain.WeatherVO;

public interface WeatherMapper {

//	// 날씨DB 목록 보기
//	public List<WeatherVO> getList();
	
//	public WeatherVO read(String baseDate, String baseTime, int nx, int ny);
//	public WeatherVO read(Long weather_no);

	// 날씨 정보 DB등록
	public int insertSelectKey(WeatherVO weather);
	
//	// 회원 목록
//	//@Select("select * from member where member_no>0")
//    public List<MemberVO> getList();
//    
//    // 회원 조회 (한 행) - read (select) 처리
//    // MemberVO, AuthVO 한번에 처리
//    public MemberVO read(String userid);
//
//	//회원 조회 (한 행) - read (select) 처리
////  public MemberVO read(Long member_no);	// 객체 타입으로 넣어주어야 함 (long이 아닌 Long)
//    public MemberVO readMember(Long member_no);
//    
//	//회원 권한 조회 (한 행) - read (select) 처리
////	public AuthVO readAuth(Long member_no);
//	public AuthVO readAuth(String userid);
//	
//	// 회원 등록2 - @SelectKey 사용 (자동으로 추가되는 PK 값 확인)
//	public int insertSelectKey(MemberVO member);

}
