package com.mp3.service;

import static org.junit.Assert.assertNotNull;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mp3.domain.AuthVO;
import com.mp3.domain.MemberVO;
import com.mp3.domain.WeatherInfoVO;
import com.mp3.domain.WeatherVO;

import lombok.extern.log4j.Log4j;

// 담당자: kim
@RunWith(SpringJUnit4ClassRunner.class)	// 현재 테스트 코드가 스프링을 실행하는 역할을 할 것
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class WeatherServiceTests {
	
	@Autowired
	private WeatherService service;
	
//	@Value("${weather.api.serviceKey}")
//	private String serviceKey;

	@Test
	public void testExist() {
		
		// WeatherService 객체가 제대로 주입이 가능한지 확인
		log.info("서비스 "+service);
		assertNotNull(service);
	}
	

    // 기상청에서 제공하는 동네 기상정보를 JSON데이터로 가져와서 WeatherVO 객체로 저장하여 반환
    // 기준 날짜, 시간, 위도, 경도를 입력하면 해당하는 지역의 동네기상정보를 JSON데이터로 가져와 
	// WeatherVO 객체를 만들어 반환
	@Test
	public void getVillageWeather() {
		
		// 공공데이터포털 API 연동
//		String serviceKey = "위에서 전역변수 선언(properties 파일 사용)";
		String serviceKey = "HnXMKIO%2FZdGJgfHsO%2Fxv2OlX0AR%2BuhAAV0zyLZlER5M7ehOb%2BHzBPgWBPmJ4BKr1FfIfxNxtKbERPR1t5gtnrA%3D%3D";
		String baseDate = "20210122"; 	// 예보일자
        String baseTime = "0200"; 		// 예보시각		(0200, 0500, 0800, 1100, 1400, 1700, 2000, 2300 (1일 8회))
		int nx = 60;  	//경도
        int ny = 120;   //위도
        
        WeatherVO weather = service.getWeatherAPI(serviceKey, baseDate, baseTime, nx, ny);
        log.info("날씨조회 API service 완료: "+ weather);
        log.info("날씨 DB등록 service 완료: "+ service.register(weather) +" (baseDate: "+weather.getFcstDate()+" "+weather.getFcstTime()+")");
    }



	@Test
	public void getNowDate() {
		WeatherVO weather = new WeatherVO();
		weather = service.getNowDate(weather);
		log.info("현재 날짜조회 service 완료: "+ weather.getBaseDate()+" "+weather.getBaseTime());
	}



		
		
	
	@Test
	public void getVillageWeatherInfo() {
		
		
		// 여기부터 이전 구현 내용
		
		// 공공데이터포털 API 연동
//		String serviceKey = "위에서 전역변수 선언(properties 파일 사용)";
		String serviceKey = "HnXMKIO%2FZdGJgfHsO%2Fxv2OlX0AR%2BuhAAV0zyLZlER5M7ehOb%2BHzBPgWBPmJ4BKr1FfIfxNxtKbERPR1t5gtnrA%3D%3D";
		String baseDate = "20210122"; 	// 예보일자
        String baseTime = "0200"; 		// 예보시각		(0200, 0500, 0800, 1100, 1400, 1700, 2000, 2300 (1일 8회))
		int nx = 60;  	//경도
        int ny = 120;   //위도
        
        WeatherVO weather = service.getWeatherAPI(serviceKey, baseDate, baseTime, nx, ny);
        log.info("날씨조회 API service 완료: "+ weather);
        log.info("날씨 DB등록 service 완료: "+ service.register(weather) +" (no: "+ weather.getWeather_no() +")");
        // 여기까지 controller 구현 완료
    	
        WeatherInfoVO weatherInfo = service.getWeatherInfo(weather);
        log.info("날씨조회: "+ weather);
        log.info("날씨정보: "+ weatherInfo);
        
    }
	

	// 날씨 API 테스트
	@Test
	public void weatherReadTest() {
		
		// 공공데이터포털 API 연동
//		String serviceKey = "위에서 전역변수 선언(properties 파일 사용)";
		String serviceKey = "HnXMKIO%2FZdGJgfHsO%2Fxv2OlX0AR%2BuhAAV0zyLZlER5M7ehOb%2BHzBPgWBPmJ4BKr1FfIfxNxtKbERPR1t5gtnrA%3D%3D";
		String baseDate = "20210121"; // 자신이 조회하고싶은 날짜를 입력해주세요
        String baseTime = "0500"; //자신이 조회하고싶은 시간대를 입력해주세요
		int nx = 126;  //경도
        int ny = 37;   //위도
        
        String apiURL = "http://apis.data.go.kr/1360000/VilageFcstInfoService/getVilageFcst?"
        		+ "serviceKey=" + serviceKey 
//        		+ "&pageNo=1"
//        		+ "&numOfRows=10"
        		+ "&dataType=JSON"
        		+ "&base_date=" + baseDate
        		+ "&base_time=" + baseTime
        		+ "&nx=" + nx
        		+ "&ny=" + ny;
        		
        try {
	        // apiURL을 이용해서 URL 객체 생성
	        URL url = new URL(apiURL); 
	        BufferedReader bf;
	        String line = "";
	        String result="";
        
        	//날씨 정보를 받아옵니다.
        	bf = new BufferedReader(new InputStreamReader(url.openStream()));

        	//버퍼에 있는 정보를 하나의 문자열로 변환.
        	while((line=bf.readLine())!=null){
            	result=result.concat(line);
//            	System.out.println("날씨예보: "+result);  // 받아온 데이터를 확인해봅니다.
            	log.info("날씨예보: "+result);
        	}
     
        	// Json parser를 만들어 만들어진 문자열 데이터를 객체화 합니다. 
        	JsonParser parser = new JsonParser();
        	JsonObject obj = (JsonObject) parser.parse(result);
		
        	// Top레벨 단계인 response 키를 가지고 데이터를 파싱합니다.
        	JsonObject parse_response = (JsonObject) obj.get("response");
        	// response 로 부터 body 찾아옵니다.
        	JsonObject parse_body = (JsonObject) parse_response.get("body");
        	// body 로 부터 items 받아옵니다.
        	JsonObject parse_items = (JsonObject) parse_body.get("items");
		
        	// items로 부터 itemlist 를 받아오기 itemlist : 뒤에 [ 로 시작하므로 jsonarray이다
        	JsonArray parse_item = (JsonArray) parse_items.get("item");
		
        	String category;
        	JsonObject weather; // parse_item은 배열형태이기 때문에 하나씩 데이터를 하나씩 가져올때 사용합니다.

        	// 필요한 데이터만 가져오려고합니다.
        	for(int i = 0 ; i < parse_item.size(); i++) {
				weather = (JsonObject) parse_item.get(i);
//				System.out.println(i+"번째 데이터값: "+weather);
				log.info(i+"번째 데이터값: "+weather);
				//String base_Date = weather.get(baseDate);
				//String base_Date = (String)weather.get("baseDate");
				//String fcst_Time = (String)weather.get("fcstDate");
//				double fcst_Value = ((Long)weather.get("fcstValue")).doubleValue(); //실수로된 값과 정수로된 값이 둘다 있어서 실수로 통일했습니다.
				//String nX = (String)weather.get("nx");
				//String nY = (String)weather.get("ny");
//				category = (String)weather.get("category");
				//String base_Time = (String)weather.get("baseTime");
				//String fcscDate = (String)weather.get("fcscDate");
				
				// 출력합니다.
//				System.out.print("배열의 "+i+"번째 요소");
//				System.out.print("   category : "+ category);
//				System.out.print("   fcst_Value : "+ fcst_Value);
//				System.out.println();
			}
			// 마지막에보면 에러가 발생하였는데 casting문제입니다. 
			// 이는 반환되는 데이터타입이 달라서인데 이번 글에서는 여기까지만하고
			// 데이터베이스에 입력할때는 수정해서 하겠습니다.
    	bf.close();
	  } catch(Exception e) {
	      System.out.println(e.getMessage());
	  }
	}
	
	
	

//	// 목록(리스트)
//	@Test
//	public void testGetList() {
//		
//		List<MemberVO> memberList = service.getList();
//		for(MemberVO member: memberList) {
//			log.info(member);
//		}
//		
//		// 람다식으로 표현 (교재 방법)
//		// service.getList().forEach(member -> log.info(member));
//	}
//	
//	// 조회 (한 행) - read (select) 처리
//	@Test
//	public void testGet() {
//		
//		// 존재하는 회원 번호로 테스트
//		log.info("조회 결과: "+ service.get("user2003"));
//	}
//	
////	삭제 - delete 처리
//	@Test
//	public void testDelete() {
//		
//		// 존재하는 회원 번호로 테스트
//		log.info("삭제 DELETE 결과: "+ service.remove(102L));
//	}
//	
////	수정 - update 처리
//	@Test
//	public void testUpdate() {
//		
//		// 특정한 회원을 먼저 조회
//		MemberVO member = service.get("user12");
//
//		// 존재하는 회원 번호로 테스트
//		member.setMember_no(1L);
//		member.setMember_id("user12");
//		member.setMember_pass("1234");
//		member.setMember_name("홍길동1");
//		member.setMember_gender("남");
//		member.setMember_birth(Date.valueOf("2010-12-25"));	// String을 Date로 변환
//		member.setMember_phone("010-1245-1231");
//		member.setMember_address("용인시");
//		member.setMember_mail("12aaa@mp3.com");
//		member.setMember_mailaccept("yes");	
//		
//		log.info("수정 UPDATE 결과: "+ service.modify(member));
//		log.info(member);
//	}
	
	
}
