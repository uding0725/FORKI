package DAO_DTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class FreeBoardDBBean {
	
	private static FreeBoardDBBean instance = new FreeBoardDBBean();
	
	public static FreeBoardDBBean getInstance(){
		return instance;
	}
	
	private Connection getConnection() throws Exception{
		String jdbcDriver = "jdbc:apache:commons:dbcp:/pool";
		return DriverManager.getConnection(jdbcDriver);
	}
	
	//게시글 등록
	public void insertArticle(FreeBoardDataBean article) throws Exception{
		
	}
	
	//글의 갯수조회
	public int getArticleCount() throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int x = 0;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement("select count(*) from board");
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				x = rs.getInt(1);
			} 
			
		} catch(Exception ex){
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {	rs.close();} catch (SQLException ex) {	}
			if (pstmt != null)
				try {	pstmt.close();} catch (SQLException ex) { }
			if (conn != null)
				try {	conn.close();} catch (SQLException ex) { }
		}
		return x;
	}
	
	
	public int getArticleCount(int searchn, String search) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int x = 0;
		String[] column_name = {"subject","content"};
		String[] mal_head = {"free","info","etc"};
		
		
		
		try{
			conn = getConnection();
			//"select count (*) from board where "+column_name[n]+" like '%"+searchKeyword+"%'"
			pstmt = conn.prepareStatement("select count(*) from board where "
		}
	}
	//글 페이지
	public int getArticles(int start, int end) throws Exception{
		return;
	}
	
	//글 목록
	public Vector getArticle(int num) throws Exception{
		return;
	}
	
	//변경할 글 내용가져오기
	public FreeBoardDataBean updateGetArticle(int num) throws Exception{
		return;
	}
	
	//게시글 수정
	public int updateArticle(FreeBoardDataBean article){
		return;
	}   
	
	//게시글 삭제
	public int deleteArticle(int num){
		return;
	}
	
	
}
