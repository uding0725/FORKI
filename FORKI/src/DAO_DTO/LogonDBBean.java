package DAO_DTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import jdbc.JdbcUtil;

public class LogonDBBean {

	public static LogonDBBean instance = new LogonDBBean();
	
	public static LogonDBBean getInstance(){
		return instance;
	}
	
	private Connection getConnection() throws Exception{
		String jdbcDriver = "jdbc:apache:commons:dbcp:/pool";
		return DriverManager.getConnection(jdbcDriver);
	}
	
	//id찾기
	public String searchId(String name, String email) throws Exception {
		return;
	}
	
	//비밀번호찾기
	public String searchPwd(String id, String name, String email) throws Exception {
		return;
	}
	
	//비밀번호찾기-임시비밀번호
	public int updatePwd(String id, String pwd) throws Exception {
		return;
	}
	
	//회원가입-개인
	public void insertMember(LogonDataBean member, PetcDataBean petc, KidDataBean kid) throws Exception {
		
	}
	
	//회원가입-기업
	public void insertMember(LogondataBean member, KetcDataBean ketc) throws Exception {
		
	}
	
	//로그인시도
	public int userCheck(String id, String pwd) throws Exception{
		return;
	}
	
	//id중복확인
	public int cnfirmId(String id) throws Exception{
		return;
	}
	
	//회원목록조회
	public Vector getMember(String id) throws Exception{
		return;
	}
	
	//회원정보수정
	public int updateMember(LogonDataBean member) throws Exception{
		return;
	}
	
	//경고누적횟수
	public int updateYellowcard(String id) throws Exception{
		return;
	}
	
	//회원스스로 탈퇴
	public int deleteMember(String id, String pwd, String del_reason) throws Exception{
		return;
	}
	
	//강제탈퇴
	public int deleteMember(String id, String del_reason) throws Exception{
		return;
	}
	//집코드 불러오기
	public Vector zipcodeRead(String area4) throws Exception {
		return;
	}

	//유치원등록신청 화면 - ID를 가지고 오는 부분(추가)
		public String findId(int schul_num)throws Exception{
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			String memId="";
			try{
				conn=getConnection();
				pstmt=conn.prepareStatement("select id from k_etc where schul_num=?");
				pstmt.setInt(1,schul_num);
				
				rs=pstmt.executeQuery();
				if(rs.next()){
					memId=rs.getString("id");
				}
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
				JdbcUtil.close(conn);
			}
			return memId;
		}
}
