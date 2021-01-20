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
//	단일 파라미터를 받는 생성자의 경우, 필요한 파라미터를 자동으로 주입
	//private WeatherMapper mapper;

	//@Override
	//public WeatherVO get(String baseDate, String baseTime, String nx, String ny) {
		// TODO Auto-generated method stub
		//log.info("조회......"+baseDate);
		
		
		
		//return mapper.read(baseDate, baseTime, nx, ny);
//	}

	

//
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
//
//	// 등록 - insert 처리 (SelectKey 사용)
//	@Override
//	public boolean register(MemberVO member, AuthVO auth) {
//		log.info("회원등록......"+member);
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
