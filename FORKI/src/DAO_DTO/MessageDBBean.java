package DAO_DTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

public class MessageDBBean {
	
	private static MessageDBBean instance = new MessageDBBean();
	
	public static MessageDBBean getInstance(){
		return instance;
	}
	
	private Connection getConnection() throws Exception{
		String jdbcDriver = "jdbc:apache:commons:dbcp:/pool";
		return DriverManager.getConnection(jdbcDriver);
	}
	
	//����������
	public void insertMessage(MessageDataBean member) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(/*sql */);
			pstmt.setString(parameterIndex, x);
			pstmt.executeUpdate();
		} catch(Exception ex){
			ex.printStackTrace();
		} finally{
			if(pstmt != null) try{ pstmt.close();} catch(SQLException ex){}
			if(conn != null) try{conn.close();} catch(SQLException ex){}
		}
		
		
	}
	
	//���������ȸ
	public Vector selectMessage() throws Exception{
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		Vector<> vecList = new Vector<>();
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(/*sql */);
			pstmt.setString(parameterIndex, x);
			pstmt.executeQuery();
			return vecList;
		} catch(Exception ex){
			ex.printStackTrace();
		} finally{
			if(pstmt != null) try{ pstmt.close();} catch(SQLException ex){}
			if(conn != null) try{conn.close();} catch(SQLException ex){}
		}
		
	}
	
	//���� �󼼺���
	public MessageDataBean selectMessage(String send_id) throws Exception{
		return ;
	}
	
	//���� ����
	public int deleteMessage(String send_id) throws Exception{
		int x;
		return x;
	}
	
}
