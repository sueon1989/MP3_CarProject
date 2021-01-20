package com.mp3.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.mp3.mapper.MypageMapper;
import com.mp3.service.MypageServiceImpl;
import com.mp3.domain.CarVO;
import com.mp3.domain.GpsVO;
import com.mp3.domain.MemberVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class MypageServiceImpl implements MypageService {

	private MypageMapper mapper;
	


	// 내 정보 보기 Service
	@Override
	public MemberVO myInfoRead(Long member_no) {

		MemberVO memberVO = mapper.myInfoRead(member_no);
		log.info("마이페이지 내정보 상세보기");
		return memberVO;
	}
	
	//내 차 정보 보기 Service
	@Override
	public CarVO myInfoCar(Long car_no) {
		CarVO car = mapper.myInfoCar(car_no);
		log.info("마이페이지 내 차량 정보 상세보기");
		return car;
	}
	
	
	//사용자가 입력한 비밀번호 memberVO에 저장하기
	@Override
	public MemberVO DeleteNum(String deletenum) {
		MemberVO member = new MemberVO();
		log.info(member.getMember_pass_user()+"이건 사용자가 입력한 비밀번호 암호화되서 저장된건지 확인");
		return member;
	}

	// 내 정보 탈퇴 Service
	@Override
	public boolean myInfoDeletePassCheck(Long member_no,String Deletenum,String Deletenum1) {
		MemberVO member = new MemberVO();
		log.info(member_no + "회원 탈퇴 요청된 회원 번호");
		member.setMember_pass(Deletenum1);
		member.setMember_no(member_no);
		log.info("멤버 넘버 "+member_no);
		log.info("기존 비밀번호 "+member.getMember_pass());
		log.info("입력 비밀번호 "+member.getMember_pass_user());
	
		boolean myInfoDelete_auth = mapper.myInfoDelete_auth(member_no) == 1;
		boolean myInfoDelete_member = mapper.myInfoDelete_member(member_no) == 1;
		if (myInfoDelete_auth == true && myInfoDelete_member == true) {		
			return true;
		} else {
			return false;
		}
	}

	// 마이페이지 내 정보 수정
	@Override
	public boolean myInfoUpdatePassCheck(MemberVO member) {
		mapper.myInfoUpdatePassCheck(member);
		log.info("마이페이지 내 정보 수정"+member);
		return mapper.myInfoUpdatePassCheck(member) == 1;	
		
	}

	
	
	
	// 내 정보 탈퇴시 비밀번호 확인
	@Override
	public boolean myInfoDeleteFinished(Long member_no) {
		MemberVO member = new MemberVO();
		if (member.getMember_pass_user().equals(member.getMember_pass())) {
			log.info("서비스 화면 : 비밀번호 확인 성공 !!");
			return true;
		} else {
			log.info("서비스 화면 : 비밀번호 확인 실패 !!");
			return false;
		}

	}

	@Override
	public int passChk(MemberVO member) {
		if(member.getMember_pass().equals(member.getMember_pass_user())) {
		int result = mapper.passChk(member);
		return result;
	}
		return 0;
	}

	@Override
	public String passID(String member_id) {
		MemberVO member = new MemberVO();
		member.setMember_id("user2021");
		member.setMember_pass("1234");
		member_id="user2021";
		String result = "실패";
		String pw = "$2a$10$dZAzGOxPMPyxm7YRVDkS/eSL7HIIlWumniiDDJ/LS694jPHu6naKe";
		String pw1= "1234";
		if(mapper.passID(member_id).equals((member.getMember_pass()))) {
			result= "성공";
			return result;
		}
			return result;
	}

	@Override
	public void gps(String Latitude, String Longitude) {
		GpsVO gps = new GpsVO();
		gps.setLatitude(Latitude);
		gps.setLongitude(Longitude);
		log.info("서비스 확인 로그인포"+Latitude+"**********"+Longitude);
		log.info("VO gps 확인 로그인포"+gps.getLatitude());
		log.info("VO gps 확인 로그인포"+gps.getLongitude());
		log.info("서비스 확인완료 로그인포"+Latitude+"**********"+Longitude);
		mapper.gps(Latitude, Longitude);
	}

	@Override
	public GpsVO mapView(String Latitude, String Longitude) {
		GpsVO gps = new GpsVO(); 
		log.info(gps+"****gpsVO값");
		mapper.mapView(gps.getLatitude(),gps.getLongitude());
		log.info("최근 gps 상세보기");
		return gps;
	}
}







