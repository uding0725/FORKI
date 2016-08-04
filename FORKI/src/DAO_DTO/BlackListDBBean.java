package DAO_DTO;
//블랙리스트 DAO

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Vector;

public class BlackListDBBean {

	private static BlackListDBBean instance=new BlackListDBBean();
	
	public static BlackListDBBean getInstance()throws Exception{
		return instance;
	}
	private BlackListDBBean(){}
	
	private Connection getConnection()throws Exception{
		String jdbcDriver="jdbc:apache:commons:jdbc:/pool";
		return DriverManager.getConnection(jdbcDriver);
	}
	
	public void insertBList(BlackListDataBean Blist)throws Exception{
		
	}
	
	public int updateBList(String id)throws Exception{
		
	}
	public Vector selectBL()throws Exception{
		
	}
	
	public BlackListDataBean selectBLDet(String id)throws Exception{
		
	}
}
