package DAO_DTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//아이 예방접종표 DAO

public class HealthDBBean {

	private static HealthDBBean instance = new HealthDBBean();

	public static HealthDBBean getInstance() throws Exception {

		return instance;
	}

	private HealthDBBean() {
	}

	private Connection getConnection() throws Exception {
		String jdbcDriver = "jdbc:apache:commons:dbcp:/pool";
		return DriverManager.getConnection(jdbcDriver);
	}

	// 문진표출력
	public List getChart(String id) throws Exception {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;
		List chartList = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select count(*) from HEALTH_CHECK where id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				x = rs.getInt(1);
			}

			pstmt = conn.prepareStatement("select * from HEALTH_CHECK where id = ? order by num");
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				chartList = new ArrayList(x);
				do {
					HealthDataBean article = new HealthDataBean();
					article.setX(x);
					article.setNum(rs.getInt(2));
					article.setName(rs.getString(3));
					article.setBcg(rs.getInt(4));
					article.setHepb(rs.getInt(5));
					article.setDtap(rs.getInt(6));
					article.setTdap(rs.getInt(7));
					article.setIpv(rs.getInt(8));
					article.setPrp_t(rs.getInt(9));
					article.setPcv(rs.getInt(10));
					article.setPpsv(rs.getInt(11));
					article.setMmr(rs.getInt(12));
					article.setVar(rs.getInt(13));
					article.setHepa(rs.getInt(14));
					article.setJev(rs.getInt(15));
					article.setJe(rs.getInt(16));
					article.setFlu_d(rs.getTimestamp(17));
					article.setFlu_l(rs.getTimestamp(18));
					article.setBdg_m(rs.getInt(19));
					article.setRv1(rs.getInt(20));
					article.setRv5(rs.getInt(21));
					article.setHpv_g(rs.getInt(22));
					article.setHpv_c(rs.getInt(23));
					chartList.add(article);
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
		return chartList;
	}

	// 문진표 수정
	public void updateHealth(String id, HealthDataBean DBdata) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("update HEALTH_CHECK" + " set BCG = ?, HEPB = ?, DTAP = ?, TDAP = ?, IPV = ?, PRP_T = ?, PCV = ?, MMR = ?,"
					+ " VAR = ?, HEPA = ?, JEV = ?, JE = ?, BDG_M = ?, RV1 = ?, RV5 = ?, HPV_G = ?, HPV_C = ?" + " where ID = ? and NUM = ?");
			pstmt.setInt(1, DBdata.getBcg());
			pstmt.setInt(2, DBdata.getHepb());
			pstmt.setInt(3, DBdata.getDtap());
			pstmt.setInt(4, DBdata.getTdap());
			pstmt.setInt(5, DBdata.getIpv());
			pstmt.setInt(6, DBdata.getPrp_t());
			pstmt.setInt(7, DBdata.getPcv());
			pstmt.setInt(8, DBdata.getMmr());
			pstmt.setInt(9, DBdata.getVar());
			pstmt.setInt(10, DBdata.getHepa());
			pstmt.setInt(11, DBdata.getJev());
			pstmt.setInt(12, DBdata.getJe());
			pstmt.setInt(13, DBdata.getBdg_m());
			pstmt.setInt(14, DBdata.getRv1());
			pstmt.setInt(15, DBdata.getRv5());
			pstmt.setInt(16, DBdata.getHpv_g());
			pstmt.setInt(17, DBdata.getHpv_c());
			pstmt.setString(18, id);
			pstmt.setInt(19, DBdata.getNum());

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
	
	// 아이정보출력
		public List getKid(String id) throws Exception {

			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			int x = 0;
			List kidList = null;
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement("select count(*) from KID_DATA where id = ?");
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();

				if (rs.next()) {
					x = rs.getInt(1);
				}

				pstmt = conn.prepareStatement("select * from KID_DATA where id = ? order by num");
				pstmt.setString(1, id);

				rs = pstmt.executeQuery();

				if (rs.next()) {
					kidList = new ArrayList(x);
					do {
						KidDataBean article = new KidDataBean();
						article.setNum(rs.getInt("num"));
						article.setName(rs.getString("name"));
						article.setSchul_nm(rs.getString("schul_nm"));
						kidList.add(article);
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
			return kidList;
		}


	// 아이정보 수정
	public void updateKid(String id, int size, List DBdata) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("delete from HEALTH_CHECK where id = ?");
			pstmt.setString(1, id);
			pstmt.executeQuery();
			
			pstmt = conn.prepareStatement("delete from KID_DATA where id = ?");
			pstmt.setString(1, id);
			pstmt.executeQuery();

			for (Object obj : DBdata) {
				KidDataBean p = (KidDataBean) obj;
				pstmt = conn.prepareStatement("insert into KID_DATA values (?, ?, ?, ?)");
				pstmt.setString(1, id);
				pstmt.setInt(2, p.getNum());
				pstmt.setString(3, p.getName());
				pstmt.setString(4, p.getSchul_nm());
				pstmt.executeQuery();

				pstmt = conn.prepareStatement(
						"insert into HEALTH_CHECK" + " (ID, NUM, NAME, BCG, HEPB, DTAP, TDAP, IPV, PRP_T, PCV, PPSV, MMR, VAR, HEPA, JEV, JE, BDG_M, RV1, RV5, HPV_G, HPV_C)"
								+ " values(?, ?, ?, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)");
				pstmt.setString(1, id);
				pstmt.setInt(2, p.getNum());
				pstmt.setString(3, p.getName());

				pstmt.executeQuery();
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
	}
}
