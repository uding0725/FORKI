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
	//유치원 유치원명선택
	public Vector selectKid(String matr_gu, String schul_nm)throws Exception{
		
	}
	//유치원 동선택
	public Vector selectKid(String matr_gu,String dong)throws Exception{
		
	}
	//main에서 지도 클릭시 
	public Vector selectKid(String matr_gu)throws Exception{
		
	}
	//유치원 상세보기
	public KiderDataBean selectDetKid(String schul_nm)throws Exception{
	}
	//유치원 등록
	public void insertKid(KiderDataBean kidmember)throws Exception{
	}
}
