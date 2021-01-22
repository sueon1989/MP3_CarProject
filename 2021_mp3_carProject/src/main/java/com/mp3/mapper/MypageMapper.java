package com.mp3.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

//import com.mp3.domain.CarVO;
import com.mp3.domain.GpsVO;
import com.mp3.domain.MemberVO;

import com.mp3.domain.MemberVO;

public interface MypageMapper {
	
	//@Select("select * from member where member_no>0")
    public List<MemberVO> getList();
    
    // 내 정보 보기 
    public MemberVO myInfoRead(Long member_no);
    
    //내 차량 정보 보기 
//    public CarVO myInfoCar(Long car_no);
    
    
    // 내 정보 수정
    public int myInfoUpdatePassCheck(MemberVO member);
    
    
    // 내 정보 수정 결과 화면
    
    
    //탈퇴 시 비밀번호 확인
    public MemberVO myInfoDeletePassCheck(Long member_no);
    
    
    // 탈퇴	 (사용자입력 회원번호 사용)
    public int myInfoDelete_auth(Long member_no);
    public int myInfoDelete_member(Long member_no);
    
    
    //탈퇴시 패스워드 체크
    public int passChk(MemberVO member);
    
    
    //탈퇴시 아이디로 체크
    public String passID(String member_id);
    
    
    //gps 값 데이터베이스 저장
    public void gps(@Param("Latitude") String Latitude,@Param("Longitude") String Longitude);
    
    //최근 gps값 보기
    public GpsVO mapView();
    
    //gpsadd 값 저장
    public GpsVO gpsadd(@Param("gpsadd") String gpsadd);
    
    

}













