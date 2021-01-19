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
	
	private String baseDate;	// 발표일자
	private String baseTime;	// 발표시각
	private String fcstDate;	// 예보일자
	private String fcstTime;	// 예보시각	
	private int nx;				// 예보지점 X 좌표
	private int ny;				// 예보지점 Y 좌표

	// 아래 항목
//	private String category;	// 자료구분코드 (pop, pty 등)
//	private String fcstValue;	// 예보 값
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








