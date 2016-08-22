package sysAction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Vector;

import comAction.LogonDataBean;


public class SystemDBBean {//DB와 관련된 일을 하는 클래스: DBBean, DAO
	   
		private static SystemDBBean instance = new SystemDBBean();
	   
		//SystemDBBean m = SystemDBBean.getInstance();
	    public static SystemDBBean getInstance() {
	        return instance;
	    }
	   
	    private SystemDBBean() {}
	   
	    private Connection getConnection() throws Exception {
	    	String jdbcDriver = "jdbc:apache:commons:dbcp:/pool";        
	    	return DriverManager.getConnection(jdbcDriver);
	    }
	    //black_list.jsp
	    public Vector getBLACKLIST() throws Exception {
	    	Vector list = new Vector();
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        SystemDataBean black_list = null;
	        try {
	            conn = getConnection();
	           
	            pstmt = conn.prepareStatement(
	            "select * from BLACK_LIST");
	            rs = pstmt.executeQuery();

	            if (rs.next()) {
	            	
	            	do{
	            	black_list = new SystemDataBean();
	            	black_list.setId(rs.getString("id"));
	            	black_list.setM_grade(rs.getInt("m_grade"));
	            	black_list.setR_date(rs.getTimestamp("r_date"));
	            	black_list.setContent(rs.getString("content"));
	            	black_list.setState(rs.getString("state"));
	            	list.add(black_list);
	            	}while(rs.next());
	            }
	        } catch(Exception ex) {
	            ex.printStackTrace();
	        } finally {
	            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
	            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
	            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	        }
	        return list;
	    }
	    //MemberCare.jsp
	    public Vector getMemcare() throws Exception {
	    	Vector list = new Vector();
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        LogonDataBean mem_list = null;
	        try {
	            conn = getConnection();
	           
	            pstmt = conn.prepareStatement(
	            "select * from MEMBER");
	            rs = pstmt.executeQuery();

	            if (rs.next()) {
	            	
	            	do{
	            	mem_list = new LogonDataBean();
	            	mem_list.setId(rs.getString("id"));
	            	mem_list.setName(rs.getString("name"));
	            	mem_list.setEmail(rs.getString("e_mail"));
	            	mem_list.setM_grade(rs.getInt("m_grade"));
	            	mem_list.setYellow_card(rs.getInt("yellow_card"));
	            	mem_list.setJoin_date(rs.getTimestamp("join_date"));
	            	list.add(mem_list);
	            	}while(rs.next());
	            }
	        } catch(Exception ex) {
	            ex.printStackTrace();
	        } finally {
	            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
	            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
	            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	        }
	        return list;
	    }
	    //Usercheck.jsp
	    public LogonDataBean getMemUserCheck(String id) throws Exception {
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
	            	member.setYellow_card(rs.getInt("yellow_card"));
	            	member.setJoin_date(rs.getTimestamp("join_date"));
	            	member.setEmail(rs.getString("e_mail"));
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
	    
	    public LogonDataBean getP_etcUserCheck(String id) throws Exception {
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        LogonDataBean member=null;
	        try {
	            conn = getConnection();
	           
	            pstmt = conn.prepareStatement(
	            "select * from P_ETC where id = ?");
	            pstmt.setString(1, id);
	            rs = pstmt.executeQuery();

	            if (rs.next()) {
	            	member = new LogonDataBean();
	            	member.setNickname(rs.getString("nickname"));
	            	member.setSex(rs.getString("sex"));
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
	    //blackUcheck.jsp
	    public SystemDataBean getBlackUCheck(String id) throws Exception {
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        SystemDataBean BList = null;
	        try {
	            conn = getConnection();
	           
	            pstmt = conn.prepareStatement(
	            "select * from BLACK_LIST where id = ?");
	            pstmt.setString(1, id);
	            rs = pstmt.executeQuery();

	            if (rs.next()) {
	            	BList = new SystemDataBean();
	            	BList.setId(rs.getString("id"));
	            	BList.setM_grade(rs.getInt("m_grade"));
	            	BList.setR_date(rs.getTimestamp("r_date"));
	            	BList.setContent(rs.getString("content"));
	            	
	            }
	        } catch(Exception ex) {
	            ex.printStackTrace();
	        } finally {
	            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
	            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
	            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	        }
	        return BList;
	    }
	    
	    public SystemDataBean getMemCheck(String id) throws Exception {
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        SystemDataBean member=null;
	        try {
	            conn = getConnection();
	           
	            pstmt = conn.prepareStatement(
	            "select * from MEMBER where id = ?");
	            pstmt.setString(1, id);
	            rs = pstmt.executeQuery();

	            if (rs.next()) {
	            	member = new SystemDataBean();
	            	member.setId(rs.getString("id"));
	            	member.setM_grade(rs.getInt("m_grade"));
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
	    
	    public int insertBlack(SystemDataBean black) throws Exception {
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
			int check = 0;
	       
	        try {
	            conn = getConnection();
	 //DriverManager.getConnection(jdbc:apache:commons:dbcp:/pool);
	            pstmt = conn.prepareStatement(
	            "insert into BLACK_LIST values (?,?,?,?,?)");
	            pstmt.setString(1, black.getId());
	            pstmt.setInt(2, black.getM_grade());
	            pstmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
	            pstmt.setString(4, "관리자권한");
	            pstmt.setString(5, "y");
	            
	            pstmt.executeUpdate();
				
	            pstmt = conn.prepareStatement("select * From BLACK_LIST where id = ?");
				pstmt.setString(1, black.getId());

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
	    
		//blackUCheckPro.jsp(P_ETC)
		public int deleteblack(String id) throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int x = -1;

			try {
				conn = getConnection();

				pstmt = conn.prepareStatement("select pwd from MEMBER where id = ?");
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();

				if (rs.next()) {
						pstmt = conn.prepareStatement("delete from BLACK_LIST where id=?");
						pstmt.setString(1, id);
						pstmt.executeUpdate();
						x = 1; // 제외 성공
					} else{
						x = 0; // 제외 실패
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

}
