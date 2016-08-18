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

import DAO_DTO.MessageDataBean;

public class MessageDBBean {

	private static MessageDBBean instance = new MessageDBBean();

	public static MessageDBBean getInstance() {
		return instance;
	}

	private Connection getConnection() throws Exception {
		String jdbcDriver = "jdbc:apache:commons:dbcp:/pool";
		return DriverManager.getConnection(jdbcDriver);
	}

	// 쪽지보내기
	public void insertMessage(String sendId, String receiveId, String message) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("insert into MESSAGE values (image_num.nextVal, ?, ?, ?, '0', sysdate)");
			pstmt.setString(1, sendId);
			pstmt.setString(2, receiveId);
			pstmt.setString(3, message);
			pstmt.executeUpdate();
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

	}

	// 페이징을 위해 전체 DB에 입력된 행의 수 필요
	public int getMessageCount(String id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select count(*) from MESSAGE where RECEIVE_ID = ?");
			pstmt.setString(1, id);
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

	// 쪽지목록조회
	public List getMessageList(String id, int startRow, int endRow) throws Exception {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List messageList = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select r, NUM, SEND_ID, RECEIVE_ID, CONTENT, STATE, REG_DATE "
					+ "from (select rownum r, NUM, SEND_ID, RECEIVE_ID, CONTENT, STATE, REG_DATE "
					+ "from (select * from MESSAGE where RECEIVE_ID = ? order by num desc)order by r asc) "
					+ "where r >= ? and r <= ?");
			pstmt.setString(1, id);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				messageList = new ArrayList(endRow);
				do {
					MessageDataBean article = new MessageDataBean();
					article.setR(rs.getInt("r"));
					article.setNum(rs.getInt("NUM"));
					article.setSend_id(rs.getString("SEND_ID"));
					article.setReceive_id(rs.getString("RECEIVE_ID"));
					String subCon = rs.getString("CONTENT");
					if (subCon.length() >= 30)
						subCon = subCon.substring(0, 30) + "...";
					article.setContent(subCon);
					article.setState(rs.getString("STATE"));
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

	// 쪽지 상세보기
	public MessageDataBean selectMessage(String num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MessageDataBean DBdata = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("update MESSAGE set STATE = '1' where NUM = ?");
			pstmt.setString(1, num);
			pstmt.executeQuery();
			
			pstmt = conn.prepareStatement("select * from MESSAGE where NUM = ?");
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				DBdata = new MessageDataBean();
				DBdata.setSend_id(rs.getString("SEND_ID"));
				DBdata.setContent(rs.getString("CONTENT"));
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

	// 쪽지 삭제
	public int deleteMessage(String num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int x = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("delete from MESSAGE where NUM = ?");
			pstmt.setString(1, num);
			x = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return x;
	}

}
