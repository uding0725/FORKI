package DAO_DTO;

import java.sql.Connection;
import java.sql.DriverManager;


public class FrReplyDBBean {
	
	public static FrReplyDBBean instance = new FrReplyDBBean();
	
	public static FrReplyDBBean getInstance(){
		return instance;
	}
	
	private Connection getConnection() throws Exception{
		String jdbdDriver = "jdbc:apache:commons:dbcp:/pool";
		return DriverManager.getConnection(jdbdDriver);
	}
	
	//����Է�
	public void insertReply(FrReplyDataBean member) throws Exception{
		
	}
	
	//�����ȸ
	public Vector getReply(int num) throws Exception{
		return;
	}
	
	//��۰���
	public int getReplyCount(int num ) throws Exception{
		return ;
	}
	
	//��ۻ���
	public int deleteReply(int re_num, String writer, int num) throws Exception{
		return ;
	}
}
