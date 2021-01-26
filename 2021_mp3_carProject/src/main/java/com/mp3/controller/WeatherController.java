package com.mp3.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mp3.domain.AuthVO;
import com.mp3.domain.MemberVO;
import com.mp3.domain.WeatherVO;
import com.mp3.service.MypageService;
import com.mp3.service.WeatherService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller	// 스프링의 빈으로 인식
@Log4j		
@RequestMapping("/weather/*")	// /member로 시작하는 모든 처리를 MemberController가 처리하도록 지정
@AllArgsConstructor			// MemberController는 MemberService에 의존적: 생성자를 만들고 자동으로 주입하도록 함
public class WeatherController {

	private WeatherService service;	
	private MypageService mypageService;	
//	@Value("${weather.api.serviceKey}")
//	private String serviceKey;
	
	// 날씨정보
	@RequestMapping(value = "/weatherInfo", method = RequestMethod.GET)
	public String weather(WeatherVO weather, Model model) {

		log.info("날씨정보 조회");
		String serviceKey = "HnXMKIO%2FZdGJgfHsO%2Fxv2OlX0AR%2BuhAAV0zyLZlER5M7ehOb%2BHzBPgWBPmJ4BKr1FfIfxNxtKbERPR1t5gtnrA%3D%3D";
		
		// 현재 날짜/시간 읽기 
//		String baseDate = "20210122"; 	// 예보일자
//      String baseTime = "0200"; 		// 예보시각		(0200, 0500, 0800, 1100, 1400, 1700, 2000, 2300 (1일 8회))

		weather = service.getNowDate(weather);
		String baseDate = weather.getBaseDate(); 	// 예보일자
        String baseTime = weather.getBaseTime(); 	// 예보시각		(0200, 0500, 0800, 1100, 1400, 1700, 2000, 2300 (1일 8회))


        // gps 위치정보 읽어오기
        int nx = 60;  	//경도
        int ny = 120;   //위도
        
        weather = service.getWeatherAPI(serviceKey, baseDate, baseTime, nx, ny);
        log.info("날씨조회 API service 완료: "+ weather);
        log.info("날씨 DB등록 service 완료: "+ service.register(weather) +
        		" (baseDate: "+weather.getFcstDate()+" "+weather.getFcstTime()+")");
        
        weather = service.getWeatherInfo(weather);
        log.info("날씨 정보등록 service 완료: "+ weather);
        
        model.addAttribute("weather", weather);
//        model.addAttribute("weatherInfo", weather);
		log.info("날씨정보 조회완료");
		
		return "/common/weather/weatherInfo";
		
	}
}
