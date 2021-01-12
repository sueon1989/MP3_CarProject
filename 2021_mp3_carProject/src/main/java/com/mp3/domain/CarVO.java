package com.mp3.domain;

import java.sql.Date;
import lombok.Data;

@Data
public class CarVO {
    private Long car_no;
    private String car_number;
    private String car_company;
	private String car_type; 
    private String car_model;
    private String car_fual;
    private String car_engineoilrp;
    private Long car_distancedriven;
    private Date car_regDate;
    private Date car_updateDate;
}
