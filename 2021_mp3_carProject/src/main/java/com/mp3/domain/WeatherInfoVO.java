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
	
	private String baseDate;	// 발표일자
	private String baseTime;	// 발표시각
	private String fcstDate;	// 예보일자
	private String fcstTime;	// 예보시각	(0200, 0500, 0800, 1100, 1400, 2000, 2300)
	private int nx;				// 예보지점 X 좌표
	private int ny;				// 예보지점 Y 좌표

	// category 자료구분코드별 fcstValue 예보값 저장
	private String pop;			// 강수확률	(%)
	private String pty;			// 강수형태
	private String r06;			// 6시간 강수량	(1 mm)
	private String reh;			// 습도		(%)
	private String s06;			// 6시간 신적설	(1 cm)
	private String sky;			// 하늘상태
	private String t3h;			// 3시간 기온		(℃)
	private String tmn;			// 아침 최저기온	(℃)
	private String tmx; 		// 낮 최고기온		(℃)
	private String uuu;			// 풍속(동서성분)	(m/s)
	private String vvv;			// 풍속(남북성분)	(m/s)
	private String wav; 	//파고	(M)
	private String vec;			// 풍향		(deg)
	private String wsd;			// 풍속		(m/s)
	
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








