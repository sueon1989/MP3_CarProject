package com.mp3.service;

import com.mp3.domain.CarVO;
import com.mp3.domain.MemberVO;

public interface MypageService {

	//���������� ȸ����ȣ�� ������ �󼼺���
	public MemberVO myInfoRead(Long member_no);
	
	//���������� �� ��ȣ�� �� �� ���� �� ����
	public CarVO myInfoCar(Long car_no);
	
	//���������� ȸ��Ż�� ��й�ȣ Ȯ��
	public boolean myInfoDeletePassCheck(Long member_no,String Deletenum,String Deletenum1);
	
	
	// ���������� �� ���� ����
	public boolean myInfoUpdatePassCheck(MemberVO member);
	
	
	//���������� ȸ�� Ż��
	public boolean myInfoDeleteFinished(Long member_no);
	
	//����ڰ� ȸ��Ż��� �Է��� ��й�ȣ ����
	public MemberVO DeleteNum(String deletenum);
	
    //Ż��� �н����� üũ
    public int passChk(MemberVO member);
    
    //Ż��� ���̵�� üũ
    public String passID(String member_id);
	
}




