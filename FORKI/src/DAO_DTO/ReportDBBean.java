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
	
	//�Ű�����
	public void insertReport(ReportDataBean member) throws Exception{
		
	}
	
	// �Ű��� ��ȸ
	public Vector selectReport() throws Exception{		
		return;
	}
	
	//�Ű� �󼼺���
	public ReportDataBean selectReport(int num) throws Exception{
		return;
	}
	
	//�Ű��ڷ� ��ȸ�� �Ű��Ϻ���
	public Vector selectReport(String reporter) throws Exception{
		return;
	}
	
	//�Ű������� ��ȸ�� �Ű��Ϻ���
	public Vector selectReport(String sub_report) throws Exception{
		return;
	}
	
	
	
	
}
