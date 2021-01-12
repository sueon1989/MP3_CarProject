package com.mp3.security;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)	// 현재 테스트 코드가 스프링을 실행하는 역할을 할 것
@ContextConfiguration({
	  "file:src/main/webapp/WEB-INF/spring/root-context.xml",
	  "file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
public class MemberTests {

	  @Setter(onMethod_ = @Autowired)
	  private PasswordEncoder pwencoder;
	  
	  @Setter(onMethod_ = @Autowired)
	  private DataSource ds;
	  
	  
	  // (최초1회 실행) MEMBER 테이블 샘플데이터 100개 삽입
	  @Test
	  public void testInsertMember() {

	    String sql = 
	    "INSERT INTO MEMBER (MEMBER_NO, "
	    + "MEMBER_ID, MEMBER_PASS, MEMBER_NAME, MEMBER_GENDER, MEMBER_BIRTH, MEMBER_PHONE, MEMBER_ADDRESS, MEMBER_MAIL, MEMBER_MAILACCEPT) "
	    + "VALUES (seq_member.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    for(int i = 1; i <= 100; i++) {
	      
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      
	      try {
	        con = ds.getConnection();
	        pstmt = con.prepareStatement(sql);	
	        
	        pstmt.setString(2, pwencoder.encode("pw"+i));	// MEMBER_PASS
	        
	        if(i <80) {
	          pstmt.setString(1, "user"+i);			// MEMBER_ID
	          pstmt.setString(3, "사용자"+i);		// MEMBER_NAME
	          pstmt.setString(4, "남");				// MEMBER_GENDER
	          pstmt.setString(5, "2020-12-14");		// MEMBER_BIRTH
	          pstmt.setString(6, "010-1234-5678");	// MEMBER_PHONE
	          pstmt.setString(7, "수원시");			// MEMBER_ADDRESS
	          pstmt.setString(8, "test@mp3.com");	// MEMBER_MAIL
	          pstmt.setString(9, "yes");			// MEMBER_MAILACCEPT
	          
	        }else if (i <90) {
	          pstmt.setString(1, "manager"+i);
	          pstmt.setString(3,"운영자"+i);
	          pstmt.setString(4, "여");				// MEMBER_GENDER
	          pstmt.setString(5, "2020-12-14");		// MEMBER_BIRTH
	          pstmt.setString(6, "010-1234-5678");	// MEMBER_PHONE
	          pstmt.setString(7, "수원시");			// MEMBER_ADDRESS
	          pstmt.setString(8, "test@mp3.com");	// MEMBER_MAIL
	          pstmt.setString(9, "yes");			// MEMBER_MAILACCEPT
	          
	        }else {
	          pstmt.setString(1, "admin"+i);
	          pstmt.setString(3,"관리자"+i);
	          pstmt.setString(4, "남");				// MEMBER_GENDER
	          pstmt.setString(5, "2020-12-14");		// MEMBER_BIRTH
	          pstmt.setString(6, "010-1234-5678");	// MEMBER_PHONE
	          pstmt.setString(7, "수원시");			// MEMBER_ADDRESS
	          pstmt.setString(8, "test@mp3.com");	// MEMBER_MAIL
	          pstmt.setString(9, "yes");			// MEMBER_MAILACCEPT
	        }
	        pstmt.executeUpdate();
	        
	      }catch(Exception e) {
	        e.printStackTrace();
	      }finally {
	        if(pstmt != null) 	{ try { pstmt.close();  } catch(Exception e) {} }
	        if(con != null) 	{ try { con.close();  	} catch(Exception e) {} }
	        
	      }
	    }//end for
	  }
	  
	  
	// (최초1회 실행) MEMBER_AUTH 테이블 샘플데이터 100개 삽입
	  @Test
	  public void testInsertAuth() {
	    
	    String sql = "INSERT INTO MEMBER_AUTH (MEMBER_ID, MEMBER_AUTH) values (?,?)";
	    for(int i = 1; i <= 100; i++) {
	      
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      
	      try {
	        con = ds.getConnection();
	        pstmt = con.prepareStatement(sql);
	      
	        
	        if(i <80) {
	          
	          pstmt.setString(1, "user"+i);
	          pstmt.setString(2,"ROLE_USER");
	          
	        }else if (i <90) {
	          
	          pstmt.setString(1, "manager"+i);
	          pstmt.setString(2,"ROLE_MEMBER");
	          
	        }else {
	          
	          pstmt.setString(1, "admin"+i);
	          pstmt.setString(2,"ROLE_ADMIN");
	          
	        }
	        
	        pstmt.executeUpdate();
	        
	      }catch(Exception e) {
	        e.printStackTrace();
	      }finally {
	        if(pstmt != null) { try { pstmt.close();  } catch(Exception e) {} }
	        if(con != null) { try { con.close();  } catch(Exception e) {} }
	        
	      }
	    }//end for
	  }
}
