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

	//占쏙옙치占쏙옙 占쏢세븝옙占쏙옙
	public KiderDataBean selectDetKid(String SCHUL_NUM)throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		KiderDataBean DBdata = null;
		try {
			conn=getConnection();
			pstmt = conn.prepareStatement("select * From KINDERGARTEN where SCHUL_NUM = ?");
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
				DBdata.setFrl_female_tcher_co(rs.getInt("frl_female_tcher_co"));
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
	//占쏙옙치占쏙옙 占쏙옙占�
	public void insertKid(KiderDataBean kidmember)throws Exception{
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try{
			con=getConnection();
			pstmt=con.prepareStatement("insert into kindergarten(schul_nm,schul_num,ofcdc,matr_gu,fond,zip,adres,dong,telno,clas_co,stdnt_co_sm,grlstdn_co,frl_tcher_co_sm,frl_female_tcher_co,rm,state,reg_date) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1,kidmember.getSchul_nm());
			pstmt.setInt(2, kidmember.getSchul_num());
			pstmt.setString(3, kidmember.getOfcdc());
			pstmt.setString(4, kidmember.getMatr_gu());
			pstmt.setString(5, kidmember.getFond());
			pstmt.setString(6,kidmember.getZip());
			pstmt.setString(7, kidmember.getAdres());
			pstmt.setString(8, kidmember.getDong());
			pstmt.setString(9,kidmember.getTelno());
			pstmt.setInt(10, kidmember.getClas_co());
			pstmt.setInt(11, kidmember.getStdnt_co_sm());
			pstmt.setInt(12, kidmember.getGrlstdn_co());
			pstmt.setInt(13,kidmember.getFrl_tcher_co_sm());
			pstmt.setInt(14, kidmember.getFrl_female_tcher_co());
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
	//占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙- 占쏙옙치占쏙옙 占쏙옙占쏙옙-占쏙옙占쏙옙징占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占�
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
	//占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙- 占쏙옙치占쏙옙 占쏙옙占쏙옙-占쏙옙占쏙옙징占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占�
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
	
	//占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙- 占쏙옙치占쏙옙 占쏙옙占쏙옙(占쌩곤옙-占쏙옙占쏙옙) 占쌓놂옙 占싯삼옙占쏙옙
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
	//占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙- 占쏙옙치占쏙옙 占쏙옙占쏙옙(占쌩곤옙-占쏙옙占쏙옙) 占쌓놂옙 占싯삼옙占쏙옙
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
	
		//�쑀移섏썝 �듅�씤�떊泥� �듅�씤�떆
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
	
	//�쑀移섏썝 �듅�씤�떊泥� 嫄곗젅�떆
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
	
	//�쑀移섏썝 �꽑�깮�썑 議고쉶
	public Vector selectKinder(int gunum,String dong,String schul_nm)throws Throwable{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Vector vecList =new Vector();
		String Dong=dong;
		String Schul_nm=schul_nm;
  
		String[] gunm={"전체","강남구","강동구","강북구","강서구","관악구","광진구","구로구","금천구","노원구","도봉구","동대문구","동작구","마포구","서대문구","서초구","성동구","성북구","송파구","양천구","영등포구","용산구","은평구","종로구","중랑구","중구"};
		try{
	
			conn=getConnection();
			if(gunum==0){
				if(Dong.equals("")&&Schul_nm.equals("")){
					pstmt=conn.prepareStatement("select schul_num,schul_nm,adres,telno from kindergarten");
				}else if(!Dong.equals("")&&Schul_nm.equals("")){
					pstmt=conn.prepareStatement("select schul_num,schul_nm,adres,telno from kindergarten where dong=?");
					pstmt.setString(1,Dong);
				}else if(Dong.equals("")&&!Schul_nm.equals("")){
					pstmt=conn.prepareStatement("select schul_num,schul_nm,adres,telno from kindergarten where schul_nm=?");
					pstmt.setString(1,schul_nm);
				}else{
					pstmt=conn.prepareStatement("select schul_num,schul_nm,adres,telno from kindergarten where schul_nm=? and dong=?");
					pstmt.setString(1,Schul_nm);
					pstmt.setString(2,Dong);
				}
			}else{
			if(Dong.equals("")&&Schul_nm.equals("")){
				pstmt=conn.prepareStatement("select schul_num,schul_nm,adres,telno from kindergarten where matr_gu="+"'"+gunm[gunum]+"'");
				
			}else if(!Dong.equals("")&&Schul_nm.equals("")){
				pstmt=conn.prepareStatement("select schul_num,schul_nm,adres,telno from kindergarten where matr_gu="+"'"+gunm[gunum]+"'"+" and dong=?");
				pstmt.setString(1,Dong);
			}else if(Dong.equals("")&&!Schul_nm.equals("")){
				pstmt=conn.prepareStatement("select schul_num,schul_nm,adres,telno from kindergarten where matr_gu="+"'"+gunm[gunum]+"'"+" and schul_nm=?");
				pstmt.setString(1,schul_nm);
			}else{
				pstmt=conn.prepareStatement("select schul_num,schul_nm,adres,telno from kindergarten where matr_gu="+"'"+gunm[gunum]+"'"+" and schul_nm=? and dong=?");
				pstmt.setString(1,Schul_nm);
				pstmt.setString(2,Dong);
			}
			}
			rs=pstmt.executeQuery();
			if(rs.next()){
				do{
					KiderDataBean kdb=new KiderDataBean();
					kdb.setSchul_num(rs.getInt("schul_num"));
					kdb.setSchul_nm(rs.getString("schul_nm"));
					kdb.setAdres(rs.getString("adres"));
					kdb.setTelno(rs.getString("telno"));
					vecList.addElement(kdb);
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

}
