package DAO_DTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import jdbc.JdbcUtil;

public class LogonDBBean {

	public static LogonDBBean instance = new LogonDBBean();
	
	public static LogonDBBean getInstance(){
		return instance;
	}
	
	private Connection getConnection() throws Exception{
		String jdbcDriver = "jdbc:apache:commons:dbcp:/pool";
		return DriverManager.getConnection(jdbcDriver);
	}
/*	
	//idã��
	public String searchId(String name, String email) throws Exception {
		return;
	}
	
	//��й�ȣã��
	public String searchPwd(String id, String name, String email) throws Exception {
		return;
	}
	
	//��й�ȣã��-�ӽú�й�ȣ
	public int updatePwd(String id, String pwd) throws Exception {
		return;
	}
	
	//ȸ������-����
	public void insertMember(LogonDataBean member, PetcDataBean petc, KidDataBean kid) throws Exception {
		
	}
	
	//ȸ������-���
	public void insertMember(LogondataBean member, KetcDataBean ketc) throws Exception {
		
	}
	
	//�α��νõ�
	public int userCheck(String id, String pwd) throws Exception{
		return;
	}
	
	//id�ߺ�Ȯ��
	public int cnfirmId(String id) throws Exception{
		return;
	}
	
	//ȸ�������ȸ
	public Vector getMember(String id) throws Exception{
		return;
	}
	
	//ȸ����������
	public int updateMember(LogonDataBean member) throws Exception{
		return;
	}
	
	//�����Ƚ��
	public int updateYellowcard(String id) throws Exception{
		return;
	}
	
	//ȸ�������� Ż��
	public int deleteMember(String id, String pwd, String del_reason) throws Exception{
		return;
	}
	
	//����Ż��
	public int deleteMember(String id, String del_reason) throws Exception{
		return;
	}
	//���ڵ� �ҷ�����
	public Vector zipcodeRead(String area4) throws Exception {
		return;
	}*/

	
}
