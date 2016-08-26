package DAO_DTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import jdbc.JdbcUtil;
public class MedicalDBBean {

	private static MedicalDBBean instance= new MedicalDBBean();
	
	public static MedicalDBBean getInstance(){
		return instance;
	}
	
	private MedicalDBBean(){}
	
	private Connection getConnection()throws Exception{
		String jdbcDriver= "jdbc:apache:commons:dbcp:/pool";
		return DriverManager.getConnection(jdbcDriver);
	}

	
	public Vector searchHosp(String h_code)throws Throwable{
		Connection conn=null;
		PreparedStatement pstmt= null;
		ResultSet rs=null;
		Vector vecList=new Vector();
		
		try{
			conn=getConnection();
			if(h_code.equals("0")){
				pstmt=conn.prepareStatement("select*from hosp");
			}else{
				pstmt=conn.prepareStatement("select*from hosp where h_code=?");
				pstmt.setString(1,h_code);
			}
			rs=pstmt.executeQuery();
			if(rs.next()){
				do{
					HospitalDataBean hsp=new HospitalDataBean();
					hsp.setNum(rs.getInt("num"));
					hsp.setH_nm(rs.getString("h_nm"));
					hsp.setGu_nm(rs.getString("gu_nm"));
					hsp.setDong(rs.getString("dong"));
					hsp.setX(rs.getDouble("x"));
					hsp.setY(rs.getDouble("y"));
					vecList.addElement(hsp);
				}while(rs.next());
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return vecList;
	}

		public Vector searchHeal()throws Throwable{
			Connection conn=null;
			PreparedStatement pstmt= null;
			ResultSet rs=null;
			Vector vecList=new Vector();
			
			try{
				conn=getConnection();
				pstmt=conn.prepareStatement("select*from health_center");
			
				rs=pstmt.executeQuery();
				if(rs.next()){
					do{
						HealCenDataBean helcen=new HealCenDataBean();
						helcen.setNum(rs.getInt("num"));
						helcen.setH_nm(rs.getString("h_nm"));
						helcen.setLocation(rs.getString("location"));
						helcen.setX(rs.getDouble("x"));
						helcen.setY(rs.getDouble("y"));
						vecList.addElement(helcen);
					}while(rs.next());
				}
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
				JdbcUtil.close(conn);
			}
			return vecList;
		}

	public Vector selectHosp(int n,String dong,String h_nm)throws Throwable{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Vector vecList =new Vector();
		String[] gunm ={ "전체", "강남구", "강동구", "강북구", "강서구", "관악구", "광진구", "구로구", "금천구", "노원구", "도봉구", "동대문구", "동작구", "마포구", "서대문구", "서초구", "성동구", "성북구", "송파구", "양천구", "영등포구",
				"용산구", "은평구", "종로구", "중랑구", "중구" };
		try{
			
			conn=getConnection();
			if(n==0){
				if(dong.equals("")&&h_nm.equals("")){
					pstmt=conn.prepareStatement("select * from hosp");
				}else if(!dong.equals("")&&h_nm.equals("")){
					pstmt=conn.prepareStatement("select * from hosp where dong like '%"+dong+"%'");
				}else if(dong.equals("")&&!h_nm.equals("")){
					pstmt=conn.prepareStatement("select * from hosp where h_nm like '%"+h_nm+"%'");

				}else{
					pstmt=conn.prepareStatement("select * from hosp where h_nm like '%"+h_nm+"%' and dong like '%"+dong+"%'");
	
				}
			}else{
			if(dong.equals("")&&h_nm.equals("")){
				pstmt=conn.prepareStatement("select * from hosp where gu_nm="+"'"+gunm[n]+"'");
				
			}else if(!dong.equals("")&&h_nm.equals("")){
				pstmt=conn.prepareStatement("select * from hosp where gu_nm="+"'"+gunm[n]+"'"+" and dong like '%"+dong+"%'");
			}else if(dong.equals("")&&!h_nm.equals("")){
				pstmt=conn.prepareStatement("select * from hosp where gu_nm="+"'"+gunm[n]+"'"+" and h_nm like '%"+h_nm+"%'");

			}else{
				pstmt=conn.prepareStatement("select * from hosp where gu_nm="+"'"+gunm[n]+"'"+" and h_nm like '%"+h_nm+"%' and dong like '%"+dong+"%'");

			}
			}
			rs=pstmt.executeQuery();
			if(rs.next()){
				do{
					HospitalDataBean hsp=new HospitalDataBean();
					hsp.setNum(rs.getInt("num"));
					hsp.setH_nm(rs.getString("h_nm"));
					hsp.setGu_nm(rs.getString("gu_nm"));
					hsp.setDong(rs.getString("dong"));
					hsp.setX(rs.getDouble("x"));
					hsp.setY(rs.getDouble("y"));
					vecList.addElement(hsp);
				}while(rs.next());
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return vecList;
	}

		public Vector selectHel(int n,String dong,String h_nm)throws Throwable{
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			Vector vecList =new Vector();
			String[] gunm = { "전체", "강남구", "강동구", "강북구", "강서구", "관악구", "광진구", "구로구", "금천구", "노원구", "도봉구", "동대문구", "동작구", "마포구", "서대문구", "서초구", "성동구", "성북구", "송파구", "양천구", "영등포구",
					"용산구", "은평구", "종로구", "중랑구", "중구" };
			try{
				
				conn=getConnection();
				if(n==0){
					if(dong.equals("")&&h_nm.equals("")){
						pstmt=conn.prepareStatement("select * from health_center");
					}else if(!dong.equals("")&&h_nm.equals("")){
						pstmt=conn.prepareStatement("select * from health_center where dong like '%"+dong+"%'");
					}else if(dong.equals("")&&!h_nm.equals("")){
						pstmt=conn.prepareStatement("select * from health_center where h_nm like '%"+h_nm+"%'");
					}else{
						pstmt=conn.prepareStatement("select * from health_center where h_nm like '%"+h_nm+"%' and dong like '%"+dong+"%'");
					}
				}else{
				if(dong.equals("")&&h_nm.equals("")){
					pstmt=conn.prepareStatement("select * from health_center where gu_nm="+"'"+gunm[n]+"'");
					
				}else if(!dong.equals("")&&h_nm.equals("")){
					pstmt=conn.prepareStatement("select * from health_center where gu_nm="+"'"+gunm[n]+"'"+" and dong like '%"+dong+"%'");
				}else if(dong.equals("")&&!h_nm.equals("")){
					pstmt=conn.prepareStatement("select * from health_center where gu_nm="+"'"+gunm[n]+"'"+" and  h_nm like '%"+h_nm+"%'");
				}else{
					pstmt=conn.prepareStatement("select * from health_center where gu_nm="+"'"+gunm[n]+"'"+" and h_nm like '%"+h_nm+"%' and dong like '%"+dong+"%'");
				}
				}
				rs=pstmt.executeQuery();
				if(rs.next()){
					do{
						HealCenDataBean helcen=new HealCenDataBean();
						helcen.setNum(rs.getInt("num"));
						helcen.setH_nm(rs.getString("h_nm"));
						helcen.setLocation(rs.getString("location"));
						helcen.setX(rs.getDouble("x"));
						helcen.setY(rs.getDouble("y"));
						vecList.addElement(helcen);
					}while(rs.next());
				}
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
				JdbcUtil.close(conn);
			}
			return vecList;
		}
		

	public HealCenDataBean detailHel(int num)throws Throwable{
		Connection conn= null;
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		HealCenDataBean helcen=new HealCenDataBean();
		try{
			conn=getConnection();
			pstmt=conn.prepareStatement("select*from health_center where num=?");
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			if(rs.next()){
				do{
				
					helcen.setH_nm(rs.getString("h_nm"));
					helcen.setHmpg_url(rs.getString("hmpg_url"));
					helcen.setLocation(rs.getString("location"));
					helcen.setTell(rs.getString("tell"));
					helcen.setWeek_time(rs.getString("week_time"));
					helcen.setWeekend_time(rs.getString("weekend_time"));
					helcen.setBreak_time(rs.getString("break_time"));
					helcen.setRm(rs.getString("rm"));
					helcen.setX(rs.getDouble("x"));
					helcen.setY(rs.getDouble("y"));
					
				}while(rs.next());
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return helcen;
	}
	public HospitalDataBean detailHosp(int num)throws Throwable{
		Connection conn= null;
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		HospitalDataBean hdb=new HospitalDataBean();
		try{
			conn=getConnection();
			pstmt=conn.prepareStatement("select*from hosp where num=?");
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			if(rs.next()){
				do{
					
					hdb.setH_nm(rs.getString("h_nm"));
					hdb.setGu_nm(rs.getString("gu_nm"));
					hdb.setDong(rs.getString("dong"));
					hdb.setWeek_time(rs.getString("week_time"));
					hdb.setRm(rs.getString("rm"));
					hdb.setX(rs.getDouble("x"));
					hdb.setY(rs.getDouble("y"));
					
				}while(rs.next());
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return hdb;
	}
}
