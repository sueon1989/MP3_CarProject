//package com.mp3.service;

//import java.util.List;

//import org.springframework.stereotype.Service;

//import com.mp3.domain.WeatherVO;
//import com.mp3.mapper.WeatherMapper;

//import lombok.AllArgsConstructor;
//import lombok.extern.log4j.Log4j;

//@Log4j
//@Service
//@AllArgsConstructor
//public class WeatherServiceImpl implements WeatherService {
	
//	@Autowired
//	���� �Ķ���͸� �޴� �������� ���, �ʿ��� �Ķ���͸� �ڵ����� ����
	//private WeatherMapper mapper;

	//@Override
	//public WeatherVO get(String baseDate, String baseTime, String nx, String ny) {
		// TODO Auto-generated method stub
		//log.info("��ȸ......"+baseDate);
		
		
		
		//return mapper.read(baseDate, baseTime, nx, ny);
//	}

	

//
//	// ��ȸ (�� ��) - read (select) ó��
//	@Override
//	public MemberVO get(String userid) {
//		
//		log.info("��ȸ......"+userid);
//		return mapper.read(userid);
//	}
	
//	// ���(����Ʈ)
//	@Override
//	public List<MemberVO> getList() {
//		
//		log.info("���(����Ʈ)......");
//		return mapper.getList();
//	}
//
//	// ��� - insert ó�� (SelectKey ���)
//	@Override
//	public boolean register(MemberVO member, AuthVO auth) {
//		log.info("ȸ�����......"+member);
//		
//		boolean register_member = mapper.insertSelectKey(member) == 1;
//		boolean register_auth = mapper.insertAuth(auth) == 1;
//		
//		if (register_member == true && register_auth == true) {
//			return true;
//		} else {
//			return false;
//		}
//	}
//}
