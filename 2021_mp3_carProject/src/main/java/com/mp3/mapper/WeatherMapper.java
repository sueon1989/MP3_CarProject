package com.mp3.mapper;

import java.util.List;

import com.mp3.domain.AuthVO;
import com.mp3.domain.MemberVO;
import com.mp3.domain.WeatherVO;

public interface WeatherMapper {

//	// ����DB ��� ����
//	public List<WeatherVO> getList();
	
//	public WeatherVO read(String baseDate, String baseTime, int nx, int ny);
//	public WeatherVO read(Long weather_no);

	// ���� ���� DB���
	public int insertSelectKey(WeatherVO weather);
	
//	// ȸ�� ���
//	//@Select("select * from member where member_no>0")
//    public List<MemberVO> getList();
//    
//    // ȸ�� ��ȸ (�� ��) - read (select) ó��
//    // MemberVO, AuthVO �ѹ��� ó��
//    public MemberVO read(String userid);
//
//	//ȸ�� ��ȸ (�� ��) - read (select) ó��
////  public MemberVO read(Long member_no);	// ��ü Ÿ������ �־��־�� �� (long�� �ƴ� Long)
//    public MemberVO readMember(Long member_no);
//    
//	//ȸ�� ���� ��ȸ (�� ��) - read (select) ó��
////	public AuthVO readAuth(Long member_no);
//	public AuthVO readAuth(String userid);
//	
//	// ȸ�� ���2 - @SelectKey ��� (�ڵ����� �߰��Ǵ� PK �� Ȯ��)
//	public int insertSelectKey(MemberVO member);

}
