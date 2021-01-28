package com.mp3.service;

import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mp3.domain.CarRegistrationVO;
import com.mp3.domain.Car_fixVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)	// ���� �׽�Ʈ �ڵ尡 �������� �����ϴ� ������ �� ��
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class Car_fixServiceTests {
	@Autowired
	private Car_fixService service;
	
	@Test
	public void	car_fix() {
		Car_fixVO car_fix = new Car_fixVO();
		
		car_fix.setMember_id("aaaaaa");
		car_fix.setRepair("Ÿ�̾�1");
		car_fix.setRepairshop("����ť");
		car_fix.setRepair_date(Date.valueOf("2021-01-27"));
		car_fix.setAmount(35000L);
		
			service.car_fix(car_fix);
			log.info("��������??"+car_fix);
	}
	
	
	@Test
	public void	car_fixupdatetest() {
	Car_fixVO car_fix = new Car_fixVO();
		
		car_fix.setMember_id("user3");
		car_fix.setRepair("Ÿ�̾�");
		car_fix.setRepair_date(Date.valueOf("2021-01-27"));
		car_fix.setRepairshop("�������");
		car_fix.setAmount(250000L);
		
		service.car_fixUpdate(car_fix);
		log.info("��������??"+car_fix);
	}
	@Test
	public void	car_fixTest() {
		Car_fixVO car_fix =	service.car_fixlist("user3");
		log.info("��������??"+car_fix);
	
	}
}
