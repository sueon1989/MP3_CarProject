package com.mp3.domain;

import java.sql.Date;

import lombok.Data;
@Data
public class Car_fixVO {
	
	private String repair;
	private String repairshop;
	private Date repair_date;
	private Long amount;
	private String member_id;

	
	
   
}
