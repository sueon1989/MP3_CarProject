package com.mp3.service;


import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mp3.domain.CarRegistrationVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)	// 현재 테스트 코드가 스프링을 실행하는 역할을 할 것
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class CarRegistrationServiceTest {
	
	@Autowired
	private CarRegistrationService service;
	
	
	@Test
	public void MycarlistTest() {		
		CarRegistrationVO carRegistration = service.Mycarlist("user10");
		log.info(carRegistration);
	}
	
	@Test
	public void	MycarTest() {
		CarRegistrationVO carRegistration = new CarRegistrationVO();
	
			carRegistration.setCar_company("쉐보레");
			carRegistration.setCar_model_year(Date.valueOf("2010-12-01"));
			carRegistration.setCar_model("스파크");
			carRegistration.setCar_fual("가솔린");
			carRegistration.setCar_engineoilrp("잘 모르겠어요");
			carRegistration.setCar_distancedriven(20000L);
			carRegistration.setMember_id("user10");
			
			service.Mycar(carRegistration);
			log.info(carRegistration);
	
	}
	@Test
	public void	Mycarupdatetest() {
		
		CarRegistrationVO carRegistration = new CarRegistrationVO();
		
		carRegistration.setCar_company("현대");
		carRegistration.setCar_model_year(Date.valueOf("2010-12-25"));
		carRegistration.setCar_model("벨로스터");
		carRegistration.setCar_fual("디젤");
		carRegistration.setCar_engineoilrp("최근 교체");
		carRegistration.setCar_distancedriven(20000L);
		carRegistration.setMember_id("user10");

		
		service.MycarUpdate(carRegistration);
	}
	
}
