package com.mp3.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class CarRegistrationVO {
	private Long car_no; // ��� ��ȣ
	private String car_company; // ������
	private Date car_model_year; // ����
	private String car_model; // �𵨸�
	private String car_fual; // ����
	private String car_engineoilrp;//�������� ��ȯ �ñ�
	private Long car_distancedriven; // ���� ����Ÿ�
    private Date car_regDate; // �ڵ��� ��� ��¥.
    private Date car_updateDate;
    private String member_id;
}
