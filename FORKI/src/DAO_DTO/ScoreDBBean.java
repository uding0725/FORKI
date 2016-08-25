package DAO_DTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jdbc.JdbcUtil;

public class ScoreDBBean {

	private static ScoreDBBean instance = new ScoreDBBean();

	public static ScoreDBBean getInstance() {
		return instance;
	}

	private ScoreDBBean() {
	}

	private Connection getConnection() throws Exception {
		String jdbcDriver = "jdbc:apache:commons:dbcp:/pool";
		return DriverManager.getConnection(jdbcDriver);
	}

	// 참여여부 확인
	public int checkScore(String id, String kinderNum) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int check = 1;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from USER_SCORE where id = ? and SCHUL_NUM = ?");
			pstmt.setString(1, id);
			pstmt.setString(2, kinderNum);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				check = 0;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
			JdbcUtil.close(rs);
		}
		return check;
	}

	// 평점주기
	public void setScore(double total, int score, String kinderNum, int count, String id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("insert into USER_SCORE values (?,?,?)");
			pstmt.setString(1, kinderNum);
			pstmt.setString(2, id);
			pstmt.setInt(3, score);

			pstmt.executeQuery();

			pstmt = conn.prepareStatement("update TOTAL_SCORE set T_SCORE = ?, COUNT = ? where SCHUL_NUM = ?");
			pstmt.setDouble(1, total);
			pstmt.setInt(2, count);
			pstmt.setString(3, kinderNum);

			pstmt.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return;
	}

	// 총점가져오기
	public ScoreDataBean getTotal(String kinderNum) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ScoreDataBean DBdata = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from TOTAL_SCORE where SCHUL_NUM = ?");
			pstmt.setString(1, kinderNum);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				DBdata = new ScoreDataBean();
				DBdata.setT_score(rs.getString("T_SCORE"));
				DBdata.setCount(rs.getString("COUNT"));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
			JdbcUtil.close(rs);
		}
		return DBdata;
	}
}
