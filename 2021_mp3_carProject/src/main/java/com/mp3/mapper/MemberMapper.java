package com.mp3.mapper;

import java.util.List;

import com.mp3.domain.AuthVO;
import com.mp3.domain.MemberVO;

//담당자: kim
public interface MemberMapper {

	// 회원 목록
	//@Select("select * from member where member_no>0")
    public List<MemberVO> getList();
    
    // 회원 조회 (한 행) - read (select) 처리
    // MemberVO, AuthVO 한번에 처리
    public MemberVO read(String userid);

	//회원 조회 (한 행) - read (select) 처리
//  public MemberVO read(Long member_no);	// 객체 타입으로 넣어주어야 함 (long이 아닌 Long)
    public MemberVO readMember(Long member_no);
    
	//회원 권한 조회 (한 행) - read (select) 처리
//	public AuthVO readAuth(Long member_no);
	public AuthVO readAuth(String userid);
	
    //아이디 중복체크
	public int checkId(MemberVO member);
	
    // 회원 등록 - insert 처리
	public int insert(MemberVO member);
	
	// 회원 등록2 - @SelectKey 사용 (자동으로 추가되는 PK 값 확인)
	public int insertSelectKey(MemberVO member);

	// 회원 권한 등록 - insert 처리
	public int insertAuth(AuthVO auth);
		
	// 회원 삭제 - delete 처리
	public int delete(Long member_no);

	// 회원 수정 - update 처리
	public int update(MemberVO member);
	
	// 준택 test
	public MemberVO test(String member_name, String member_mail);


}
