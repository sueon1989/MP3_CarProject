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
	


	// �� ���� ���� Service
	@Override
	public MemberVO myInfoRead(Long member_no) {

		MemberVO memberVO = mapper.myInfoRead(member_no);
		log.info("���������� ������ �󼼺���");
		return memberVO;
	}
	
	//�� �� ���� ���� Service
	@Override
	public CarVO myInfoCar(Long car_no) {
		CarVO car = mapper.myInfoCar(car_no);
		log.info("���������� �� ���� ���� �󼼺���");
		return car;
	}
	
	
	//����ڰ� �Է��� ��й�ȣ memberVO�� �����ϱ�
	@Override
	public MemberVO DeleteNum(String deletenum) {
		MemberVO member = new MemberVO();
		log.info(member.getMember_pass_user()+"�̰� ����ڰ� �Է��� ��й�ȣ ��ȣȭ�Ǽ� ����Ȱ��� Ȯ��");
		return member;
	}

	// �� ���� Ż�� Service
	@Override
	public boolean myInfoDeletePassCheck(Long member_no,String Deletenum,String Deletenum1) {
		MemberVO member = new MemberVO();
		log.info(member_no + "ȸ�� Ż�� ��û�� ȸ�� ��ȣ");
		member.setMember_pass(Deletenum1);
		member.setMember_no(member_no);
		log.info("��� �ѹ� "+member_no);
		log.info("���� ��й�ȣ "+member.getMember_pass());
		log.info("�Է� ��й�ȣ "+member.getMember_pass_user());
	
		boolean myInfoDelete_auth = mapper.myInfoDelete_auth(member_no) == 1;
		boolean myInfoDelete_member = mapper.myInfoDelete_member(member_no) == 1;
		if (myInfoDelete_auth == true && myInfoDelete_member == true) {		
			return true;
		} else {
			return false;
		}
	}

	// ���������� �� ���� ����
	@Override
	public boolean myInfoUpdatePassCheck(MemberVO member) {
		mapper.myInfoUpdatePassCheck(member);
		log.info("���������� �� ���� ����"+member);
		return mapper.myInfoUpdatePassCheck(member) == 1;	
		
	}

	
	
	
	// �� ���� Ż��� ��й�ȣ Ȯ��
	@Override
	public boolean myInfoDeleteFinished(Long member_no) {
		MemberVO member = new MemberVO();
		if (member.getMember_pass_user().equals(member.getMember_pass())) {
			log.info("���� ȭ�� : ��й�ȣ Ȯ�� ���� !!");
			return true;
		} else {
			log.info("���� ȭ�� : ��й�ȣ Ȯ�� ���� !!");
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
		String result = "����";
		String pw = "$2a$10$dZAzGOxPMPyxm7YRVDkS/eSL7HIIlWumniiDDJ/LS694jPHu6naKe";
		String pw1= "1234";
		if(mapper.passID(member_id).equals((member.getMember_pass()))) {
			result= "����";
			return result;
		}
			return result;
	}

	@Override
	public void gps(String Latitude, String Longitude) {
		GpsVO gps = new GpsVO();
		gps.setLatitude(Latitude);
		gps.setLongitude(Longitude);
		log.info("���� Ȯ�� �α�����"+Latitude+"**********"+Longitude);
		log.info("VO gps Ȯ�� �α�����"+gps.getLatitude());
		log.info("VO gps Ȯ�� �α�����"+gps.getLongitude());
		log.info("���� Ȯ�οϷ� �α�����"+Latitude+"**********"+Longitude);
		mapper.gps(Latitude, Longitude);
	}

	@Override
	public GpsVO mapView(String Latitude, String Longitude) {
		GpsVO gps = new GpsVO(); 
		log.info(gps+"****gpsVO��");
		mapper.mapView(gps.getLatitude(),gps.getLongitude());
		log.info("�ֱ� gps �󼼺���");
		return gps;
	}
}







