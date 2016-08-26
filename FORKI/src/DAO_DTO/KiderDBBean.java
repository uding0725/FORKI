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

public class KiderDBBean {

	private static KiderDBBean instance = new KiderDBBean();

	public static KiderDBBean getInstance() {
		return instance;
	}

	private KiderDBBean() {
	}

	private Connection getConnection() throws Exception {
		String jdbcDriver = "jdbc:apache:commons:dbcp:/pool";
		return DriverManager.getConnection(jdbcDriver);
	}

	public KiderDataBean selectDetKid(String SCHUL_NUM) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		KiderDataBean DBdata = null;
		try {
			conn = getConnection();
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

	public KiderDataBean selectKid(int SCHUL_NUM) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		KiderDataBean DBdata = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * From KINDERGARTEN where SCHUL_NUM = ?");
			pstmt.setInt(1, SCHUL_NUM);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				DBdata = new KiderDataBean();
				DBdata.setSchul_nm(rs.getString("schul_nm"));
				DBdata.setSchul_num(rs.getInt("schul_num"));
				DBdata.setOfcdc(rs.getString("ofcdc"));
				DBdata.setMatr_gu(rs.getString("matr_gu"));
				DBdata.setDong(rs.getString("dong"));
				DBdata.setFond(rs.getString("fond"));
				DBdata.setZip(rs.getString("zip"));
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

	public void insertKid(KiderDataBean kidmember) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(
					"insert into kindergarten(schul_nm,schul_num,ofcdc,matr_gu,fond,zip,adres,dong,telno,clas_co,stdnt_co_sm,grlstdn_co,frl_tcher_co_sm,frl_female_tcher_co,rm,state,reg_date) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, kidmember.getSchul_nm());
			pstmt.setInt(2, kidmember.getSchul_num());
			pstmt.setString(3, kidmember.getOfcdc());
			pstmt.setString(4, kidmember.getMatr_gu());
			pstmt.setString(5, kidmember.getFond());
			pstmt.setString(6, kidmember.getZip());
			pstmt.setString(7, kidmember.getAdres());
			pstmt.setString(8, kidmember.getDong());
			pstmt.setString(9, kidmember.getTelno());
			pstmt.setInt(10, kidmember.getClas_co());
			pstmt.setInt(11, kidmember.getStdnt_co_sm());
			pstmt.setInt(12, kidmember.getGrlstdn_co());
			pstmt.setInt(13, kidmember.getFrl_tcher_co_sm());
			pstmt.setInt(14, kidmember.getFrl_female_tcher_co());
			pstmt.setString(15, kidmember.getRm());
			pstmt.setString(16, kidmember.getState());
			pstmt.setTimestamp(17, kidmember.getReg_date());
			pstmt.executeUpdate();
			pstmt = con.prepareStatement("insert into total_score(schul_num,t_score,count) values(?,0,0)");
			pstmt.setInt(1, kidmember.getSchul_num());
			pstmt.executeUpdate();
			con.commit();
		} catch (SQLException e) {

			e.printStackTrace();

			JdbcUtil.rollback(con);
		} finally {

			JdbcUtil.close(pstmt);
			JdbcUtil.close(con);
			if (con != null) {
				con.setAutoCommit(false);
			}

		}
	}

	public int getCountKider() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select count(*) from kindergarten where state='n'");
			rs = pstmt.executeQuery();

			if (rs.next())
				x = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return x;
	}

	public int getCountKider(int sn, String search) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = 0;
		String[] col_name = { "id", "schul_nm" };
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select count(*) from kindergarten natural join k_etc where " + col_name[sn] + " like '%" + search + "%'" + " and state='n'");
			rs = pstmt.executeQuery();

			if (rs.next())
				x = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return x;
	}

	public Vector signKinder(int start, int end) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Vector vecList = new Vector();
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select schul_nm,schul_num,reg_date,state,id,r" + " from (select schul_nm,schul_num,reg_date,state,id, rownum r from "
					+ "(select schul_nm,schul_num,reg_date,state,id from kindergarten natural join k_etc order by reg_date )"
					+ " where state='n' order by reg_date) where r>=? and r<=?");
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					KiderDataBean tempkdb = new KiderDataBean();
					KetcDataBean ketcdb = new KetcDataBean();
					ketcdb.setId(rs.getString("id"));
					tempkdb.setKdb(ketcdb);
					tempkdb.setSchul_num(rs.getInt("schul_num"));
					tempkdb.setSchul_nm(rs.getString("schul_nm"));
					tempkdb.setState(rs.getString("state"));
					tempkdb.setReg_date(rs.getTimestamp("reg_date"));
					vecList.addElement(tempkdb);
				} while (rs.next());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(rs);
			JdbcUtil.close(conn);
		}
		return vecList;
	}

	public Vector signKinder(int start, int end, int n, String search) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String[] col_nm = { "id", "schul_nm" };
		Vector vecList = new Vector();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select schul_nm,schul_num,reg_date,state,id,r" + " from (select schul_nm,schul_num,reg_date,state,id, rownum r from "
					+ "(select schul_nm,schul_num,reg_date,state,id from kindergarten natural join k_etc order by reg_date )" + " where state='n' and " + col_nm[n] + " like '%"
					+ search + "%' order by reg_date) where r>=? and r<=?");
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					KiderDataBean tempkdb = new KiderDataBean();
					KetcDataBean ketcdb = new KetcDataBean();
					ketcdb.setId(rs.getString("id"));
					tempkdb.setKdb(ketcdb);
					tempkdb.setSchul_num(rs.getInt("schul_num"));
					tempkdb.setSchul_nm(rs.getString("schul_nm"));
					tempkdb.setState(rs.getString("state"));
					tempkdb.setReg_date(rs.getTimestamp("reg_date"));
					vecList.addElement(tempkdb);
				} while (rs.next());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(rs);
			JdbcUtil.close(conn);
		}
		return vecList;
	}

	public void updateState(int schul_num) throws Throwable {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();
			pstmt = con.prepareStatement("update kindergarten set state='y' where schul_num=?");
			pstmt.setInt(1, schul_num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(con);
		}
	}

	public void delKinder(int schul_num) throws Throwable {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("delete from kindergarten where schul_num=?");
			pstmt.setInt(1, schul_num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
	}

	public Vector selectKinder(int gunum, String dong, String schul_nm) throws Throwable {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Vector vecList = new Vector();
		String Dong = dong;
		String Schul_nm = schul_nm;

		String schul_num="";
		String t_score="";

		String[] gunm = { "전체", "강남구", "강동구", "강북구", "강서구", "관악구", "광진구", "구로구", "금천구", "노원구", "도봉구", "동대문구", "동작구", "마포구", "서대문구", "서초구", "성동구", "성북구", "송파구", "양천구", "영등포구",
				"용산구", "은평구", "종로구", "중랑구", "중구" };
		try {

			conn = getConnection();
			if (gunum == 0) {
				if (Dong.equals("") && Schul_nm.equals("")) {
					pstmt = conn.prepareStatement("select schul_num,schul_nm,adres,telno,x,y,t_score,count from kindergarten natural join total_score");
				} else if (!Dong.equals("") && Schul_nm.equals("")) {
					pstmt = conn.prepareStatement("select schul_num,schul_nm,adres,telno,x,y,t_score,count from kindergarten natural join total_score where dong like '%"+Dong+"%'");
				} else if (Dong.equals("") && !Schul_nm.equals("")) {
					pstmt = conn.prepareStatement("select schul_num,schul_nm,adres,telno,x,y,t_score,count from kindergarten natural join total_score where schul_nm like '%"+schul_nm+"%'");
				} else {
					pstmt = conn.prepareStatement("select schul_num,schul_nm,adres,telno,x,y,t_score,count from kindergarten natural join total_score where schul_nm like '%"+schul_nm+"%' and dong like '%"+schul_nm+"%'");
	
				}
			} else {
				if (Dong.equals("") && Schul_nm.equals("")) {
					pstmt = conn.prepareStatement(
							"select schul_num,schul_nm,adres,telno,x,y,t_score,count from kindergarten natural join total_score where matr_gu=" + "'" + gunm[gunum] + "'");

				} else if (!Dong.equals("") && Schul_nm.equals("")) {
					pstmt = conn.prepareStatement("select schul_num,schul_nm,adres,telno,x,y,t_score,count from kindergarten natural join total_score where matr_gu=" + "'"
							+ gunm[gunum] + "'" + " and dong like '%"+Dong+"%'");
			
				} else if (Dong.equals("") && !Schul_nm.equals("")) {
					pstmt = conn.prepareStatement("select schul_num,schul_nm,adres,telno,x,y,t_score,count from kindergarten natural join total_score where matr_gu=" + "'"
							+ gunm[gunum] + "'" + " and schul_nm like '%"+schul_nm+"%'");
				} else {
					pstmt = conn.prepareStatement("select schul_num,schul_nm,adres,telno,x,y,t_score,count from kindergarten natural join total_score where matr_gu=" + "'"
							+ gunm[gunum] + "'" + " and schul_nm like '%"+schul_nm+"%' and dong like '%"+schul_nm+"%'");
			
				}
			}
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					KiderDataBean kdb = new KiderDataBean();
					TSDataBean tdata = new TSDataBean();

					schul_num=rs.getString("schul_num");
			
					t_score= getTotal(schul_num);

					tdata.setT_score(t_score);
					tdata.setCount(rs.getString("count"));
					kdb.setTsdata(tdata);
					kdb.setSchul_num(rs.getInt("schul_num"));
					kdb.setSchul_nm(rs.getString("schul_nm"));
					kdb.setAdres(rs.getString("adres"));
					kdb.setTelno(rs.getString("telno"));
					kdb.setX(rs.getDouble("x"));
					kdb.setY(rs.getDouble("y"));
					vecList.addElement(kdb);
				} while (rs.next());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return vecList;
	}

	public int checkKinder(int schul_num) throws Throwable {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select*from kindergarten where schul_num=? and state='y'");
			pstmt.setInt(1, schul_num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				x = 1;
			}
			pstmt = conn.prepareStatement("select*from kindergarten where schul_num=? and state='n'");
			pstmt.setInt(2, schul_num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				x = 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}

		return x;
	}

	public String getFavorite(String id) throws Throwable {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String favoriteList = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select FAVORITE from P_ETC where id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				favoriteList = rs.getString("FAVORITE");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}

		return favoriteList;
	}

	public List getList(String favoriteList) throws Throwable {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int size = 0;
		int check = 0;
		String[] arr = null;
		if (favoriteList != null) {
			arr = favoriteList.split("@");
			size = arr.length;
		} else {
			check = -1;
		}
		List favorList = null;
		favorList = new ArrayList(size);

		try {
			conn = getConnection();
			if (check != -1) {
				for (String value : arr) {
					pstmt = conn.prepareStatement("select * from KINDERGARTEN where SCHUL_NUM = ?");
					pstmt.setString(1, value);
					rs = pstmt.executeQuery();
					int i = 0;
					if (rs.next()) {
						do {
							KiderDataBean article = new KiderDataBean();
							article.setSchul_num(Integer.parseInt(rs.getString("schul_num")));
							article.setSchul_nm(rs.getString("schul_nm"));
							article.setAdres(rs.getString("adres"));
							article.setTelno(rs.getString("telno"));
							article.setClas_co(rs.getInt("clas_co"));
							article.setStdnt_co_sm(rs.getInt("stdnt_co_sm"));
							article.setGrlstdn_co(rs.getInt("grlstdn_co"));
							article.setFrl_tcher_co_sm(rs.getInt("frl_tcher_co_sm"));
							article.setFrl_female_tcher_co(rs.getInt("frl_female_tcher_co"));
							article.setRm(rs.getString("rm"));
							i++;
							favorList.add(article);
						} while (rs.next());
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}

		return favorList;
	}

	/* 총점을 가져오기 */
	public String getTotal(String SCHUL_NUM) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		KiderDataBean DBdata = null;
		String totalPer = "0%";
		double total = 0;
		int check = 0;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select count(*) From TOTAL_SCORE where SCHUL_NUM = ?");
			pstmt.setString(1, SCHUL_NUM);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				check = rs.getInt(1);
			}
			if (check > 0) {
				pstmt = conn.prepareStatement("select T_SCORE From TOTAL_SCORE where SCHUL_NUM = ?");
				pstmt.setString(1, SCHUL_NUM);
				rs = pstmt.executeQuery();

				if (rs.next()) {
					total = Double.parseDouble(rs.getString("T_SCORE")) * 20;
					totalPer = total + "%";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return totalPer;
	}

	/* 이미지 등록여부 확인 */
	public int imgCheck(String num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int check = 0;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select count(*) From IMAGES where SCHUL_NUM = ?");
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				check = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return check;
	}

	public int updateKinder(KiderDataBean kdata) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int x = 0;
		String sql = "";
		try {
			conn = getConnection();
			sql = "update kindergarten set schul_nm=?,ofcdc=?,matr_gu=?,dong=?,fond=?,telno=?,zip=?,adres=?,";
			sql += "stdnt_co_sm=?,grlstdn_co=?,clas_co=?,frl_tcher_co_sm=?,frl_female_tcher_co=?,rm=? where schul_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, kdata.getSchul_nm());
			pstmt.setString(2, kdata.getOfcdc());
			pstmt.setString(3, kdata.getMatr_gu());
			pstmt.setString(4, kdata.getDong());
			pstmt.setString(5, kdata.getFond());
			pstmt.setString(6, kdata.getTelno());
			pstmt.setString(7, kdata.getZip());
			pstmt.setString(8, kdata.getAdres());
			pstmt.setInt(9, kdata.getStdnt_co_sm());
			pstmt.setInt(10, kdata.getGrlstdn_co());
			pstmt.setInt(11, kdata.getClas_co());
			pstmt.setInt(12, kdata.getFrl_tcher_co_sm());
			pstmt.setInt(13, kdata.getFrl_female_tcher_co());
			pstmt.setString(14, kdata.getRm());
			pstmt.setInt(15, kdata.getSchul_num());
			x = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return x;
	}
	// 이미지를 저장
	public int insertImg(ImgDataBean DBdata) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int check = 0;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("insert into IMAGES values (?,?,?,?)");
			pstmt.setString(1, DBdata.getSchul_num());
			pstmt.setString(2, DBdata.getFile_name());
			pstmt.setString(3, DBdata.getPath());
			pstmt.setString(4, DBdata.getMessage());
			
			rs = pstmt.executeQuery();

			if (rs.next()) {
				check = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return check;
	}

	/* 이미지 정보 가져오기 */
	public List getImgList(String id, int check) throws Exception {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List imgList = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from IMAGES where SCHUL_NUM = ?");
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				imgList = new ArrayList(check);
				do {
					ImgDataBean article = new ImgDataBean();
					String realPath = rs.getString(3) + "\\" + rs.getString(2);
					article.setPath(realPath);
					article.setFile_name(rs.getString(2));
					article.setMessage(rs.getString(4));
					imgList.add(article);
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
		return imgList;
	}
	
	/* 이미지 삭제*/
	public int deleteImg(String schul_num, String name) throws Exception {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int check = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("delete from IMAGES where SCHUL_NUM = ? and FILE_NAME = ?");
			pstmt.setString(1, schul_num);
			pstmt.setString(2, name);

			rs = pstmt.executeQuery();
			
			pstmt = conn.prepareStatement("select count(*) from IMAGES where SCHUL_NUM = ? and FILE_NAME = ?");
			pstmt.setString(1, schul_num);
			pstmt.setString(2, name);
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				check = rs.getInt(1);
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
		return check;
	}
	
	/* 관심유치원 등록 */
	public int setFavor(String id, String kinderNum) throws Exception {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int check = 0;
		String favor = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from P_ETC where id = ?");
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				favor = rs.getString(5);
				if (favor != null) {
					if (favor.contains(kinderNum)) {
						return check = -1;
					}
					favor = favor + "@" + kinderNum;
				} else {
					favor = kinderNum;
				}
				pstmt = conn.prepareStatement("update P_ETC set FAVORITE = ? where id = ?");
				pstmt.setString(1, favor);
				pstmt.setString(2, id);
				pstmt.executeQuery();
				check = 1;
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
		return check;
	}
	
	/* 관심유치원 등록여부 확인 */
	public int checkFavor(String id, String kinderNum) throws Exception {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int check = 0;
		String favor = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from P_ETC where id = ?");
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				favor = rs.getString(5);
				if (favor.contains(kinderNum)) 
					check = 1;
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
		return check;
	}
	
	/* 관심유치원 삭제 */
	public int deleteFavor(String id, String kinderNum) throws Exception {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int check = 0;
		String favor = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from P_ETC where id = ?");
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				favor = rs.getString(5);
				if (favor.contains("@" + kinderNum)) {
					kinderNum = "@" + kinderNum;
					favor = favor.replace(kinderNum, "");
				} else if (favor.contains(kinderNum + "@")) {
					kinderNum = kinderNum +  "@";
					favor = favor.replace(kinderNum, "");
				} else {
					favor = favor.replace(kinderNum, "");
				}
				pstmt = conn.prepareStatement("update P_ETC set FAVORITE = ? where id = ?");
				pstmt.setString(1, favor);
				pstmt.setString(2, id);
				pstmt.executeQuery();
				check = 1;
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
		return check;
	}
	
}
