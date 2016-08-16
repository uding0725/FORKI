package DAO_DTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import jdbc.JdbcUtil;

import DAO_DTO.KiderDataBean;

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
/*	//유치원 유치원명선택
	public Vector selectKid(String matr_gu, String schul_nm)throws Exception{
		
	}
	//유치원 동선택
	public Vector selectKid(String matr_gu,String dong)throws Exception{
		
	}
	//main에서 지도 클릭시 
	public Vector selectKid(String matr_gu)throws Exception{
		
	}*/
	//유치원 상세보기
	public KiderDataBean selectDetKid(String SCHUL_NUM)throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		KiderDataBean DBdata = null;
		System.out.println("디비빈까지 왔는지 확인,   넘어온 값 : " + SCHUL_NUM);
		try {
			pstmt = conn.prepareStatement("select * From E_TEST where SCHUL_NUM = ?");
			pstmt.setString(1, SCHUL_NUM);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				DBdata = new KiderDataBean();
				DBdata.setSchul_nm(rs.getString("schul_nm"));
				DBdata.setAdres(rs.getString("adres"));
				DBdata.setTelno(rs.getString("telno"));
				DBdata.setClas_co(rs.getInt("clas_co"));
				DBdata.setStdnt_co_sm(rs.getInt("stdnt_co_sm"));
				DBdata.setGrlstdn_co(rs.getInt("grlstdn_co"));
				DBdata.setFrl_tcher_co_sm(rs.getInt("frl_tcher_co_sm"));
				DBdata.setFrl_female_tcher_c(rs.getInt("frl_female_tcher_c"));
				DBdata.setRm(rs.getString("rm"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return DBdata;
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
	//관리자 페이지- 유치원 승인-페이징을위해 개수를 가지고옴
	public int getCountKider()throws Exception{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int x=0;
		try{
			conn=getConnection();
			pstmt =conn.prepareStatement("select count(*) from kindergarten where state='n'");
			rs= pstmt.executeQuery();
			
			if(rs.next())
				x=rs.getInt(1);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return x;
	}
	//관리자 페이지- 유치원 승인-페이징을위해 개수를 가지고옴
	public int getCountKider(int sn,String search)throws Exception{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int x=0;
		String[] col_name={"id","schul_nm"};
		try{
			conn=getConnection();
			pstmt =conn.prepareStatement("select count(*) from kindergarten natural join k_etc where "+col_name[sn]+" like '%"+search+"%'"+ " and state='n'");
			rs= pstmt.executeQuery();
			
			if(rs.next())
				x=rs.getInt(1);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return x;
	}
	
	//관리자 페이지- 유치원 승인(추가-수정) 그냥 검색시
	public Vector signKinder(int start,int end)throws Exception{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Vector vecList=new Vector();
		try{
			conn=getConnection();
			
			pstmt=conn.prepareStatement("select schul_nm,schul_num,reg_date,state,id,r"+ 
					" from (select schul_nm,schul_num,reg_date,state,id, rownum r from "
					+"(select schul_nm,schul_num,reg_date,state,id from kindergarten natural join k_etc order by reg_date )"+
						" where state='n' order by reg_date) where r>=? and r<=?");
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs=pstmt.executeQuery();
			if(rs.next()){
				do{
					KiderDataBean tempkdb=new KiderDataBean();
					KetcDataBean ketcdb=new KetcDataBean();
					ketcdb.setId(rs.getString("id"));
					tempkdb.setKdb(ketcdb);
					tempkdb.setSchul_num(rs.getInt("schul_num"));
					tempkdb.setSchul_nm(rs.getString("schul_nm"));
					tempkdb.setState(rs.getString("state"));
					tempkdb.setReg_date(rs.getTimestamp("reg_date"));
					vecList.addElement(tempkdb);
				}while(rs.next());
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
	//관리자 페이지- 유치원 승인(추가-수정) 그냥 검색시
		public Vector signKinder(int start,int end,int n,String search)throws Exception{
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			String[] col_nm={"id","schul_nm"};
			Vector vecList=new Vector();
			try{
				conn=getConnection();
				pstmt=conn.prepareStatement("select schul_nm,schul_num,reg_date,state,id,r"+ 
						" from (select schul_nm,schul_num,reg_date,state,id, rownum r from "
						+"(select schul_nm,schul_num,reg_date,state,id from kindergarten natural join k_etc order by reg_date )"+
							" where state='n' and "+col_nm[n]+" like '%"+search+"%' order by reg_date) where r>=? and r<=?");
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
				rs=pstmt.executeQuery();
				if(rs.next()){
					do{
						KiderDataBean tempkdb=new KiderDataBean();
						KetcDataBean ketcdb=new KetcDataBean();
						ketcdb.setId(rs.getString("id"));
						tempkdb.setKdb(ketcdb);
						tempkdb.setSchul_num(rs.getInt("schul_num"));
						tempkdb.setSchul_nm(rs.getString("schul_nm"));
						tempkdb.setState(rs.getString("state"));
						tempkdb.setReg_date(rs.getTimestamp("reg_date"));
						vecList.addElement(tempkdb);
					}while(rs.next());
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
	
	//관리자 페이지- 유치원등록 승인시(추가)
	public void updateState(int schul_num)throws Throwable{
		
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try{
			con=getConnection();
			pstmt=con.prepareStatement("update kindergarten set state='y' where schul_num=?");
			pstmt.setInt(1,schul_num);
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(pstmt);
			JdbcUtil.close(con);
		}
	}
	//관리자 페이지- 유치원등록신청 거절시 
	public void delKinder(int schul_num)throws Throwable{
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try{
			conn=getConnection();
			pstmt=conn.prepareStatement("delete from kindergarten where schul_num=?");
			pstmt.setInt(1, schul_num);
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
	}
}
