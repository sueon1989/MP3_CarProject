package com.mp3.service;


import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mp3.domain.CarRegistrationVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)	// ���� �׽�Ʈ �ڵ尡 �������� �����ϴ� ������ �� ��
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
	
			carRegistration.setCar_company("������");
			carRegistration.setCar_model_year(Date.valueOf("2010-12-01"));
			carRegistration.setCar_model("����ũ");
			carRegistration.setCar_fual("���ָ�");
			carRegistration.setCar_engineoilrp("�� �𸣰ھ��");
			carRegistration.setCar_distancedriven(20000L);
			carRegistration.setMember_id("user10");
			
			service.Mycar(carRegistration);
			log.info(carRegistration);
	
	}
	@Test
	public void	Mycarupdatetest() {
		
		CarRegistrationVO carRegistration = new CarRegistrationVO();
		
		carRegistration.setCar_company("����");
		carRegistration.setCar_model_year(Date.valueOf("2010-12-25"));
		carRegistration.setCar_model("���ν���");
		carRegistration.setCar_fual("����");
		carRegistration.setCar_engineoilrp("�ֱ� ��ü");
		carRegistration.setCar_distancedriven(20000L);
		carRegistration.setMember_id("user10");

		
		service.MycarUpdate(carRegistration);
	}
	
}
