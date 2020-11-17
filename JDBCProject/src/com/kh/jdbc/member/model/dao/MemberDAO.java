package com.kh.jdbc.member.model.dao;

import static com.kh.jdbc.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.kh.jdbc.member.model.vo.Member;

/**
 * DAO (Data Access Object) :
 *        Service로 부터 받은 정보를 실제 데이터베이스에 전달하고,
 *        해당 SQL을 실행한 결과를 받아오는 '객체' (CRUD를 실행)

 * @author JinYoung
 */
public class MemberDAO {
	
	// 회원 조회 (아이디, 비밀번호)
	public Member selectMember(Connection con, Member m) {
		// 1. SQL 실행에 사용할 변수 선언
		Member result = null;         // 결과 담을 객체
		Statement stmt = null;       // SQL 정보를 담을 객체
		ResultSet rset = null;         // select한 결과를 받아올 객체
		String sql = "SELECT * FROM MEMBER "
				       + " WHERE USERID = '" + m.getUserId() + "' " 
				       + " AND PASSWORD = '" + m.getUserPwd() + "' ";
		
		// 쿼리 확인용
		//System.out.println(sql);
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) { // 데이터베이스에서 머릿글부터 가져오기 때문에
				// 무조건 next()로 비교하고 시작한다.
				result = new Member();
				
				result.setUserId(m.getUserId());
				result.setUserPwd(m.getUserPwd());
				result.setUserName(rset.getString("username")); // 대소문자 상관 X
				result.setGender(rset.getString(4));
				result.setAge(rset.getInt("AGE"));
				result.setPhone(rset.getString("phone"));
				result.setAddress(rset.getString("address"));
				result.setEmail(rset.getString("email"));
				result.setHobby(rset.getString("hobby"));

			}
			
			System.out.println("조회 결과 확인 : " + result);
			
		} catch (SQLException e) {		
			e.printStackTrace();
			
		} finally {
			
			close(rset);
		    close(stmt);
		}
		
		return result;
	}

	public int insertMember(Connection con, Member joinMember) {
		
		// 결과 확인을 위한 변수 선언
		int result = 0;
		
		//Statement stmt = null;  // SQL 실행하러 가는 객체 
		PreparedStatement pstmt = null;
		
		/**
		 * Statement 객체는 SQL을 전부 완성한 뒤에 한번에 가는 방법이다. 
		 * 반면에 PreapredStatement 는 SQL을 대략적으로 '?' 기호를 활용해
		 * 형식만 만들어주고, 후에 ?의 순번에 해당하는 값을 채워 넣으면서 
		 * SQL을 실행하는 방식
		 */
		
		String sql 
		    = "INSERT INTO MEMBER "
		    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, DEFAULT)"; 
		          
		try {
			pstmt = con.prepareStatement(sql);
			
			// 데이터베이스는 숫자가 1부터 시작
			pstmt.setString(1, joinMember.getUserId());
			pstmt.setString(2, joinMember.getUserPwd());
			pstmt.setString(3, joinMember.getUserName());
			pstmt.setString(4, joinMember.getGender());
			pstmt.setInt(     5, joinMember.getAge());
			pstmt.setString(6, joinMember.getEmail());
			pstmt.setString(7, joinMember.getPhone());
			pstmt.setString(8, joinMember.getAddress());
			pstmt.setString(9, joinMember.getHobby());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			close(pstmt);
		}
		
		return result;
	}

	public int updateMember(Connection con, Member m) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		// 비밀번호, 성별, 나이, 이메일, 연락처, 주소, 취미 
		String sql = "UPDATE MEMBER" 
		               + " SET PASSWORD=?, GENDER=?, AGE=?, EMAIL=?, "
				       + " PHONE=?, ADDRESS=?, HOBBY=? "
		               + " WHERE USERID=?";
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString( 1, m.getUserPwd() );
			pstmt.setString( 2, m.getGender()   );
			pstmt.setInt(      3, m.getAge()        );
			pstmt.setString( 4, m.getEmail()      );
			pstmt.setString( 5,  m.getPhone()    );
			pstmt.setString( 6,  m.getAddress() );
			pstmt.setString( 7,  m.getHobby()   );
			pstmt.setString( 8,  m.getUserId()   );
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteMember(Connection con, String userId) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM MEMBER WHERE USERID = ?";
		
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}
