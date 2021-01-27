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

// 담당자: kim
@RunWith(SpringJUnit4ClassRunner.class)	// 현재 테스트 코드가 스프링을 실행하는 역할을 할 것
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class WeatherMapperTests {
	
	@Autowired
	private WeatherMapper mapper;
	
	// 위치 조회 - read (select) 처리
	@Test
	public void testRead() {
		
		// gps 주소정보 조회
//		String gpsAdd = "경기도 수원시 권선구 권선2동";
		String gpsAdd = mapper.readGpsAdd();
		log.info("gpsAdd 조회: "+ gpsAdd);
		
//		공백(" ")으로 문자열 자르기
		String[] gpsArray = gpsAdd.split(" ");
		for(int i=0; i<gpsArray.length; i++) {
			System.out.println(gpsArray[i]);
		}
		WeatherLocationVO weatherLocation = new WeatherLocationVO();
		weatherLocation.setLo1st(gpsArray[0]);
		weatherLocation.setLo2nd(gpsArray[1]+gpsArray[2]);
		weatherLocation.setLo3rd(gpsArray[3]);
		log.info("확인: "+ weatherLocation.getLo1st()+" "+weatherLocation.getLo2nd()+" "+weatherLocation.getLo3rd());

		String lo1st = weatherLocation.getLo1st();
		String lo2nd = weatherLocation.getLo2nd();
		String lo3rd = weatherLocation.getLo3rd();
		weatherLocation = mapper.readLocation(lo1st, lo2nd, lo3rd);
//		weatherLocation = mapper.readLocation(gpsArray[0], gpsArray[1]+gpsArray[2], gpsArray[3]);
		log.info("위치정보: "+ weatherLocation);
		log.info("위치정보: nx: "+ weatherLocation.getNx()+" ny: "+weatherLocation.getNy());
	}
	
}
