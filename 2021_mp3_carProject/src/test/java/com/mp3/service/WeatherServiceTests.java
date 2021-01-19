package com.mp3.service;

import static org.junit.Assert.assertNotNull;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Date;
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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mp3.domain.AuthVO;
import com.mp3.domain.MemberVO;
import com.mp3.domain.WeatherVO;

import lombok.extern.log4j.Log4j;

// 담당자: kim
@RunWith(SpringJUnit4ClassRunner.class)	// 현재 테스트 코드가 스프링을 실행하는 역할을 할 것
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class WeatherServiceTests {
	
	@Autowired
	private WeatherService service;
	
	@Test
	public void weatherReadTest() {
		
		// 공공데이터포털 API 연동
		String serviceKey = "#";
		String baseDate = "20210115"; // 자신이 조회하고싶은 날짜를 입력해주세요
        String baseTime = "0500"; //자신이 조회하고싶은 시간대를 입력해주세요
		String nx = "126";  //경도
        String ny = "37";   //위도
        
        String apiURL = "http://"
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
            	System.out.println("날씨예보: "+result);  // 받아온 데이터를 확인해봅니다.
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
				System.out.println(i+"번째 데이터값: "+weather);
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
	  
	  

//        // requestHeaders?
//        Map<String, String> requestHeaders = new HashMap<>();
//        requestHeaders.put("serviceKey", serviceKey);
//        requestHeaders.put("baseDate", baseDate);
//        requestHeaders.put("baseTime", baseTime);
//        requestHeaders.put("nx", nx);
//        requestHeaders.put("ny", ny);
////        service.get(baseDate, baseTime, nx, ny);
//        
//
//      // API 데이터로부터 얻은 JSON을 파싱하기
//      // (JSONParser 라이브러리 사용: 파싱한 데이터를 JSONObject로 변환하여 사용) 
//
//      // get?
//      String responseBody = get(apiURL, requestHeaders);
//      String json = responseBody;
//
//
//      JSONParser parser = new JSONParser();
//      JSONObject obj = (JSONObject)parser.parse(json);
//      JSONArray item = (JSONArray)obj.get("items");
//
//      // 파싱한 데이터를 정의한 클래스 객체를 통해 리스트로 담기
//      List < WeatherVO > list = null;
//      list = new ArrayList<WeatherVO>();
	}
	
	
//	@Test
//    public void weatherTest() {
//        try{
//        	/*요청정보입력
//        	 * 아래와 같은 정보들은 사용자 가이드를 확인하여 찾아주시면 됩니다.
//        	 * 위도 경도는 엑셀파일 안에 있습니다.
//        	 * */
//        	
//            // 조회를 원하는 지역의 경도와 위도를 입력 (수원시권선구 평동)
//            String nx = "126";  //경도
//            String ny = "37";   //위도
//            String baseDate = "20180502"; // 자신이 조회하고싶은 날짜를 입력해주세요
//            String baseTime = "0500"; //자신이 조회하고싶은 시간대를 입력해주세요
//            // 서비스 인증키입니다. 공공데이터포털에서 제공해준 인증키를 넣어주시면 됩니다.
//            String serviceKey = "개인별로 받은 인증키를 넣어주세요";
//            
//            // 정보를 모아서 URL정보를 만들면됩니다. 맨 마지막 "&_type=json"에 따라 반환 데이터의 형태가 정해집니다.
//            String urlStr = "http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService2/ForecastSpaceData?"
//            		+ "serviceKey=" + serviceKey + "&base_date=" + baseDate + "&base_time=" + baseTime
//            		+ "&nx="+ nx + "&ny=" + ny + "&_type=json";
//            URL url = new URL(urlStr); // 위 urlStr을 이용해서 URL 객체를 만들어줍니다.
//            BufferedReader bf;
//            String line = "";
//            String result="";
//
//            //날씨 정보를 받아옵니다.
//            bf = new BufferedReader(new InputStreamReader(url.openStream()));
//
//            //버퍼에 있는 정보를 하나의 문자열로 변환.
//            while((line=bf.readLine())!=null){
//                result=result.concat(line);
//               // System.out.println(result);  // 받아온 데이터를 확인해봅니다.
//            }
//           
//             // Json parser를 만들어 만들어진 문자열 데이터를 객체화 합니다. 
//    		JsonParser parser = new JsonParser();
//    		JsonObject obj = (JsonObject) parser.parse(result);
//    		
//    		// Top레벨 단계인 response 키를 가지고 데이터를 파싱합니다.
//    		JsonObject parse_response = (JsonObject) obj.get("response");
//    		// response 로 부터 body 찾아옵니다.
//    		JsonObject parse_body = (JsonObject) parse_response.get("body");
//    		// body 로 부터 items 받아옵니다.
//    		JsonObject parse_items = (JsonObject) parse_body.get("items");
//    		
//    		// items로 부터 itemlist 를 받아오기 itemlist : 뒤에 [ 로 시작하므로 jsonarray이다
//    		JsonArray parse_item = (JsonArray) parse_items.get("item");
//    		
//    		String category;
//    		JsonObject weather; // parse_item은 배열형태이기 때문에 하나씩 데이터를 하나씩 가져올때 사용합니다.
//
//    		// 필요한 데이터만 가져오려고합니다.
//    		for(int i = 0 ; i < parse_item.size(); i++)
//    		{
//    			weather = (JsonObject) parse_item.get(i);
//    			//String base_Date = (String)weather.get("baseDate");
//    			//String fcst_Time = (String)weather.get("fcstDate");
//    			double fcst_Value = ((Long)weather.get("fcstValue")).doubleValue(); //실수로된 값과 정수로된 값이 둘다 있어서 실수로 통일했습니다.
//    			//String nX = (String)weather.get("nx");
//    			//String nY = (String)weather.get("ny");
//    			category = (String)weather.get("category");
//    			//String base_Time = (String)weather.get("baseTime");
//    			//String fcscDate = (String)weather.get("fcscDate");
//    			
//    			// 출력합니다.
//    			System.out.print("배열의 "+i+"번째 요소");
//    			System.out.print("   category : "+ category);
//    			System.out.print("   fcst_Value : "+ fcst_Value);
//    			System.out.println();
//    		}
//    		// 마지막에보면 에러가 발생하였는데 casting문제입니다. 
//    		// 이는 반환되는 데이터타입이 달라서인데 이번 글에서는 여기까지만하고
//    		// 데이터베이스에 입력할때는 수정해서 하겠습니다.
//    		
//
//            bf.close();
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//        }
//    }

	
	
	
	
//	@Autowired
//	private MemberService service;
//	
//	@Test
//	public void testExist() {
//		
//		// MemberService 객체가 제대로 주입이 가능한지 확인
//		log.info("서비스 "+service);
//		assertNotNull(service);
//	}
//
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
//	// 회원가입 - insert 처리 (SelectKey 사용)
//	@Test
//	public void testRegister() {
//		
//		MemberVO member = new MemberVO();
//		member.setMember_id("user2003");	// 존재하는 회원 id와 중복되지 않게 테스트
//		member.setMember_pass("1234");
//		member.setMember_name("홍길동");
//		member.setMember_gender("남");
//		member.setMember_birth(Date.valueOf("2010-12-25"));	// String을 Date로 변환
//		member.setMember_phone("010-1245-1231");
//		member.setMember_address("용인시");
//		member.setMember_mail("aaa123@mp3.com");
//		member.setMember_mailaccept("yes");	
//		
//		AuthVO auth = new AuthVO();
//		auth.setMember_id("user2003");
//		auth.setMember_auth("ROLE_USER");
//		
//		service.register(member, auth);
//		
//		log.info("생성된 회원번호: "+member.getMember_no());
//		log.info("생성된 회원정보: "+member);
//		log.info("생성된 회원권한: "+auth);
//	}
//	
//    //아이디 중복체크
//	@Test
//	public void testCheckId() {
//		
//		// 존재하는 회원ID로 테스트
//		MemberVO member = new MemberVO();
//		member.setMember_id("admin90");
//
//		log.info("아이디 중복체크 결과: "+service.checkId(member));
//		// 중복ID가 없으면 0, 있으면 1 반환
//	}
//	
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
