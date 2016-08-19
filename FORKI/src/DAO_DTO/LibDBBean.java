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
	
	//산,공원 가져오기
	//구지정안하고 전체일때 지정
	public Vector getTour(int gu_nm,String dong, String searchN) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Vector vt = null;
		
		String[] gu={"전체","강남구","강동구","강북구","강서구","관악구","광진구","구로구","금천구","노원구","도봉구","동대문구","동작구","마포구","서대문구","서초구","성동구","성북구","송파구","양천구","영등포구","용산구","은평구","종로구","중랑구","중구"};
		try{
			conn = getConnection();
			if(dong==null && searchN==null){
			pstmt = conn.prepareStatement("select * from tourism_list where gu_nm='"+gu[gu_nm]+"'");
			}
			else if(dong == null && searchN != null){
			pstmt = conn.prepareStatement("select * from tourism_list where gu_nm='"+gu[gu_nm]+"' and park_nm like '%"+searchN+"%'");	
			}
			else if(dong != null && searchN ==null){
			pstmt = conn.prepareStatement("select * from tourism_list where gu_nm='"+gu[gu_nm]+"' and adres like'%"+dong+"%'");	
			}
			else if(dong != null && searchN != null){
			pstmt = conn.prepareStatement("select * from tourism_list where gu_nm='"+gu[gu_nm]+"' and adres like'%"+dong+ "%' and park_nm like '%"+searchN+"%'")	;
			}
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
