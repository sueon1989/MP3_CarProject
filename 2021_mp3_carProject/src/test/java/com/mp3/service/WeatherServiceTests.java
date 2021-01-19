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

// �����: kim
@RunWith(SpringJUnit4ClassRunner.class)	// ���� �׽�Ʈ �ڵ尡 �������� �����ϴ� ������ �� ��
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class WeatherServiceTests {
	
	@Autowired
	private WeatherService service;
	
	@Test
	public void weatherReadTest() {
		
		// �������������� API ����
		String serviceKey = "#";
		String baseDate = "20210115"; // �ڽ��� ��ȸ�ϰ���� ��¥�� �Է����ּ���
        String baseTime = "0500"; //�ڽ��� ��ȸ�ϰ���� �ð��븦 �Է����ּ���
		String nx = "126";  //�浵
        String ny = "37";   //����
        
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
	        // apiURL�� �̿��ؼ� URL ��ü ����
	        URL url = new URL(apiURL); 
	        BufferedReader bf;
	        String line = "";
	        String result="";
        
        	//���� ������ �޾ƿɴϴ�.
        	bf = new BufferedReader(new InputStreamReader(url.openStream()));

        	//���ۿ� �ִ� ������ �ϳ��� ���ڿ��� ��ȯ.
        	while((line=bf.readLine())!=null){
            	result=result.concat(line);
            	System.out.println("��������: "+result);  // �޾ƿ� �����͸� Ȯ���غ��ϴ�.
        	}
     
        	// Json parser�� ����� ������� ���ڿ� �����͸� ��üȭ �մϴ�. 
        	JsonParser parser = new JsonParser();
        	JsonObject obj = (JsonObject) parser.parse(result);
		
        	// Top���� �ܰ��� response Ű�� ������ �����͸� �Ľ��մϴ�.
        	JsonObject parse_response = (JsonObject) obj.get("response");
        	// response �� ���� body ã�ƿɴϴ�.
        	JsonObject parse_body = (JsonObject) parse_response.get("body");
        	// body �� ���� items �޾ƿɴϴ�.
        	JsonObject parse_items = (JsonObject) parse_body.get("items");
		
        	// items�� ���� itemlist �� �޾ƿ��� itemlist : �ڿ� [ �� �����ϹǷ� jsonarray�̴�
        	JsonArray parse_item = (JsonArray) parse_items.get("item");
		
        	String category;
        	JsonObject weather; // parse_item�� �迭�����̱� ������ �ϳ��� �����͸� �ϳ��� �����ö� ����մϴ�.

        	// �ʿ��� �����͸� �����������մϴ�.
        	for(int i = 0 ; i < parse_item.size(); i++) {
				weather = (JsonObject) parse_item.get(i);
				System.out.println(i+"��° �����Ͱ�: "+weather);
				//String base_Date = weather.get(baseDate);
				//String base_Date = (String)weather.get("baseDate");
				//String fcst_Time = (String)weather.get("fcstDate");
//				double fcst_Value = ((Long)weather.get("fcstValue")).doubleValue(); //�Ǽ��ε� ���� �����ε� ���� �Ѵ� �־ �Ǽ��� �����߽��ϴ�.
				//String nX = (String)weather.get("nx");
				//String nY = (String)weather.get("ny");
//				category = (String)weather.get("category");
				//String base_Time = (String)weather.get("baseTime");
				//String fcscDate = (String)weather.get("fcscDate");
				
				// ����մϴ�.
//				System.out.print("�迭�� "+i+"��° ���");
//				System.out.print("   category : "+ category);
//				System.out.print("   fcst_Value : "+ fcst_Value);
//				System.out.println();
			}
			// ������������ ������ �߻��Ͽ��µ� casting�����Դϴ�. 
			// �̴� ��ȯ�Ǵ� ������Ÿ���� �޶��ε� �̹� �ۿ����� ����������ϰ�
			// �����ͺ��̽��� �Է��Ҷ��� �����ؼ� �ϰڽ��ϴ�.
		
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
//      // API �����ͷκ��� ���� JSON�� �Ľ��ϱ�
//      // (JSONParser ���̺귯�� ���: �Ľ��� �����͸� JSONObject�� ��ȯ�Ͽ� ���) 
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
//      // �Ľ��� �����͸� ������ Ŭ���� ��ü�� ���� ����Ʈ�� ���
//      List < WeatherVO > list = null;
//      list = new ArrayList<WeatherVO>();
	}
	
	
//	@Test
//    public void weatherTest() {
//        try{
//        	/*��û�����Է�
//        	 * �Ʒ��� ���� �������� ����� ���̵带 Ȯ���Ͽ� ã���ֽø� �˴ϴ�.
//        	 * ���� �浵�� �������� �ȿ� �ֽ��ϴ�.
//        	 * */
//        	
//            // ��ȸ�� ���ϴ� ������ �浵�� ������ �Է� (�����ñǼ��� ��)
//            String nx = "126";  //�浵
//            String ny = "37";   //����
//            String baseDate = "20180502"; // �ڽ��� ��ȸ�ϰ���� ��¥�� �Է����ּ���
//            String baseTime = "0500"; //�ڽ��� ��ȸ�ϰ���� �ð��븦 �Է����ּ���
//            // ���� ����Ű�Դϴ�. �������������п��� �������� ����Ű�� �־��ֽø� �˴ϴ�.
//            String serviceKey = "���κ��� ���� ����Ű�� �־��ּ���";
//            
//            // ������ ��Ƽ� URL������ �����˴ϴ�. �� ������ "&_type=json"�� ���� ��ȯ �������� ���°� �������ϴ�.
//            String urlStr = "http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService2/ForecastSpaceData?"
//            		+ "serviceKey=" + serviceKey + "&base_date=" + baseDate + "&base_time=" + baseTime
//            		+ "&nx="+ nx + "&ny=" + ny + "&_type=json";
//            URL url = new URL(urlStr); // �� urlStr�� �̿��ؼ� URL ��ü�� ������ݴϴ�.
//            BufferedReader bf;
//            String line = "";
//            String result="";
//
//            //���� ������ �޾ƿɴϴ�.
//            bf = new BufferedReader(new InputStreamReader(url.openStream()));
//
//            //���ۿ� �ִ� ������ �ϳ��� ���ڿ��� ��ȯ.
//            while((line=bf.readLine())!=null){
//                result=result.concat(line);
//               // System.out.println(result);  // �޾ƿ� �����͸� Ȯ���غ��ϴ�.
//            }
//           
//             // Json parser�� ����� ������� ���ڿ� �����͸� ��üȭ �մϴ�. 
//    		JsonParser parser = new JsonParser();
//    		JsonObject obj = (JsonObject) parser.parse(result);
//    		
//    		// Top���� �ܰ��� response Ű�� ������ �����͸� �Ľ��մϴ�.
//    		JsonObject parse_response = (JsonObject) obj.get("response");
//    		// response �� ���� body ã�ƿɴϴ�.
//    		JsonObject parse_body = (JsonObject) parse_response.get("body");
//    		// body �� ���� items �޾ƿɴϴ�.
//    		JsonObject parse_items = (JsonObject) parse_body.get("items");
//    		
//    		// items�� ���� itemlist �� �޾ƿ��� itemlist : �ڿ� [ �� �����ϹǷ� jsonarray�̴�
//    		JsonArray parse_item = (JsonArray) parse_items.get("item");
//    		
//    		String category;
//    		JsonObject weather; // parse_item�� �迭�����̱� ������ �ϳ��� �����͸� �ϳ��� �����ö� ����մϴ�.
//
//    		// �ʿ��� �����͸� �����������մϴ�.
//    		for(int i = 0 ; i < parse_item.size(); i++)
//    		{
//    			weather = (JsonObject) parse_item.get(i);
//    			//String base_Date = (String)weather.get("baseDate");
//    			//String fcst_Time = (String)weather.get("fcstDate");
//    			double fcst_Value = ((Long)weather.get("fcstValue")).doubleValue(); //�Ǽ��ε� ���� �����ε� ���� �Ѵ� �־ �Ǽ��� �����߽��ϴ�.
//    			//String nX = (String)weather.get("nx");
//    			//String nY = (String)weather.get("ny");
//    			category = (String)weather.get("category");
//    			//String base_Time = (String)weather.get("baseTime");
//    			//String fcscDate = (String)weather.get("fcscDate");
//    			
//    			// ����մϴ�.
//    			System.out.print("�迭�� "+i+"��° ���");
//    			System.out.print("   category : "+ category);
//    			System.out.print("   fcst_Value : "+ fcst_Value);
//    			System.out.println();
//    		}
//    		// ������������ ������ �߻��Ͽ��µ� casting�����Դϴ�. 
//    		// �̴� ��ȯ�Ǵ� ������Ÿ���� �޶��ε� �̹� �ۿ����� ����������ϰ�
//    		// �����ͺ��̽��� �Է��Ҷ��� �����ؼ� �ϰڽ��ϴ�.
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
//		// MemberService ��ü�� ����� ������ �������� Ȯ��
//		log.info("���� "+service);
//		assertNotNull(service);
//	}
//
//	// ���(����Ʈ)
//	@Test
//	public void testGetList() {
//		
//		List<MemberVO> memberList = service.getList();
//		for(MemberVO member: memberList) {
//			log.info(member);
//		}
//		
//		// ���ٽ����� ǥ�� (���� ���)
//		// service.getList().forEach(member -> log.info(member));
//	}
//	
//	// ȸ������ - insert ó�� (SelectKey ���)
//	@Test
//	public void testRegister() {
//		
//		MemberVO member = new MemberVO();
//		member.setMember_id("user2003");	// �����ϴ� ȸ�� id�� �ߺ����� �ʰ� �׽�Ʈ
//		member.setMember_pass("1234");
//		member.setMember_name("ȫ�浿");
//		member.setMember_gender("��");
//		member.setMember_birth(Date.valueOf("2010-12-25"));	// String�� Date�� ��ȯ
//		member.setMember_phone("010-1245-1231");
//		member.setMember_address("���ν�");
//		member.setMember_mail("aaa123@mp3.com");
//		member.setMember_mailaccept("yes");	
//		
//		AuthVO auth = new AuthVO();
//		auth.setMember_id("user2003");
//		auth.setMember_auth("ROLE_USER");
//		
//		service.register(member, auth);
//		
//		log.info("������ ȸ����ȣ: "+member.getMember_no());
//		log.info("������ ȸ������: "+member);
//		log.info("������ ȸ������: "+auth);
//	}
//	
//    //���̵� �ߺ�üũ
//	@Test
//	public void testCheckId() {
//		
//		// �����ϴ� ȸ��ID�� �׽�Ʈ
//		MemberVO member = new MemberVO();
//		member.setMember_id("admin90");
//
//		log.info("���̵� �ߺ�üũ ���: "+service.checkId(member));
//		// �ߺ�ID�� ������ 0, ������ 1 ��ȯ
//	}
//	
//	
//	// ��ȸ (�� ��) - read (select) ó��
//	@Test
//	public void testGet() {
//		
//		// �����ϴ� ȸ�� ��ȣ�� �׽�Ʈ
//		log.info("��ȸ ���: "+ service.get("user2003"));
//	}
//	
////	���� - delete ó��
//	@Test
//	public void testDelete() {
//		
//		// �����ϴ� ȸ�� ��ȣ�� �׽�Ʈ
//		log.info("���� DELETE ���: "+ service.remove(102L));
//	}
//	
////	���� - update ó��
//	@Test
//	public void testUpdate() {
//		
//		// Ư���� ȸ���� ���� ��ȸ
//		MemberVO member = service.get("user12");
//
//		// �����ϴ� ȸ�� ��ȣ�� �׽�Ʈ
//		member.setMember_no(1L);
//		member.setMember_id("user12");
//		member.setMember_pass("1234");
//		member.setMember_name("ȫ�浿1");
//		member.setMember_gender("��");
//		member.setMember_birth(Date.valueOf("2010-12-25"));	// String�� Date�� ��ȯ
//		member.setMember_phone("010-1245-1231");
//		member.setMember_address("���ν�");
//		member.setMember_mail("12aaa@mp3.com");
//		member.setMember_mailaccept("yes");	
//		
//		log.info("���� UPDATE ���: "+ service.modify(member));
//		log.info(member);
//	}
	
	
}
