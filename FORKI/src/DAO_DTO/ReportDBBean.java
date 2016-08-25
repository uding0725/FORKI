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

public class ReportDBBean {

	private static ReportDBBean instance = new ReportDBBean();
	
	public static ReportDBBean getInstance(){
		return instance;
	}
	
	public Connection getConnection() throws Exception{
		String jdbcDriver = "jdbc:apache:commons:dbcp:/pool";
		return DriverManager.getConnection(jdbcDriver); 
		 
	}
	
	//�Ű�����
	public void insertReport(ReportDataBean member) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement("insert into report_list(num,reporter,sub_report,location,content,r_date) values(report_num.NEXTVAl,?,?,?,?,?)");
			pstmt.setString(1,member.getReporter());
			pstmt.setString(2, member.getSub_report());
			pstmt.setString(3, member.getLocation());
			pstmt.setString(4, member.getContent());
			pstmt.setTimestamp(5, member.getR_date());
			
			pstmt.executeUpdate();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
	}

	// ����¡�� ���� ��ü DB�� �Էµ� ���� �� �ʿ�
	public int getReportCount() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select count(*) from REPORT_LIST");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				x = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return x;
	}
	
	// �Ű��� ��ȸ
	public List getReportList(int startRow, int endRow) throws Exception {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List messageList = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select r, NUM, REPORTER, SUB_REPORT, LOCATION, CONTENT, R_DATE "
					+ "from (select rownum r, NUM, REPORTER, SUB_REPORT, LOCATION, CONTENT, R_DATE "
					+ "from (select * from REPORT_LIST) order by r asc) where r >= ? and r <= ?");
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				messageList = new ArrayList(endRow);
				do {
					ReportDataBean article = new ReportDataBean();
					article.setNum(rs.getInt("NUM"));
					article.setReporter(rs.getString("REPORTER"));
					article.setSub_report(rs.getString("SUB_REPORT"));
					article.setLocation(rs.getString("LOCATION"));
					String subCon = rs.getString("CONTENT");
					if (subCon.length() >= 10)
						subCon = subCon.substring(0, 10) + "...";
					article.setContent(subCon);
					article.setR_date(rs.getTimestamp("R_DATE"));
					messageList.add(article);
				} while (rs.next());
			}
			
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
		return messageList;
	}
	
	//�Ű� �󼼺���
	public ReportDataBean selectReport(String num) throws Exception{

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ReportDataBean DBdata = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from REPORT_LIST where num = ?");
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				DBdata = new ReportDataBean();
				DBdata.setNum(rs.getInt(1));
				DBdata.setReporter(rs.getString(2));
				DBdata.setSub_report(rs.getString(3));
				DBdata.setLocation(rs.getString(4));
				DBdata.setContent(rs.getString(5));
				DBdata.setR_date(rs.getTimestamp(6));
			}
			
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
		return DBdata;
	}
	
	//�Ű��Ϻ��� ���̵�� ��ȸ
	public List selectReportId(String type, String id, int startRow , int endRow) throws Exception{

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List messageList = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select r, NUM, REPORTER, SUB_REPORT, LOCATION, CONTENT, R_DATE "
					+ "from (select rownum r, NUM, REPORTER, SUB_REPORT, LOCATION, CONTENT, R_DATE "
					+ "from (select * from REPORT_LIST where ? = ?) order by r asc) where r >= ? and r <= ?");
			pstmt.setString(1, type);
			pstmt.setString(1, id);
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				messageList = new ArrayList(endRow);
				do {
					ReportDataBean article = new ReportDataBean();
					article.setNum(rs.getInt("NUM"));
					article.setReporter(rs.getString("REPORTER"));
					article.setSub_report(rs.getString("SUB_REPORT"));
					article.setLocation(rs.getString("LOCATION"));
					String subCon = rs.getString("CONTENT");
					if (subCon.length() >= 10)
						subCon = subCon.substring(0, 10) + "...";
					article.setContent(subCon);
					article.setR_date(rs.getTimestamp("R_DATE"));
					messageList.add(article);
				} while (rs.next());
			}
			
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
		return messageList;
	}
	
}
