package DAO_DTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import jdbc.JdbcUtil;

public class LibDBBean {

	private  static LibDBBean instance = new LibDBBean();
	
	public static LibDBBean getInstance(){
		return instance;
	}
	
	private Connection getConnection() throws Exception{
		String jdbcDriver="jdbc:apache:commons:dbcp:/pool";
		return DriverManager.getConnection(jdbcDriver);
	}
	
	//산,공원 구명에 맞춰서 가져오기 
	public Vector getTour(String gu_nm) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Vector vt = null;
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from tourism_list where gu_nm="+gu_nm);
			rs = pstmt.executeQuery();
			if(rs.next()){
				vt = new Vector();
				do{
				Tourism_ListDataBean tldb = new Tourism_ListDataBean();
				tldb.setPark_nm(rs.getString("park_nm"));
				tldb.setPark_se(rs.getString("park_se"));
				tldb.setAdres(rs.getString("adres"));
				tldb.setTel(rs.getString("tel"));
				tldb.setGu_nm(rs.getString("gu_nm"));
				tldb.setAddr_rd_nm(rs.getString("addr_rd_nm"));
				
				vt.add(tldb);
				} while(rs.next());
	
			}
			
		} catch(Exception ex){
			ex.printStackTrace();
		} finally{
			JdbcUtil.close(conn);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(rs);
		}
		return vt;
	}
	
	
	
	
	
	
}
