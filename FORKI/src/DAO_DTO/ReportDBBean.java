package DAO_DTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Vector;

public class ReportDBBean {

	private static ReportDBBean instance = new ReportDBBean();
	
	public static ReportDBBean getInstance(){
		return instance;
	}
	
	public Connection getConnection() throws Exception{
		String jdbcDriver = "jdbc:apache:commons:dbcp:/pool";
		return DriverManager.getConnection(jdbcDriver);
		
	}
	
	//신고접수
	public void insertReport(ReportDataBean member) throws Exception{
		
	}
	
	// 신고목록 조회
	public Vector selectReport() throws Exception{		
		return;
	}
	
	//신고 상세보기
	public ReportDataBean selectReport(int num) throws Exception{
		return;
	}
	
	//신고자로 조회된 신고목록보기
	public Vector selectReport(String reporter) throws Exception{
		return;
	}
	
	//신고대상으로 조회된 신고목록보기
	public Vector selectReport(String sub_report) throws Exception{
		return;
	}
	
	
	
	
}
