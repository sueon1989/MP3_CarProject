package com.mp3.domain;

import java.sql.Date;
//import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class WeatherInfoVO {
	
	private Long weather_no;
	
	////// response //////
	//// header ////
	private String resultCode;
	private String resultMsg;
	
	//// body ////
	private String dataType;
	
	private String baseDate;	// ��ǥ����
	private String baseTime;	// ��ǥ�ð�
	private String fcstDate;	// ��������
	private String fcstTime;	// �����ð�	(0200, 0500, 0800, 1100, 1400, 2000, 2300)
	private int nx;				// �������� X ��ǥ
	private int ny;				// �������� Y ��ǥ

	// category �ڷᱸ���ڵ庰 fcstValue ������ ����
	private String pop;			// ����Ȯ��	(%)
	private String pty;			// ��������
	private String r06;			// 6�ð� ������	(1 mm)
	private String reh;			// ����		(%)
	private String s06;			// 6�ð� ������	(1 cm)
	private String sky;			// �ϴû���
	private String t3h;			// 3�ð� ���		(��)
	private String tmn;			// ��ħ �������	(��)
	private String tmx; 		// �� �ְ���		(��)
	private String uuu;			// ǳ��(��������)	(m/s)
	private String vvv;			// ǳ��(���ϼ���)	(m/s)
	private String wav; 	//�İ�	(M)
	private String vec;			// ǳ��		(deg)
	private String wsd;			// ǳ��		(m/s)
	
	public WeatherInfoVO() {
		this.pop = "";
		this.pty = "";
		this.r06 = "";
		this.reh = "";
		this.s06 = "";
		this.sky = "";
		this.t3h = "";
		this.tmn = "";
		this.tmx = "";
		this.uuu = "";
		this.vvv = "";
		this.wav = "";
		this.vec = "";
		this.wsd = "";
	}
	
	
}








