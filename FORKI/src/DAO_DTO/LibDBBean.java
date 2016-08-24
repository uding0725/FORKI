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
	

	

	public Vector getTour(int gu_nm,String dong, String searchN) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Vector vt = null;
		 
		String[] gu={"전체","강남구","강동구","강북구","강서구","관악구","광진구","구로구","금천구","노원구","도봉구","동대문구","동작구","마포구","서대문구","서초구","성동구","성북구","송파구","양천구","영등포구","용산구","은평구","종로구","중랑구","중구"};
		try{
			conn = getConnection();
			if(gu_nm == 0){
				if(searchN==null){
				pstmt = conn.prepareStatement("select * from tourism_list");
				}else{
				pstmt = conn.prepareStatement("select * from tourism_list where park_nm like '%"+searchN+"%'");	
				}
			}
			else{
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
				tldb.setX(rs.getString("x"));
				tldb.setY(rs.getString("y"));
				
				
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
	
	

	public Vector getPubLib(int gu_nm,String dong, String searchN) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Vector vt = null;
	
		String[] gu={"전체","강남구","강동구","강북구","강서구","관악구","광진구","구로구","금천구","노원구","도봉구","동대문구","동작구","마포구","서대문구","서초구","성동구","성북구","송파구","양천구","영등포구","용산구","은평구","종로구","중랑구","중구"};
			try{
			conn = getConnection();
			if(gu_nm == 0){
				if(searchN==null){
				pstmt = conn.prepareStatement("select * from pub_lib");
				}else{
				pstmt = conn.prepareStatement("select * from pub_lib where libry_name like '%"+searchN+"%'");	
				}
			}
			else{
				if(dong==null && searchN==null){
					pstmt = conn.prepareStatement("select * from  pub_lib where gu_nm='"+gu[gu_nm]+"'");
				}
				else if(dong == null && searchN != null){
					pstmt = conn.prepareStatement("select * from pub_lib where gu_nm='"+gu[gu_nm]+"' and libry_name like '%"+searchN+"%'");	
					}
				else if(dong != null && searchN ==null){
					pstmt = conn.prepareStatement("select * from pub_lib where gu_nm='"+gu[gu_nm]+"' and adres like'%"+dong+"%'");	
				}
				else if(dong != null && searchN != null){
					pstmt = conn.prepareStatement("select * from pub_lib where gu_nm='"+gu[gu_nm]+"' and adres like'%"+dong+ "%' and libry_name like '%"+searchN+"%'")	;
				}
			}
			rs = pstmt.executeQuery();
			if(rs.next()){
				vt = new Vector();
				do{
				
				Pub_LibDataBean pldb = new Pub_LibDataBean();
				pldb.setLibry_name(rs.getString("libry_name"));
				pldb.setGu_nm(rs.getString("gu_nm"));
				pldb.setAdres(rs.getString("adres"));
				pldb.setTel(rs.getString("tel"));
				pldb.setLibry_close_date(rs.getString("libry_close_date"));
				pldb.setLibry_se(rs.getString("libry_se"));
				pldb.setX_loc(rs.getString("x_loc"));
				pldb.setY_loc(rs.getString("y_loc"));
				
				vt.add(pldb);
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
	
	

	public Vector getToyLib(int gu_nm,String dong, String searchN) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Vector vt = null;
		
		String[] gu={"전체","강남구","강동구","강북구","강서구","관악구","광진구","구로구","금천구","노원구","도봉구","동대문구","동작구","마포구","서대문구","서초구","성동구","성북구","송파구","양천구","영등포구","용산구","은평구","종로구","중랑구","중구"};
		try{
			conn = getConnection();
			if(gu_nm == 0){
				if(searchN==null){
				pstmt = conn.prepareStatement("select * from toy_lib");
				}else{
				pstmt = conn.prepareStatement("select * from toy_lib where park_nm like '%"+searchN+"%'");	
				}
			}
			else{
				if(dong==null && searchN==null){
					pstmt = conn.prepareStatement("select * from toy_lib where gu_nm='"+gu[gu_nm]+"'");
				}
				else if(dong == null && searchN != null){
					pstmt = conn.prepareStatement("select * from toy_lib where gu_nm='"+gu[gu_nm]+"' and lib_nm like '%"+searchN+"%'");	
				}
				else if(dong != null && searchN ==null){
					pstmt = conn.prepareStatement("select * from toy_lib where gu_nm='"+gu[gu_nm]+"' and adres like'%"+dong+"%'");	
				}
				else if(dong != null && searchN != null){
					pstmt = conn.prepareStatement("select * from toy_lib where gu_nm='"+gu[gu_nm]+"' and adres like'%"+dong+ "%' and lib_nm like '%"+searchN+"%'")	;
				}
			}
			rs = pstmt.executeQuery();
			if(rs.next()){
				vt = new Vector();
				do{
				Toy_LibDataBean toydb = new Toy_LibDataBean();
				
				toydb.setGu_nm(rs.getString("gu_nm"));
				toydb.setLib_nm(rs.getString("lib_nm"));
				toydb.setAdres(rs.getString("adres"));
				toydb.setTel(rs.getString("tel"));
				toydb.setWebsite(rs.getString("website"));
				toydb.setX(rs.getString("x"));
				toydb.setY(rs.getString("y"));
				
				vt.add(toydb);
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
	
	public Toy_LibDataBean viewToy(String adres) throws Exception{
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Toy_LibDataBean article = new Toy_LibDataBean();
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from toy_lib where adres='"+adres+"'");
			rs = pstmt.executeQuery();
			if(rs.next()){
				article.setGu_nm(rs.getString("gu_nm"));
				article.setLib_nm(rs.getString("lib_nm"));
				article.setAdres(rs.getString("adres"));
				article.setTel(rs.getString("tel"));
				article.setWebsite(rs.getString("website"));
				article.setX(rs.getString("x"));
				article.setY(rs.getString("y"));
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			JdbcUtil.close(conn);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(rs);
		}
		
		return article;
	}
	
public Tourism_ListDataBean viewTour(String adres) throws Exception{
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Tourism_ListDataBean article = new Tourism_ListDataBean();
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from tourism_list where adres='"+adres+"'");
			rs = pstmt.executeQuery();
			if(rs.next()){
				article.setPark_nm(rs.getString("park_nm"));
				article.setPark_se(rs.getString("park_se"));
				article.setAdres(rs.getString("adres"));
				article.setTel(rs.getString("tel"));
				article.setGu_nm(rs.getString("gu_nm"));
				article.setX(rs.getString("x"));
				article.setY(rs.getString("y"));
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			JdbcUtil.close(conn);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(rs);
		}
		
		return article;
	}

public Pub_LibDataBean viewPublic(String adres) throws Exception{
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Pub_LibDataBean article = new Pub_LibDataBean();
	
	try{
		conn = getConnection();
		pstmt = conn.prepareStatement("select * from pub_lib where adres='"+adres+"'");
		rs = pstmt.executeQuery();
		if(rs.next()){
			article.setLibry_name(rs.getString("libry_name"));
			article.setGu_nm(rs.getString("gu_nm"));
			article.setAdres(rs.getString("adres"));
			article.setTel(rs.getString("tel"));
			article.setWebsite(rs.getString("website"));
			article.setLibry_close_date(rs.getString("libry_close_date"));
			article.setLibry_se(rs.getString("libry_se"));
			article.setX_loc(rs.getString("x_loc"));
			article.setY_loc(rs.getString("y_loc"));
		}
	}catch(Exception ex){
		ex.printStackTrace();
	}finally{
		JdbcUtil.close(conn);
		JdbcUtil.close(pstmt);
		JdbcUtil.close(rs);
	}
	
	return article;
}
	
	
	
	
	
}
