package com.mp3.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mp3.domain.WeatherLocationVO;
import com.mp3.domain.WeatherVO;
import com.mp3.service.MypageService;
import com.mp3.service.WeatherService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */
@Controller
@Log4j	
@AllArgsConstructor
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	private WeatherService service;	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, WeatherVO weather, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		//test

		// ���� ��ȸ ����
		log.info("�������� ��ȸ");
		String serviceKey = "HnXMKIO%2FZdGJgfHsO%2Fxv2OlX0AR%2BuhAAV0zyLZlER5M7ehOb%2BHzBPgWBPmJ4BKr1FfIfxNxtKbERPR1t5gtnrA%3D%3D";
		
		// �����Ͻ� ����
//		String baseDate = "20210122"; 	// ��������
//	    String baseTime = "0200"; 		// �����ð�		(0200, 0500, 0800, 1100, 1400, 1700, 2000, 2300 (1�� 8ȸ))
		weather = service.getNowDate();	// �����Ͻ�
       
		// gps ��ġ���� �о����
//		int nx = 60;  	//�浵
//		int ny = 120;   //����
		
		String gpsAdd = service.getGpsAdd();	// gps �ּ�����
        WeatherLocationVO weatherLocation = service.getNowLocation(gpsAdd);	// ������ġ
        weather.setNx( Integer.parseInt(weatherLocation.getNx()) );
        weather.setNy( Integer.parseInt(weatherLocation.getNy()) );
        
        weather = service.getWeatherAPI(serviceKey, weather);	// ������ȸ API
        log.info("������ȸ API service �Ϸ�: "+ weather);
        log.info("���� DB��� service �Ϸ�: "+ service.register(weather) +
        		" (baseDate: "+weather.getBaseDate()+" baseTime: "+weather.getBaseTime()+")");

        //
        weather = service.getWeatherInfo(weather);
        log.info("���� ������� service �Ϸ�: "+ weather);
        

        model.addAttribute("weatherLocation", weatherLocation);
        model.addAttribute("weather", weather);
		log.info("�������� ��ȸ�Ϸ�");
		// ���� ��ȸ ��
		return "home";
	}
	
}
