package com.mp3.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class CarRegistrationVO {
	private Long car_no; // 등록 번호
	private String car_company; // 제조사
	private Date car_model_year; // 연식
	private String car_model; // 모델명
	private String car_fual; // 연료
	private String car_engineoilrp;//엔진오일 교환 시기
	private Long car_distancedriven; // 차량 주행거리
    private Date car_regDate; // 자동차 등록 날짜.
    private Date car_updateDate;
    private String member_id;
}
