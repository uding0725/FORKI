package DAO_DTO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ScoreDBBean {

	private static ScoreDBBean instance=new ScoreDBBean();
	
	public static ScoreDBBean getInstance(){
		return instance;
	}
	private ScoreDBBean(){}
	
	private Connection getConnection()throws Exception{
		String jdbcDriver="jdbc:apache:commons:dbcp:/pool";
		return DriverManager.getConnection(jdbcDriver);
	}
	//����������Ʈ
	public void updateTS(int schul_num,String score)throws Exception{
		
	}
	
	//�����ֱ�
	public void insertUS(USDataBean usdata)throws Exception{
		
	}
	
	//������ �Z���� �ȢZ���� üũ
	public int checkUS(String id, int schul_num){
		
	}
	//���������ֱ�
	public Vector selectTS(int schul_num,String score){
		
	}
}
