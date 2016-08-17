package DAO_DTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import jdbc.JdbcUtil;

public class PrBoardDBBean {

	private static PrBoardDBBean instance=new PrBoardDBBean();
	
	public static PrBoardDBBean getInstance(){
		return instance;
	}
	
	private PrBoardDBBean(){}
	
	private Connection getConnection()throws Exception{
		String jdbcDriver="jdbc:apache:commons:dbcp:/pool";
		return DriverManager.getConnection(jdbcDriver);
	}
	//嫄댁쓽�궗�빆 湲��벐湲�
	public void insertArticle(PrBoardDataBean article)throws Exception{
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try{
			conn=getConnection();
			pstmt=conn.prepareStatement("insert into prop_board values(?,?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1,article.getNum());
			pstmt.setString(2, article.getId());
			pstmt.setString(3,article.getWriter());
			pstmt.setString(4,article.getSubject());
			pstmt.setString(5, article.getContent());
			pstmt.setInt(6, article.getRef());
			pstmt.setInt(7, article.getRe_step());
			pstmt.setInt(8,article.getRe_level());
			pstmt.setInt(9,article.getReadcount());
			pstmt.setTimestamp(10,article.getReg_date());
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
	}
	//嫄댁쓽�궗�빆 湲�媛쒖닔 媛�吏�怨좎삤湲�
	public int getArticleCount()throws Exception{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		int x=0;
		try{
			conn=getConnection();
			pstmt=conn.prepareStatement("select count(*) from prop_board");
			rs=pstmt.executeQuery();
			if(rs.next()){
				x=rs.getInt(1);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return x;
	}
	//嫄댁쓽�궗�빆 �럹�씠吏�
	public List getArticles(int start,int end)throws Exception{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List articleList=null;
		try{
			conn=getConnection();
			pstmt= conn.prepareStatement(
			"select num,writer,subject,ref,re_step,re_level,readcount,reg_date,r "
			+"from (select num,writer,subject,ref,re_step,re_level,readcount,reg_date,rownum r "
		    +"from (select num,writer,subject,ref,re_step,re_level,readcount,reg_date "
			+"from prop_board order by ref desc, re_step asc) order by ref desc, re_step asc ) where r >= ? and r <= ? ");
			pstmt.setInt(1,start);
			pstmt.setInt(2, end);
			rs=pstmt.executeQuery();
			if(rs.next()){
				do{
					PrBoardDataBean article= new PrBoardDataBean();
					article.setNum(rs.getInt("num"));
					article.setWriter(rs.getString("writer"));
					article.setSubject(rs.getString("subject"));
					article.setRef(rs.getInt("ref"));
					article.setRe_step(rs.getInt("re_step"));
					article.setRe_level(rs.getInt("re_level"));
					article.setReadcount(rs.getInt("readcount"));
					article.setReg_date(rs.getTimestamp("reg_date"));
					articleList.add(article);
				}while(rs.next());
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return articleList;
	}
	//
	public PrBoardDataBean getArticle(int num)throws Exception{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		PrBoardDataBean article=null;
		try{
			conn=getConnection();
			pstmt=conn.prepareStatement("update prop_board set readcount=readcount+1 where num=?");
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
			pstmt=conn.prepareStatement("select*from prop_board where num=?");
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			if(rs.next()){
				article=new PrBoardDataBean();
				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
	}
	/*
	//嫄댁쓽�궗�빆 �닔�젙�븷 湲� 媛�吏�怨좎삤湲�
	public PrBoardDataBean updateGetArticle(int num)throws Exception{
		
	}
	//嫄댁쓽�궗�빆 �떎�젣 �닔�젙遺�遺�
	public int updateArticle(PrBoardDataBean article)throws Exception{
		
	}
	//湲� �궘�젣
	public int deleteArticle(int num)throws Exception{
		
	} */
}
