package com.mp3.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class GpsVO {
	
    private String Latitude;
    private String Longitude;
    private String GpsNo;
    private String gpsadd;
    private Date Time;
    private String StartNum;

}
