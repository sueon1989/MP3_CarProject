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

@Controller	// �������� ������ �ν�
@Log4j		
@RequestMapping("/weather/*")	// /member�� �����ϴ� ��� ó���� MemberController�� ó���ϵ��� ����
@AllArgsConstructor			// MemberController�� MemberService�� ������: �����ڸ� ����� �ڵ����� �����ϵ��� ��
public class WeatherController {

	private WeatherService service;	
	private MypageService mypageService;	
//	@Value("${weather.api.serviceKey}")
//	private String serviceKey;
	
	// ��������
	@RequestMapping(value = "/weatherInfo", method = RequestMethod.GET)
	public String weather(WeatherVO weather, Model model) {

		log.info("�������� ��ȸ");
		String serviceKey = "HnXMKIO%2FZdGJgfHsO%2Fxv2OlX0AR%2BuhAAV0zyLZlER5M7ehOb%2BHzBPgWBPmJ4BKr1FfIfxNxtKbERPR1t5gtnrA%3D%3D";
		
		// ���� ��¥/�ð� �б� 
//		String baseDate = "20210122"; 	// ��������
//      String baseTime = "0200"; 		// �����ð�		(0200, 0500, 0800, 1100, 1400, 1700, 2000, 2300 (1�� 8ȸ))

		weather = service.getNowDate(weather);
		String baseDate = weather.getBaseDate(); 	// ��������
        String baseTime = weather.getBaseTime(); 	// �����ð�		(0200, 0500, 0800, 1100, 1400, 1700, 2000, 2300 (1�� 8ȸ))


        // gps ��ġ���� �о����
        int nx = 60;  	//�浵
        int ny = 120;   //����
        
        weather = service.getWeatherAPI(serviceKey, baseDate, baseTime, nx, ny);
        log.info("������ȸ API service �Ϸ�: "+ weather);
        log.info("���� DB��� service �Ϸ�: "+ service.register(weather) +
        		" (baseDate: "+weather.getFcstDate()+" "+weather.getFcstTime()+")");
        
        weather = service.getWeatherInfo(weather);
        log.info("���� ������� service �Ϸ�: "+ weather);
        
        model.addAttribute("weather", weather);
//        model.addAttribute("weatherInfo", weather);
		log.info("�������� ��ȸ�Ϸ�");
		
		return "/common/weather/weatherInfo";
		
	}
}
