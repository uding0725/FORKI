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
	
	//�Խñ� ���
	public void insertArticle(FreeBoardDataBean article) throws Exception{
		
	}
	
	//���� ������ȸ
	public int getArticleCount() throws Exception{
		return;
	}
	
	//�� ������
	public int getArticles(int start, int end) throws Exception{
		return;
	}
	
	//�� ���
	public Vector getArticle(int num) throws Exception{
		return;
	}
	
	//������ �� ���밡������
	public FreeBoardDataBean updateGetArticle(int num) throws Exception{
		return;
	}
	
	//�Խñ� ����
	public int updateArticle(FreeBoardDataBean article){
		return;
	}   
	
	�Խñ� ����
	public int deleteArticle(int num){
		return;
	}
	
	
}
