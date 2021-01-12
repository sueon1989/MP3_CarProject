package com.mp3.mapper;

import java.util.List;

import com.mp3.domain.AuthVO;
import com.mp3.domain.MemberVO;

//�����: kim
public interface MemberMapper {

	// ȸ�� ���
	//@Select("select * from member where member_no>0")
    public List<MemberVO> getList();
    
    // ȸ�� ��ȸ (�� ��) - read (select) ó��
    // MemberVO, AuthVO �ѹ��� ó��
    public MemberVO read(String userid);

	//ȸ�� ��ȸ (�� ��) - read (select) ó��
//  public MemberVO read(Long member_no);	// ��ü Ÿ������ �־��־�� �� (long�� �ƴ� Long)
    public MemberVO readMember(Long member_no);
    
	//ȸ�� ���� ��ȸ (�� ��) - read (select) ó��
//	public AuthVO readAuth(Long member_no);
	public AuthVO readAuth(String userid);
	
    //���̵� �ߺ�üũ
	public int checkId(MemberVO member);
	
    // ȸ�� ��� - insert ó��
	public int insert(MemberVO member);
	
	// ȸ�� ���2 - @SelectKey ��� (�ڵ����� �߰��Ǵ� PK �� Ȯ��)
	public int insertSelectKey(MemberVO member);

	// ȸ�� ���� ��� - insert ó��
	public int insertAuth(AuthVO auth);
		
	// ȸ�� ���� - delete ó��
	public int delete(Long member_no);

	// ȸ�� ���� - update ó��
	public int update(MemberVO member);
	
	// ���� test
	public MemberVO test(String member_name, String member_mail);


}
