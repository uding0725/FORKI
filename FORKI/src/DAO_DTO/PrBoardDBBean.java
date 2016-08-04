package DAO_DTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Vector;

public class PrBoardDBBean {

	private static PrBoardDBBean instance=new PrBoardDBBean();
	
	public static PrBoardDBBean getInstance(){
		return instance;
	}
	
	private PrBoardDBBean(){}
	
	private Connection getConnection()throws Exception{
		String jdbcDriver="jdbc:apache:commons:dbcp:/pool";
		return DriverManager.getConnection(jdbcDriver);
	}
	//건의사항
	public void insertArticle(PrBoardDataBean article)throws Exception{
		
	}
	//건의사항 글개수를 불러옴
	public int getArticleCount()throws Exception{
	}
	//건의사항 페이징
	public Vector getArticles(int start,int end)throws Exception{
	}
	//건의사항 글을 가지고옴
	public PrBoardDataBean getArticle(int num)throws Exception{
		
	}
	//글 수정할 글을 가지고옴
	public PrBoardDataBean updateGetArticle(int num)throws Exception{
		
	}
	//실제 글 수정부분
	public int updateArticle(PrBoardDataBean article)throws Exception{
		
	}
	//글삭제
	public int deleteArticle(int num)throws Exception{
		
	} 
}
