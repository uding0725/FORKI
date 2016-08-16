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
	//건의사항 글쓰기
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
	//건의사항 글개수 가지고오기
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
	//건의사항 페이징
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
/*	//건의사항 글하나 가지고오기
	public PrBoardDataBean getArticle(int num)throws Exception{
		
	}
	//건의사항 수정할 글 가지고오기
	public PrBoardDataBean updateGetArticle(int num)throws Exception{
		
	}
	//건의사항 실제 수정부분
	public int updateArticle(PrBoardDataBean article)throws Exception{
		
	}
	//글 삭제
	public int deleteArticle(int num)throws Exception{
		
	} */
}
