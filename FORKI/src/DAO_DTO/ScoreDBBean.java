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
	//총점업데이트
	public void updateTS(int schul_num,String score)throws Exception{
		
	}
	
	//평점주기
	public void insertUS(USDataBean usdata)throws Exception{
		
	}
	
	//평점을 줫는지 안줫는지 체크
	public int checkUS(String id, int schul_num){
		
	}
	//총점보여주기
	public Vector selectTS(int schul_num,String score){
		
	}
}
