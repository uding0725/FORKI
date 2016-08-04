package DAO_DTO;

import java.sql.Connection;
import java.sql.DriverManager;

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
		return;
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
	
	게시글 삭제
	public int deleteArticle(int num){
		return;
	}
	
	
}
