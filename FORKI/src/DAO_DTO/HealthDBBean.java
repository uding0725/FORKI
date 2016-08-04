package DAO_DTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

//아이 예방접종표 DAO


public class HealthDBBean {

	private static HealthDBBean instance= new HealthDBBean();
	
	public static HealthDBBean getInstance()throws Exception{
		
		return instance;
	}
	
	private HealthDBBean(){}
	
	private Connection getConnection()throws Exception{
		String jdbcDriver="jdbc:apache:commons:dbcp:/pool";
		return DriverManager.getConnection(jdbcDriver);
	}
	//문진표입력
	public void insertHealth(HealthDataBean member)throws Exception{
	}
	//문진표출력
	public List selectHealth(String id, String nick_name2,int num)throws Exception{
		
	}
	//문진표 수정
	public int updateHealth(String id,String nick_name2,int num)throws Exception{
		
	}
	public int deleteHealth(String id,String nick_name2,int num)throws Exception{
		
	}
	
}
