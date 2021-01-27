package com.mp3.mapper;

import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mp3.domain.CarRegistrationVO;
import com.mp3.domain.MemberVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)	// ���� �׽�Ʈ �ڵ尡 �������� �����ϴ� ������ �� ��
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class CarRegistrationMapperTests {

	@Autowired
	private  CarRegistrationMapper mapper;
	
	@Test
	public void	Mycartest() {
		
	CarRegistrationVO carRegistration = new CarRegistrationVO();
	
	carRegistration.setCar_company("������");
	carRegistration.setCar_model_year(Date.valueOf("2010-12-01"));
	carRegistration.setCar_model("����ũ");
	carRegistration.setCar_fual("���ָ�");
	carRegistration.setCar_engineoilrp("�� �𸣰ھ��");
	carRegistration.setCar_distancedriven(20000L);
	carRegistration.setMember_id("user10");
	
	mapper.Mycar(carRegistration);
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

		
		mapper.MycarUpdate(carRegistration);
	}
	
	@Test
	public void	MycarlistTest() {
		CarRegistrationVO carRegistration = mapper.Mycarlist("user1");
		log.info(carRegistration);
	}
	
}
