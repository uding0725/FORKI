package DAO_DTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Vector;

public class KiderDBBean {

	private static KiderDBBean instance= new KiderDBBean();
	
	public static KiderDBBean getInstance(){
		return instance;
	}
	
	private KiderDBBean(){}
	
	private Connection getConnection()throws Exception{
		String jdbcDriver="jdbc:apache:commons:dbcp:/pool";
		return DriverManager.getConnection(jdbcDriver);
	}
	//��ġ�� ��ġ������
	public Vector selectKid(String matr_gu, String schul_nm)throws Exception{
		
	}
	//��ġ�� ������
	public Vector selectKid(String matr_gu,String dong)throws Exception{
		
	}
	//main���� ���� Ŭ���� 
	public Vector selectKid(String matr_gu)throws Exception{
		
	}
	//��ġ�� �󼼺���
	public KiderDataBean selectDetKid(String schul_nm)throws Exception{
	}
	//��ġ�� ���
	public void insertKid(KiderDataBean kidmember)throws Exception{
	}
}
