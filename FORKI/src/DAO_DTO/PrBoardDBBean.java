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
	//���ǻ���
	public void insertArticle(PrBoardDataBean article)throws Exception{
		
	}
	//���ǻ��� �۰����� �ҷ���
	public int getArticleCount()throws Exception{
	}
	//���ǻ��� ����¡
	public Vector getArticles(int start,int end)throws Exception{
	}
	//���ǻ��� ���� �������
	public PrBoardDataBean getArticle(int num)throws Exception{
		
	}
	//�� ������ ���� �������
	public PrBoardDataBean updateGetArticle(int num)throws Exception{
		
	}
	//���� �� �����κ�
	public int updateArticle(PrBoardDataBean article)throws Exception{
		
	}
	//�ۻ���
	public int deleteArticle(int num)throws Exception{
		
	} 
}
