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
/*	
	//id찾占쏙옙
	public String searchId(String name, String email) throws Exception {
		return;
	}
	
	//占쏙옙橘占싫Ｃｏ옙占�
	public String searchPwd(String id, String name, String email) throws Exception {
		return;
	}
	
	//占쏙옙橘占싫Ｃｏ옙占�-占쌈시븝옙橘占싫�
	public int updatePwd(String id, String pwd) throws Exception {
		return;
	}
	
	//회占쏙옙占쏙옙占쏙옙-占쏙옙占쏙옙
	public void insertMember(LogonDataBean member, PetcDataBean petc, KidDataBean kid) throws Exception {
		
	}
	
	//회占쏙옙占쏙옙占쏙옙-占쏙옙占�
	public void insertMember(LogondataBean member, KetcDataBean ketc) throws Exception {
		
	}
	
	//占싸깍옙占싸시듸옙
	public int userCheck(String id, String pwd) throws Exception{
		return;
	}
	
	//id占쌩븝옙확占쏙옙
	public int cnfirmId(String id) throws Exception{
		return;
	}
	
	//회占쏙옙占쏙옙占쏙옙占싫�
	public Vector getMember(String id) throws Exception{
		return;
	}
	
	//회占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙
	public int updateMember(LogonDataBean member) throws Exception{
		return;
	}
	
	//占쏙옙占쏙옙占싫쏙옙占�
	public int updateYellowcard(String id) throws Exception{
		return;
	}
	
	//회占쏙옙占쏙옙占쏙옙占쏙옙 탈占쏙옙
	public int deleteMember(String id, String pwd, String del_reason) throws Exception{
		return;
	}
	
	//占쏙옙占쏙옙탈占쏙옙
	public int deleteMember(String id, String del_reason) throws Exception{
		return;
	}
	//占쏙옙占쌘듸옙 占쌀뤄옙占쏙옙占쏙옙
	public Vector zipcodeRead(String area4) throws Exception {
		return;
	}*/

	
	public KetcDataBean kindRead(String id)throws Exception{
		Connection conn =null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		KetcDataBean ketc= null;
		try{
			conn=getConnection();
			pstmt=conn.prepareStatement("select schul_nm,schul_num from k_etc where id=?");
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()){
				ketc=new KetcDataBean();  
				ketc.setSchul_num(rs.getInt("schul_num"));
				ketc.setSchul_nm(rs.getString("schul_nm"));
				}
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
				JdbcUtil.close(conn);
			}
		return ketc;	
	}
		

}
