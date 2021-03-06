package comAction;

import java.sql.*;
import java.util.Vector;

import comAction.LogonDataBean;
import comAction.SchulBean;

public class LogonDBBean {//DB와 관련된 일을 하는 클래스: DBBean, DAO
   
	private static LogonDBBean instance = new LogonDBBean();
   
	//LogonDBBean m = LogonDBBean.getInstance();
    public static LogonDBBean getInstance() {
        return instance;
    }
   
    private LogonDBBean() {}
   
    private Connection getConnection() throws Exception {
    	String jdbcDriver = "jdbc:apache:commons:dbcp:/pool";        
    	return DriverManager.getConnection(jdbcDriver);
    }
     
    //inputPro.jsp(member)
    public int insertMEMBER(LogonDataBean member) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
		int check = 0;
       
        try {
            conn = getConnection();
 //DriverManager.getConnection(jdbc:apache:commons:dbcp:/pool);
            pstmt = conn.prepareStatement(
            "insert into MEMBER values (?,?,?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1, member.getId());
            pstmt.setString(2, member.getName());
            pstmt.setString(3, member.getPasswd());
            pstmt.setString(4, member.getEmail());
            pstmt.setInt(5, 2);
            pstmt.setString(6, "n");
            pstmt.setString(7, member.getTell());
            pstmt.setString(8, member.getZipcode());
            pstmt.setString(9, member.getAddress());
            pstmt.setInt(10, member.getYellow_card());
            pstmt.setTimestamp(11, member.getJoin_date());
            
            pstmt.executeUpdate();
			
            pstmt = conn.prepareStatement("select * From MEMBER where id = ?");
			pstmt.setString(1, member.getId());

			rs = pstmt.executeQuery();

			if (rs.next()) {
				check = 1;
			} else {
				check = -1;
			}
            
        
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
        return check;
    }
    
  //inputPro.jsp(p_etc)
    public void insertP_ETC(LogonDataBean p_etc) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
       
        try {
            conn = getConnection();
 //DriverManager.getConnection(jdbc:apache:commons:dbcp:/pool);
            pstmt = conn.prepareStatement(
            "insert into P_ETC values (?,?,?,?,?)");
            pstmt.setString(1, p_etc.getId());
            pstmt.setString(2, p_etc.getNickname());
            pstmt.setString(3, p_etc.getB_day());
            pstmt.setString(4, p_etc.getSex());
            pstmt.setString(5, p_etc.getFavorite());
            
            pstmt.executeUpdate();
        
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
    }
    
  //inputPro.jsp(k_etc)
    public void insertK_ETC(LogonDataBean k_etc) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
               
        try {
            conn = getConnection();
 //DriverManager.getConnection(jdbc:apache:commons:dbcp:/pool);
            
            pstmt = conn.prepareStatement(
            "insert into K_ETC values (?,?,?,?)");
            pstmt.setString(1, k_etc.getSchul_num());
            pstmt.setString(2, k_etc.getId());
            pstmt.setString(3, k_etc.getSchul_nm());
            pstmt.setString(4, "n");
            
            pstmt.executeUpdate();
        
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
    }
    
    //loginPro.jsp
    public int userCheck(String id, String passwd) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;    
        ResultSet rs= null;
        String dbpasswd="";
        int x=-1;
        
        try {
            conn = getConnection();
           
            pstmt = conn.prepareStatement(
            "select PWD from MEMBER where id = ?");
            pstmt.setString(1, id);
            rs= pstmt.executeQuery();

            if(rs.next()){
            	dbpasswd= rs.getString("PWD");
            	if(dbpasswd.equals(passwd))
            		x= 1; //인증 성공
            	else
            		x= 0; //비밀번호 틀림
            }else
            	x= -1;//해당 아이디 없음

        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
        	if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
        return x;
    }
    
    // 로그인 계정 정보값 가져오기
    public LogonDataBean getDBdata(String id) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        LogonDataBean DBdata =null;
        try {
            conn = getConnection();
           
            pstmt = conn.prepareStatement(
            "select * from MEMBER where id = ?");
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
            	DBdata =  new LogonDataBean();
            	DBdata.setId(rs.getString("id"));
            	DBdata.setM_grade(rs.getInt("m_grade"));
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
        return DBdata;
    }
    
    // 로그인 계정 정보값 가져오기
    public LogonDataBean getDBSchul(String id) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        LogonDataBean DBdata =null;
        try {
            conn = getConnection();
           
            pstmt = conn.prepareStatement(
            "select * from K_ETC where id = ?");
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
            	DBdata = new LogonDataBean();
            	DBdata.setId(rs.getString("id"));
            	DBdata.setSchul_num(rs.getString("schul_num"));
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
        return DBdata;
    }
    
    //기업 등록 승인여부
    public int getDBK_ETCdata(String id) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String reg_check = "";
        int x = -1;
        try {
            conn = getConnection();
           
            pstmt = conn.prepareStatement("select * from K_ETC where id = ?");
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
            	reg_check = rs.getString("reg_check");
            	if("y".equals(reg_check)){
            		x = 1;// 인증됨
				}else {
					x = 0;// 인증 안됨
				}
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
        return x;
    }
    
    //confirmId.jsp
    public int confirmId(String id) throws Exception {
    	Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs= null;
        int x=-1;//경우의 수
       
        try {
            conn = getConnection();
           
            pstmt = conn.prepareStatement(
            "select id from MEMBER where id = ?");
            pstmt.setString(1, id);
            rs= pstmt.executeQuery();

            if(rs.next())
            	x= 1; //해당 아이디 있음
            else
            	x= -1;//해당 아이디 없음
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
        	if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
        return x;
    }
    
    //confirmNick.jsp
    public int confirmNick(String nickname) throws Exception {
    	Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs= null;
        int x=-1;//경우의 수
       
        try {
            conn = getConnection();
           
            pstmt = conn.prepareStatement(
            "select nickname from P_ETC where nickname = ?");
            pstmt.setString(1, nickname);
            rs= pstmt.executeQuery();

            if(rs.next())
            	x= 1; //해당 닉네임 있음
            else
            	x= -1;//해당 닉네임 없음
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
        	if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
        return x;
    }
    
    //confirmSchulNUM.jsp
    public int confirmSchulNUM(String schul_num) throws Exception {
    	Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs= null;
        int x=-1;//경우의 수
       
        try {
            conn = getConnection();
           
            pstmt = conn.prepareStatement(
            "select schul_num from KINDERGARTEN where schul_num = ?");
            pstmt.setString(1, schul_num);
            rs= pstmt.executeQuery();

            if(rs.next())
            	x= 1; //해당 사업자번호 있음
            else
            	x= -1;//해당 없음
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
        	if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
        return x;
    }

    //modifyForm.jsp(MEMBER)
    public LogonDataBean getMEMBER(String id) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        LogonDataBean member=null;
        try {
            conn = getConnection();
           
            pstmt = conn.prepareStatement(
            "select * from MEMBER where id = ?");
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
            	member = new LogonDataBean();
            	member.setId(rs.getString("id"));
            	member.setPasswd(rs.getString("pwd"));
            	member.setName(rs.getString("name"));
            	member.setEmail(rs.getString("e_mail"));
            	member.setTell(rs.getString("tell"));
            	member.setZipcode(rs.getString("zipcode"));
            	member.setAddress(rs.getString("address"));  
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
        return member;
    }
  //modifyForm.jsp(P_ETC)
    public LogonDataBean getP_ETC(String id) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        LogonDataBean p_etc =null;
        try {
            conn = getConnection();
           
            pstmt = conn.prepareStatement(
            "select * from P_ETC where id = ?");
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
            	p_etc = new LogonDataBean();
            	p_etc.setId(rs.getString("id"));
            	p_etc.setNickname(rs.getString("nickname"));
            	p_etc.setB_day(rs.getString("birthday"));
            	p_etc.setSex(rs.getString("sex")); 
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
        return p_etc;
    }
  //modifyForm.jsp(K_ETC)
    public LogonDataBean getK_ETC(String id) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        LogonDataBean kid_data =null;
        try {
            conn = getConnection();
           
            pstmt = conn.prepareStatement(
            "select * from K_ETC where id = ?");
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
            	kid_data = new LogonDataBean();
            	kid_data.setId(rs.getString("id"));
            	kid_data.setSchul_num(rs.getString("schul_num"));
            	kid_data.setSchul_nm(rs.getString("schul_nm"));
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
        return kid_data;
    }
    
    //modifyPro.jsp(MEMBER)
    public void updateMEMBER(LogonDataBean member) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
       
        try {
            conn = getConnection();
           
            pstmt = conn.prepareStatement(
            "update MEMBER set name=?,pwd=?,e_mail=?,tell=?,zipcode=?,address=?" +
            " where id=?");
            pstmt.setString(1, member.getName());
            pstmt.setString(2, member.getPasswd());
            pstmt.setString(3, member.getEmail());
            pstmt.setString(4, member.getTell());
            pstmt.setString(5, member.getZipcode());
            pstmt.setString(6, member.getAddress());
            pstmt.setString(7, member.getId());
           
            pstmt.executeUpdate();
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
    }
    //modifyPro.jsp(P_ETC)
    public void updateP_ETC(LogonDataBean member) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
       
        try {
            conn = getConnection();
           
            pstmt = conn.prepareStatement(
            "update P_ETC set nickname=?" + " where id=?");
            pstmt.setString(1, member.getNickname());
            pstmt.setString(2, member.getId());
           
            pstmt.executeUpdate();
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
    }
    //modifyPro.jsp(K_ETC)
    public void updateK_ETC(LogonDataBean member) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
       
        try {
            conn = getConnection();
           
            pstmt = conn.prepareStatement(
            "update K_ETC set schul_num=?,schul_nm=?" + " where id=?");
            pstmt.setString(1, member.getSchul_num());
            pstmt.setString(2, member.getSchul_nm());
            pstmt.setString(3, member.getId());
           
            pstmt.executeUpdate();
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
    }
    //deletePro.jsp(MEMBER)
    public int deleteMEMBER(String id, String passwd) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs= null;
        String dbpasswd="";
        int x=-1;
        
        try {
        	conn = getConnection();

            pstmt = conn.prepareStatement(
            "select pwd from MEMBER where id = ?");
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
           
            if(rs.next()){
            dbpasswd= rs.getString("pwd");
            if(dbpasswd.equals(passwd)){
            pstmt = conn.prepareStatement("delete from MEMBER where id=?");
            pstmt.setString(1, id);
            pstmt.executeUpdate();
            x= 1; //회원탈퇴 성공
            }else
            x= 0; //비밀번호 틀림
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
        return x;
    }
    //deletePro.jsp(P_ETC)
    public int deleteP_ETC(String id, String passwd) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs= null;
        String dbpasswd="";
        int x=-1;
        
        try {
        	conn = getConnection();

            pstmt = conn.prepareStatement(
            "select pwd from MEMBER where id = ?");
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
           
            if(rs.next()){
            dbpasswd= rs.getString("pwd");
            if(dbpasswd.equals(passwd)){
            pstmt = conn.prepareStatement("delete from P_ETC where id=?");
            pstmt.setString(1, id);
            pstmt.executeUpdate();
            x= 1; //회원탈퇴 성공
            }else
            x= 0; //비밀번호 틀림
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
        return x;
    }
	// deletePro.jsp(K_ETC)
	public int deleteK_ETC(String id, String passwd) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String dbpasswd = "";
		int x = -1;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select pwd from MEMBER where id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dbpasswd = rs.getString("pwd");
				if (dbpasswd.equals(passwd)) {
					pstmt = conn.prepareStatement("delete from K_ETC where id=?");
					pstmt.setString(1, id);
					pstmt.executeUpdate();
					x = 1; // 회원탈퇴 성공
				} else
					x = 0; // 비밀번호 틀림
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return x;
	}
    
    public Vector zipcodeRead(String area4)  {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Vector<ZipcodeBean> vecList = new Vector<ZipcodeBean>();
        
        try {
            con = getConnection();
            String strQuery = "select * from zipcode where area4 like '"+area4+"%'";
            pstmt = con.prepareStatement(strQuery);
            rs = pstmt.executeQuery();
            while(rs.next()){
                ZipcodeBean tempZipcode = new ZipcodeBean();
                tempZipcode.setZipcode(rs.getString("zipcode"));
                tempZipcode.setArea1(rs.getString("area1"));
                tempZipcode.setArea2(rs.getString("area2"));
                tempZipcode.setArea3(rs.getString("area3"));
                tempZipcode.setArea4(rs.getString("area4"));
                vecList.addElement(tempZipcode);
            }

        }catch(Exception ex) {
            System.out.println("Exception" + ex);
        }finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (con != null) try { con.close(); } catch(SQLException ex) {}
        }
        return vecList;
    }
    
    //SchulCheck.jsp
    public Vector SchulRead(String schul_num)  {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Vector<SchulBean> vecList = new Vector<SchulBean>();
        
        try {
            con = getConnection();
            String strQuery = "select * from KINDERGARTEN where schul_num like '"+schul_num+"%'";
            pstmt = con.prepareStatement(strQuery);
            rs = pstmt.executeQuery();
            while(rs.next()){
            	SchulBean tempSchul = new SchulBean();
            	tempSchul.setSchul_nm(rs.getString("schul_nm"));
            	tempSchul.setSchul_num(rs.getString("schul_num"));
            	tempSchul.setAdres(rs.getString("adres"));
                vecList.addElement(tempSchul);
            }

        }catch(Exception ex) {
            System.out.println("Exception" + ex);
        }finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (con != null) try { con.close(); } catch(SQLException ex) {}
        }
        return vecList;
    }
    
    //findID.jsp
    public String findID(String name,String email){
   	 Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String id="";
        try {
            conn = getConnection();
           
            pstmt = conn.prepareStatement(
            "select id from MEMBER where NAME = ? AND E_MAIL=?");
            pstmt.setString(1, name);
            pstmt.setString(2, email);
           
            rs = pstmt.executeQuery();

            if (rs.next()) {
                id = rs.getString("id");        
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
   	return id;
   }
    //findPWD.jsp
    public int findPWD(String id, String name, String email){
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	int check = 0;
    	try{
    	conn = getConnection();
    	pstmt = conn.prepareStatement(
    	"select PWD from MEMBER where ID=? AND NAME=? AND E_MAIL=?");
    	pstmt.setString(1, id);
    	pstmt.setString(2, name);
    	pstmt.setString(3, email);
    	
    	rs = pstmt.executeQuery();
    	if(rs.next()){
    		check = 1;
    	}
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}finally{
    		if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
    	}
    	return check;
    }
    //updatePWD.jsp
    public int updatePwd(String passwd, String id){
 	   Connection conn = null;
        PreparedStatement pstmt = null;
        int x = 0;
        try {
            conn = getConnection();
           
            pstmt = conn.prepareStatement(
         		   "update MEMBER set PWD=? where ID=?");
            pstmt.setString(1, passwd);
            pstmt.setString(2, id);
            x = pstmt.executeUpdate();
            
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
 	
 	
 	return x;
    }
    //certify.jsp(EMAIL인증)
    public int Certify(String id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int x = 0;
		
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("update MEMBER set CERTIFY=? where ID=?");
			pstmt.setString(1, "y"); /*인증여부값을 y로 변경*/
			pstmt.setString(2, id);

			x = pstmt.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return x;
	}
}