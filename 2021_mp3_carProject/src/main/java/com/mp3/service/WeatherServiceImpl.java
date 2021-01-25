package com.mp3.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mp3.domain.WeatherInfoVO;
import com.mp3.domain.WeatherVO;
import com.mp3.mapper.WeatherMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class WeatherServiceImpl implements WeatherService {
	
//	@Autowired
//	단일 파라미터를 받는 생성자의 경우, 필요한 파라미터를 자동으로 주입
	private WeatherMapper mapper;
	
	@Override
	public WeatherVO getWeatherAPI(String serviceKey, String baseDate, String baseTime, int nx, int ny) {
		//baseDate : 기준날짜, baseTime : 기준시간, nx : 경도, ny : 위도
        	
		log.info("날씨조회 API service 시작");
		log.info("조회할 날짜......"+baseDate);
				
		// 결과 데이터를 저장할 weather 객체생성
		WeatherVO weather = new WeatherVO(); 
		log.info("weatherVO 생성: "+weather);
		
		try {
			// JSON 데이터를 요청하는 apiURL (공공데이터포털 API 연동)
	        String apiURL = "http://apis.data.go.kr/1360000/VilageFcstInfoService/getVilageFcst?"
	        		+ "serviceKey=" + serviceKey 
//	        		+ "&pageNo=1"
//	        		+ "&numOfRows=10"
	        		+ "&dataType=JSON"
	        		+ "&base_date=" + baseDate
	        		+ "&base_time=" + baseTime
	        		+ "&nx=" + nx
	        		+ "&ny=" + ny;
	        
	        // 완성된 apiURL을 이용해서 URL 객체생성 후 결과 데이터 가져오기
	        URL url = new URL(apiURL); 
	        BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream()));	//날씨 정보 받기
	        String line = "";
	        String result="";

        	//버퍼 bf에 있는 정보를 문자열로 변환하기
        	while((line=bf.readLine())!=null){
            	result=result.concat(line);
            	log.info("날씨예보: "+result);	 // 받아온 데이터 확인
        	}
        	
        	// JSONParser 객체를 만들어 만들어진 문자열 데이터를 객체화 합니다. 
        	JSONParser jsonParser = new JSONParser();
            JSONObject jsonObj = (JSONObject) jsonParser.parse(result);
            JSONObject parse_response = (JSONObject) jsonObj.get("response");// Top레벨 단계인 response 키를 가지고 데이터를 파싱
            JSONObject parse_header = (JSONObject) parse_response.get("header");// response 로 부터 header 찾아오기
            JSONObject parse_body = (JSONObject) parse_response.get("body");// response 로 부터 body 찾아오기
            JSONObject parse_items = (JSONObject) parse_body.get("items");// body 로 부터 items 받아오기
            JSONArray parse_item = (JSONArray) parse_items.get("item");// items로 부터 itemlist 를 받아오기 itemlist : 뒤에 [ 로 시작하므로 jsonarray이다.
		
            String category;
            JSONObject obj;	// parse_item은 배열형태이기 때문에 하나씩 데이터를 하나씩 가져올때 사용

            // 기준날짜와 기준시간 등을 WeatherVO 객체에 저장
            weather.setResultCode( (String)parse_header.get("resultCode") );
        	weather.setResultMsg( (String)parse_header.get("resultMsg") );
        	weather.setDataType( (String)parse_body.get("dataType") );
            weather.setBaseDate(baseDate);
            weather.setBaseTime(baseTime);
            weather.setNx(nx);
            weather.setNy(ny);
            
        	// 필요한 날씨 데이터를 WeatherVO 객체에 저장
        	for(int i = 0; i < parse_item.size(); i++) {
                obj = (JSONObject) parse_item.get(i); // 해당 item을 가져옵니다.
                category = (String)obj.get("category"); //item에서 카테고리를 검색해옵니다.
                log.info(i+"번째 데이터값: "+obj);

                // 예보일자와 예보시각을 WeatherVO 객체에 저장
                if (weather.getFcstDate() == null || weather.getFcstDate().isEmpty()) {
                	weather.setFcstDate( (String)obj.get("fcstDate") );
                	weather.setFcstTime( (String)obj.get("fcstTime") ); // 예보시각	(0200, 0500, 0800, 1100, 1400, 1700, 2000, 2300 (1일 8회))
                	log.info("예보날짜: "+weather.getFcstDate());
                	log.info("예보시각: "+weather.getFcstTime());
                }
                
                // 검색한 카테고리와 일치하는 변수에 문자형으로 데이터 저장
                // 데이터들이 형태가 달라 문자열로 통일하되, VO에서 꺼내서 사용할때 다시 변환하여 사용
                switch(category) {
                    case "POP":
                        weather.setPop((obj.get("fcstValue")).toString());
                        break;
                    case "PTY":
                        weather.setPty((obj.get("fcstValue")).toString());
                        break;
                    case "R06":
                        weather.setR06((obj.get("fcstValue")).toString());
                        break;
                    case "REH":
                        weather.setReh((obj.get("fcstValue")).toString());
                        break;
                    case "S06":
                        weather.setS06((obj.get("fcstValue")).toString());
                        break;
                    case "SKY":
                        weather.setSky((obj.get("fcstValue")).toString());
                        break;
                    case "T3H":
                        weather.setT3h((obj.get("fcstValue")).toString());
                        break;
                    case "TMN":
                        weather.setTmn((obj.get("fcstValue")).toString());
                        break;
                    case "TMX":
                        weather.setTmx((obj.get("fcstValue")).toString());
                        break;
                    case "UUU":
                        weather.setUuu((obj.get("fcstValue")).toString());
                        break;
                    case "VEC":
                        weather.setVec((obj.get("fcstValue")).toString());
                        break;
                    case "VVV":
                        weather.setVvv((obj.get("fcstValue")).toString());
                        break;
                    case "WAV":
                        weather.setWav((obj.get("fcstValue")).toString());
                        break;
                    case "WSD":
                        weather.setWsd((obj.get("fcstValue")).toString());
                        break;	
                }//case
            }//for

        	bf.close();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return weather;
	}

	@Override
	public boolean register(WeatherVO weather) {
		
		log.info("날씨 DB등록 service 시작");
		log.info("DB등록할 VO 정보: "+weather);
		
		return mapper.insertSelectKey(weather) == 1;
	}

	@Override
	public WeatherVO getNowDate(WeatherVO weather) {

		log.info("현재날짜 조회");
		
		LocalDateTime dateAndtime = LocalDateTime.now();
//		LocalDateTime dateAndtime = LocalDateTime.of(2021, 1, 22, 1, 10);	// 테스트용
		log.info("날짜조회: "+dateAndtime+" (패턴 변경전)");	// 날짜조회: 2021-01-22T14:30:50.158

		DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyyMMdd");
		DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HHmm");
		
		int nowDate = Integer.parseInt( dateAndtime.format(formatterDate) );
		int nowTime = Integer.parseInt( dateAndtime.format(formatterTime) );
		
		log.info("현재날짜: "+nowDate+" "+nowTime);


		// 날씨 조회날짜 WeatherVO 객체에 저장
		weather.setBaseDate( Integer.toString(nowDate) );
		
		// 날씨 조회시간 WeatherVO 객체에 저장
		// 동네예보
		// - Base_time : 0200, 0500, 0800, 1100, 1400, 1700, 2000, 2300 (1일 8회)
		// - API 제공 시간(~이후) : 02:10, 05:10, 08:10, 11:10, 14:10, 17:10, 20:10, 23:10
		if (nowTime < 0210 ) {
			weather.setBaseDate( Integer.toString(nowDate-1));
			weather.setBaseTime("2300");
		}else if (nowTime < 510 ) {
			weather.setBaseTime("0200");
		}else if (nowTime < 810 ) {
			weather.setBaseTime("0500");
		}else if (nowTime < 1110 ) {
			weather.setBaseTime("0800");
		}else if (nowTime < 1410 ) {
			weather.setBaseTime("1100");
		}else if (nowTime < 1710 ) {
			weather.setBaseTime("1400");
		}else if (nowTime < 2010 ) {
			weather.setBaseTime("1700");
		}else if (nowTime < 2310 ) {
			weather.setBaseTime("2000");
		}
		log.info("예보일자: "+weather.getBaseDate()+" "+weather.getBaseTime());
		
		
		return weather;
	}
	
	@Override
	public WeatherVO getNowLocation(WeatherVO weather) {
		
		// 학원 위치정보 (gps 센서값)
		String Latitude = "37.249035";		// 위도
		String Longitude = "127.022705";	// 경도
		
		return weather;
	}


	@Override
	public WeatherInfoVO getWeatherInfo(WeatherVO weather) {
		
        WeatherInfoVO weatherInfo = new WeatherInfoVO();
    	String pop = weather.getPop();					// 강수확률	(%)
    	String pty = weather.getPty();					// 강수형태
    	int r06 = Integer.parseInt(weather.getR06());	// 6시간 강수량	(1 mm)
    	String reh = weather.getReh();					// 습도		(%)
    	int s06 = Integer.parseInt(weather.getS06());	// 6시간 신적설	(1 cm)
    	String sky = weather.getSky();					// 하늘상태
    	String t3h = weather.getT3h();			// 3시간 기온		(℃)
    	String tmn = weather.getTmn();			// 아침 최저기온	(℃)
    	String tmx = weather.getTmx(); 		// 낮 최고기온		(℃)
    	String uuu = weather.getUuu();			// 풍속(동서성분)	(m/s)
    	String vvv = weather.getVvv();			// 풍속(남북성분)	(m/s)
    	String wav = weather.getWav(); 		//파고	(M)
    	String vec = weather.getVec();			// 풍향		(deg)
    	String wsd = weather.getWsd();			// 풍속		(m/s)

        // 하늘상태(SKY) 코드 : 맑음(1), 구름많음(3), 흐림(4)
        if 		(sky.equals("1"))	weatherInfo.setSky("맑음");
        else if (sky.equals("3"))	weatherInfo.setSky("구름많음");
        else if (sky.equals("4"))	weatherInfo.setSky("흐림");
        
    	// 강수형태(PTY) 코드 
        if 		(pty.equals("0"))	weatherInfo.setPty("");
        else if (pty.equals("1"))	weatherInfo.setPty("비");
        else if (pty.equals("2"))	weatherInfo.setPty("진눈개비");
        else if (pty.equals("3"))	weatherInfo.setPty("눈");
        else if (pty.equals("4"))	weatherInfo.setPty("소나기");
        else if (pty.equals("5"))	weatherInfo.setPty("빗방울");
        else if (pty.equals("6"))	weatherInfo.setPty("빗방울/눈날림");
        else if (pty.equals("7"))	weatherInfo.setPty("눈날림");
        
        // 6시간 강수량	(1 mm)
        // 예)	R06 =  6 일 경우 강수량은 5~9mm
        // 		RO6 = 25 일 경우 강수량은 20~39mm
        if(r06 < 0.1)		weatherInfo.setR06("");
        else if(r06 < 1)	weatherInfo.setR06("1 mm 미만");
        else if(r06 < 5)	weatherInfo.setR06("1~4 mm");
        else if(r06 < 10)	weatherInfo.setR06("5~9 mm");
        else if(r06 < 20)	weatherInfo.setR06("10~19 mm");
        else if(r06 < 40)	weatherInfo.setR06("20~39 mm");
        else if(r06 < 70)	weatherInfo.setR06("40~69 mm");
        else 				weatherInfo.setR06("70 mm 이상");
        
        // 6시간 신적설	(1 cm)
        if(s06 < 0.1)		weatherInfo.setS06("");
        else if(s06 < 1)	weatherInfo.setS06("1 cm 미만");
        else if(s06 < 5)	weatherInfo.setS06("1~4 cm");
        else if(s06 < 10)	weatherInfo.setS06("5~9 cm");
        else if(s06 < 20)	weatherInfo.setS06("10~19 cm");
        else 				weatherInfo.setS06("20 cm 이상");
        
        // 풍속 정보
        // 동서바람성분(UUU) : 동(+표기), 서(-표기)
        // 남북바람성분(VVV) : 북(+표기), 남(-표기)
        
        // +900이상, –900 이하 값은 Missing 값으로 처리
        // 관측장비가 없는 해양 지역이거나 관측장비의 결측 등으로 자료가 없음을 의미
        
        // 동네예보조회 해상 마스킹 처리
        // - 해상에는 기온군, 강수확률, 강수량/적설, 습도를 제공하지 않음
        // (Missing값으로 마스킹처리 함)

		return weatherInfo;
	}
	

//	// 조회 (한 행) - read (select) 처리
//	@Override
//	public MemberVO get(String userid) {
//		
//		log.info("조회......"+userid);
//		return mapper.read(userid);
//	}
	
//	// 목록(리스트)
//	@Override
//	public List<MemberVO> getList() {
//		
//		log.info("목록(리스트)......");
//		return mapper.getList();
//	}
}
