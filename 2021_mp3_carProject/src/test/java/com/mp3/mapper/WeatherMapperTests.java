package com.mp3.mapper;

import java.sql.Date;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mp3.domain.AuthVO;
import com.mp3.domain.MemberVO;
import com.mp3.domain.WeatherLocationVO;

import lombok.extern.log4j.Log4j;

// �����: kim
@RunWith(SpringJUnit4ClassRunner.class)	// ���� �׽�Ʈ �ڵ尡 �������� �����ϴ� ������ �� ��
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class WeatherMapperTests {
	
	@Autowired
	private WeatherMapper mapper;
	
	// ��ġ ��ȸ - read (select) ó��
	@Test
	public void testRead() {
		
		// gps �ּ����� ��ȸ
//		String gpsAdd = "��⵵ ������ �Ǽ��� �Ǽ�2��";
		String gpsAdd = mapper.readGpsAdd();
		log.info("gpsAdd ��ȸ: "+ gpsAdd);
		
//		����(" ")���� ���ڿ� �ڸ���
		String[] gpsArray = gpsAdd.split(" ");
		for(int i=0; i<gpsArray.length; i++) {
			System.out.println(gpsArray[i]);
		}
		WeatherLocationVO weatherLocation = new WeatherLocationVO();
		weatherLocation.setLo1st(gpsArray[0]);
		weatherLocation.setLo2nd(gpsArray[1]+gpsArray[2]);
		weatherLocation.setLo3rd(gpsArray[3]);
		log.info("Ȯ��: "+ weatherLocation.getLo1st()+" "+weatherLocation.getLo2nd()+" "+weatherLocation.getLo3rd());

		String lo1st = weatherLocation.getLo1st();
		String lo2nd = weatherLocation.getLo2nd();
		String lo3rd = weatherLocation.getLo3rd();
		weatherLocation = mapper.readLocation(lo1st, lo2nd, lo3rd);
//		weatherLocation = mapper.readLocation(gpsArray[0], gpsArray[1]+gpsArray[2], gpsArray[3]);
		log.info("��ġ����: "+ weatherLocation);
		log.info("��ġ����: nx: "+ weatherLocation.getNx()+" ny: "+weatherLocation.getNy());
	}
	
}
