package com.mp3.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import com.mp3.domain.MemberVO;

import com.mp3.domain.MemberVO;

public interface MypageMapper {
	
	//@Select("select * from member where member_no>0")
    public List<MemberVO> getList();
    
    // 내 정보 보기  (사용자입력 회원번호 사용)
    public MemberVO myInfoRead(Long member_no);
    
    
    // 내 정보 수정
    public int myInfoUpdate(MemberVO member);
    
    
    // 내 정보 수정 결과 화면
    
    
//    //탈퇴 시 비밀번호 확인
//    public MemberVO myInfoDeletePassCheck(Long member_no);
//    
    
    // 탈퇴	 (사용자입력 회원번호 사용)
    public int myInfoDelete_auth(Long member_no);
    public int myInfoDelete_member(Long member_no);

}
