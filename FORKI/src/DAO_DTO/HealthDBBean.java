package DAO_DTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

//���� ��������ǥ DAO


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
	//����ǥ�Է�
	public void insertHealth(HealthDataBean member)throws Exception{
	}
	//����ǥ���
	public List selectHealth(String id, String nick_name2,int num)throws Exception{
		
	}
	//����ǥ ����
	public int updateHealth(String id,String nick_name2,int num)throws Exception{
		
	}
	public int deleteHealth(String id,String nick_name2,int num)throws Exception{
		
	}
	
}
