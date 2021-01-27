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

		// 날씨 조회 시작
		log.info("날씨정보 조회");
		String serviceKey = "HnXMKIO%2FZdGJgfHsO%2Fxv2OlX0AR%2BuhAAV0zyLZlER5M7ehOb%2BHzBPgWBPmJ4BKr1FfIfxNxtKbERPR1t5gtnrA%3D%3D";
		
		// 예보일시 지정
//		String baseDate = "20210122"; 	// 예보일자
//	    String baseTime = "0200"; 		// 예보시각		(0200, 0500, 0800, 1100, 1400, 1700, 2000, 2300 (1일 8회))
		weather = service.getNowDate();	// 예보일시
       
		// gps 위치정보 읽어오기
//		int nx = 60;  	//경도
//		int ny = 120;   //위도
		
		String gpsAdd = service.getGpsAdd();	// gps 주소정보
        WeatherLocationVO weatherLocation = service.getNowLocation(gpsAdd);	// 예보위치
        weather.setNx( Integer.parseInt(weatherLocation.getNx()) );
        weather.setNy( Integer.parseInt(weatherLocation.getNy()) );
        
        weather = service.getWeatherAPI(serviceKey, weather);	// 날씨조회 API
        log.info("날씨조회 API service 완료: "+ weather);
        log.info("날씨 DB등록 service 완료: "+ service.register(weather) +
        		" (baseDate: "+weather.getBaseDate()+" baseTime: "+weather.getBaseTime()+")");

        //
        weather = service.getWeatherInfo(weather);
        log.info("날씨 정보등록 service 완료: "+ weather);
        

        model.addAttribute("weatherLocation", weatherLocation);
        model.addAttribute("weather", weather);
		log.info("날씨정보 조회완료");
		// 날씨 조회 끝
		return "home";
	}
	
}
