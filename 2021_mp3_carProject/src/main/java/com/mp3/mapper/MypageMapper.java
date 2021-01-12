package com.mp3.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import com.mp3.domain.MemberVO;

import com.mp3.domain.MemberVO;

public interface MypageMapper {
	
	//@Select("select * from member where member_no>0")
    public List<MemberVO> getList();
    
    // �� ���� ����  (������Է� ȸ����ȣ ���)
    public MemberVO myInfoRead(Long member_no);
    
    
    // �� ���� ����
    public int myInfoUpdatePassCheck(MemberVO member);
    
    
    // �� ���� ���� ��� ȭ��
    
    
    //Ż�� �� ��й�ȣ Ȯ��
    public MemberVO myInfoDeletePassCheck(Long member_no);
    
    
    // Ż��	 (������Է� ȸ����ȣ ���)
    public int myInfoDelete_auth(Long member_no);
    public int myInfoDelete_member(Long member_no);
    
    
    //Ż��� �н����� üũ
    public int passChk(MemberVO member);
    
    
    //Ż��� ���̵�� üũ
    public String passID(String member_id);

}













