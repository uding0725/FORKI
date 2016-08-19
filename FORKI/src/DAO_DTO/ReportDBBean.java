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
			pstmt = conn.prepareStatement("select r, NUM, REPORTER, SUB_REPORT, LOCATION, CONTENT, REG_DATE "
					+ "from (select rownum r, NUM, REPORTER, SUB_REPORT, LOCATION, CONTENT, REG_DATE "
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
					article.setDate(rs.getTimestamp("REG_DATE"));
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
	public ReportDataBean selectReport(int num) throws Exception{
		return;
	}
	
	//�Ű��ڷ� ��ȸ�� �Ű��Ϻ���
	public Vector selectReport(String reporter) throws Exception{
		return;
	}
	
	//�Ű������� ��ȸ�� �Ű��Ϻ���
	public Vector selectReport(String sub_report) throws Exception{
		return;
	}
	
	
	
	
}
