package com.mp3.domain;

import java.sql.Date;
//import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class WeatherVO {
	// response
	
	// header
	private String resultCode;
	private String resultMsg;
	
	// body
	private String dataType;
	
	private String baseDate;	// ��ǥ����
	private String baseTime;	// ��ǥ�ð�
	private String fcstDate;	// ��������
	private String fcstTime;	// �����ð�	
	private int nx;				// �������� X ��ǥ
	private int ny;				// �������� Y ��ǥ

	// �Ʒ� �׸�
//	private String category;	// �ڷᱸ���ڵ� (pop, pty ��)
//	private String fcstValue;	// ���� ��
	private String pop;
	private String pty;
	private String r06;
	private String reh;
	private String s06;
	private String sky;
	private String t3h;
	private String tmn;
	private String tmx; //
	private String uuu;
	private String vvv;
	private String wav; //
	private String vec;
	private String wsd;
}








