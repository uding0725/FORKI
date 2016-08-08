package DAO_DTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import jdbc.JdbcUtil;

public class KiderDBBean {

	private static KiderDBBean instance= new KiderDBBean();
	
	public static KiderDBBean getInstance(){
		return instance;
	}
	
	private KiderDBBean(){}
	
	private Connection getConnection()throws Exception{
		String jdbcDriver="jdbc:apache:commons:dbcp:/pool";
		return DriverManager.getConnection(jdbcDriver);
	}
	//유치원 유치원명선택
	public Vector selectKid(String matr_gu, String schul_nm)throws Exception{
		
	}
	//유치원 동선택
	public Vector selectKid(String matr_gu,String dong)throws Exception{
		
	}
	//main에서 지도 클릭시 
	public Vector selectKid(String matr_gu)throws Exception{
		
	}
	//유치원 상세보기
	public KiderDataBean selectDetKid(String schul_nm)throws Exception{
	}
	//유치원 등록
	public void insertKid(KiderDataBean kidmember)throws Exception{
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try{
			con=getConnection();
			pstmt=con.prepareStatement("insert into kidergarten values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			pstmt.setString(1,kidmember.getSchul_nm());
			pstmt.setInt(2, kidmember.getSchul_num());
			pstmt.setString(3, kidmember.getOfcdc());
			pstmt.setString(4, kidmember.getMatr_gu());
			pstmt.setString(5, kidmember.getDong());
			pstmt.setString(6, kidmember.getFond());
			pstmt.setString(7,kidmember.getTelno());
			pstmt.setString(8,kidmember.getZip());
			pstmt.setString(9, kidmember.getAdres());
			pstmt.setInt(10, kidmember.getStdnt_co_sm());
			pstmt.setInt(11, kidmember.getGrlstdn_co());
			pstmt.setInt(12, kidmember.getClas_co());
			pstmt.setInt(13,kidmember.getFrl_tcher_co_sm());
			pstmt.setInt(14, kidmember.getFrl_female_tcher_c());
			pstmt.setString(15, kidmember.getRm());
			pstmt.setString(16, kidmember.getState());
			pstmt.setTimestamp(17, kidmember.getReg_date());
			
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(pstmt);
			JdbcUtil.close(con);
		}
	}
	//유치원 등록(추가)
	public Vector signKinder()throws Exception{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Vector vecList=new Vector();
		try{
			conn=getConnection();
			pstmt=conn.prepareStatement("select schul_nm,schul_num,reg_date from kindergarten where state='n'");
			rs=pstmt.executeQuery();
			while(rs.next()){
				KiderDataBean tempkdb=new KiderDataBean();
				tempkdb.setSchul_nm(rs.getString("schul_nm"));
				tempkdb.setSchul_num(rs.getInt("schul_num"));
				tempkdb.setReg_date(rs.getTimestamp("reg_date"));
				vecList.addElement(tempkdb);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(pstmt);
			JdbcUtil.close(rs);
			JdbcUtil.close(conn);
		}
		return vecList;
	}
}
