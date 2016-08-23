package DAO_DTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import jdbc.JdbcUtil;



public class FrReplyDBBean {
	
	public static FrReplyDBBean instance = new FrReplyDBBean();
	
	public static FrReplyDBBean getInstance(){
		return instance;
	}
	
	private Connection getConnection() throws Exception{
		String jdbdDriver = "jdbc:apache:commons:dbcp:/pool";
		return DriverManager.getConnection(jdbdDriver);
	}
	
	//댓글 입력
	public void insertReply(FrReplyDataBean frdb) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement("insert into free_reply values(?,?,?,?,?,?)");
			pstmt.setInt(1, frdb.getNum());
			pstmt.setString(2, frdb.getId());
			pstmt.setString(3, frdb.getWriter());
			pstmt.setInt(4, frdb.getRe_num());
			pstmt.setString(5, frdb.getContent());
			pstmt.setTimestamp(6, frdb.getReg_date());
			
			pstmt.executeUpdate();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
	}
	
	//댓글가져오기
	public ArrayList getReply(int num) throws Exception{
	
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList cm=null;
		try{
			conn=getConnection();
			String sql="select * from free_reply where num=? order by reg_date desc";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				cm=new ArrayList();
				do{
					FrReplyDataBean frdb=new FrReplyDataBean();
					frdb.setNum(rs.getInt("num"));
					frdb.setId(rs.getString("id"));
					frdb.setWriter(rs.getString("writer"));
					frdb.setRe_num(rs.getInt("re_num"));
					frdb.setContent(rs.getString("content"));
					frdb.setReg_date(rs.getTimestamp("reg_date"));
				
					cm.add(frdb);
				}while(rs.next());
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return cm;
		
	}
	
	//댓글갯수
	public int getReplyCount(int num) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int x = 0;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement("select count(*) from free_reply where num=?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				x = rs.getInt(1);
			} 
			
		} catch(Exception ex){
			ex.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(conn);
			JdbcUtil.close(pstmt);
		}
		return x;
	}
	
		
		public ArrayList getReply(int start, int end,int num) throws Exception{
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList replyList = null;
		
		try{
			
		conn=getConnection();
		
		pstmt = conn.prepareStatement("select num, id, writer, re_num, content, reg_date, r " +
				"from (select num, id, writer, re_num, content, reg_date, rownum r from"+
				" (select num, id, writer,re_num, content, reg_date from free_reply order by reg_date desc)"+
				"where num=? order by reg_date desc) where r >= ? and r <= ? ");
		
		pstmt.setInt(1, num);
		pstmt.setInt(2, start);
		pstmt.setInt(3, end);
		rs = pstmt.executeQuery();
		
		if(rs.next()){
			replyList = new ArrayList(end);
			do {
				
				FrReplyDataBean frdb = new FrReplyDataBean();
				frdb.setNum(rs.getInt("num"));
				frdb.setId(rs.getString("id"));
				frdb.setWriter(rs.getString("writer"));
				frdb.setRe_num(rs.getInt("re_num"));
				frdb.setContent(rs.getString("content"));
				frdb.setReg_date(rs.getTimestamp("reg_date"));
				
				replyList.add(frdb);
				
				} while (rs.next());
					}
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(conn);
				JdbcUtil.close(pstmt);
			}

	return replyList;
		}

	public int getMax(int num) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int x = 0;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement("select max(re_num) from free_reply where num=?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
		
			if(rs.next()){
				x = rs.getInt(1);
			}
		} catch(Exception ex){
			ex.printStackTrace();
		} finally{
			JdbcUtil.close(pstmt);
			JdbcUtil.close(rs);
			JdbcUtil.close(conn);
		}
		
		return x;
	}

	//댓글삭제
	public int deleteReply(int num, String writer, int re_num) throws Exception{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		int x=-1;
		
		try{
			if(writer != null){
			conn=getConnection();
			pstmt=conn.prepareStatement("delete from free_reply where num=? and re_num=?");
			pstmt.setInt(1, num);
			pstmt.setInt(2, re_num);
			pstmt.executeUpdate();
					x=1;
				}else{
					x=0;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return x;
	}
	
	//글삭제시 댓글삭제
		public int deleteReply(int num, String id) throws Exception{
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			
			int x=-1;
			
			try{
				if(id != null){
				conn=getConnection();
				pstmt=conn.prepareStatement("delete from free_reply where num=?");
				pstmt.setInt(1, num);
				pstmt.executeUpdate();
						x=1;
					}else{
						x=0;
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}finally{
				JdbcUtil.close(pstmt);
				JdbcUtil.close(conn);
			}
			return x;
		}


}
