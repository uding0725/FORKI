package DAO_DTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		ResultSet rs = null;
        //답변글인지 일반글인지를 구분해서 입력시켜주는 로직!!!
		int num=article.getNum();
		int ref=article.getRef();
		int re_step=article.getRe_step();
		int re_level=article.getRe_level();
		int number=0;
        String sql="";

        try {
            conn = getConnection();

            pstmt = conn.prepareStatement("select max(num) from prop_board");
	    rs = pstmt.executeQuery();

	    if (rs.next())
	      number=rs.getInt(1)+1;
	    else
	      number=1;
  
	    if (num!=0)
	    { 
	      sql="update prop_board set re_step=re_step+1 where ref= ? and re_step> ?";
	      pstmt = conn.prepareStatement(sql);
	      pstmt.setInt(1, ref);
	      pstmt.setInt(2, re_step);
	      pstmt.executeUpdate();
	      re_step=re_step+1;
	      re_level=re_level+1;
	    }else{
		      ref=number;
	      re_step=0;
	      re_level=0;
	    }

			conn=getConnection();
			pstmt=conn.prepareStatement("insert into prop_board values(propboardnum.NEXTVAL,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, article.getId());
			pstmt.setString(2,article.getWriter());
			pstmt.setString(3,article.getSubject());
			pstmt.setString(4, article.getContent());
			pstmt.setInt(5, ref);
			pstmt.setInt(6, re_step);
			pstmt.setInt(7,re_level);
			pstmt.setInt(8,article.getReadcount());
			pstmt.setTimestamp(9,article.getReg_date());
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
	}
	//건의사항 글개수를 가지고감
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
	public int getArticleCount(int n,String search)throws Exception{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		int x=0;
		String[] col_name={"subject","content"};
		try{
			conn=getConnection();
			pstmt=conn.prepareStatement("select count(*) from prop_board where "+col_name[n]+" like '%"+search+"%'" );
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
			"select id,num,writer,subject,ref,re_step,re_level,readcount,reg_date,r "
			+"from (select id,num,writer,subject,ref,re_step,re_level,readcount,reg_date,rownum r "
		    +"from (select id,num,writer,subject,ref,re_step,re_level,readcount,reg_date "
			+"from prop_board order by ref desc, re_step asc) order by ref desc, re_step asc ) where r >= ? and r <= ? ");
			pstmt.setInt(1,start);
			pstmt.setInt(2, end);
			rs=pstmt.executeQuery();
			if(rs.next()){
				  articleList = new ArrayList(end);
				do{
					PrBoardDataBean article= new PrBoardDataBean();
					article.setId(rs.getString("id"));
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
		System.out.println(articleList.size());
		return articleList;
		
	}
	
	public List getArticles(int start,int end,int n,String search)throws Exception{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List articleList=null;
		String[] col_name={"subject","content"};
		try{
			conn=getConnection();
			pstmt= conn.prepareStatement(
			"select id,num,writer,subject,ref,re_step,re_level,readcount,reg_date,r "
			+"from (select id,num,writer,subject,ref,re_step,re_level,readcount,reg_date,rownum r "
		    +"from (select id,num,writer,subject,ref,re_step,re_level,readcount,reg_date "
			+"from prop_board order by ref desc, re_step asc) where "+col_name[n]+" like '%"+search+"%'"+"  order by ref desc, re_step asc ) where r >= ? and r <= ? ");
			pstmt.setInt(1,start);
			pstmt.setInt(2, end);
			rs=pstmt.executeQuery();
			if(rs.next()){
				  articleList = new ArrayList(end);
				do{
					PrBoardDataBean article= new PrBoardDataBean();
					article.setId(rs.getString("id"));
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
		System.out.println(articleList.size());
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
				article.setNum(rs.getInt("num"));
				article.setId(rs.getString("id"));
				article.setWriter(rs.getString("writer"));
				article.setRef(rs.getInt("ref"));
				article.setRe_step(rs.getInt("re_step"));
				article.setRe_level(rs.getInt("re_level"));
				article.setSubject(rs.getString("subject"));
				article.setContent(rs.getString("content"));
				article.setReg_date(rs.getTimestamp("reg_date"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return article;
	}

	//건의사항 수정할 글을 가지고감
	public PrBoardDataBean updateGetArticle(int num)throws Exception{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		PrBoardDataBean article=null;
		try{
			conn=getConnection();
			pstmt=conn.prepareStatement("select*from prop_board where num=?");
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			if(rs.next()){
				article=new PrBoardDataBean();
				article.setNum(rs.getInt("num"));
				article.setWriter(rs.getString("writer"));
				article.setSubject(rs.getString("subject"));
				article.setContent(rs.getString("content"));
				article.setReg_date(rs.getTimestamp("reg_date"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return article;
	}
	//건의사항 글 수정
	public int updateArticle(PrBoardDataBean article)throws Exception{
		Connection conn=null;
		PreparedStatement pstmt=null;
		int x=0;
		try{
			
			conn=getConnection();
			pstmt=conn.prepareStatement("update prop_board set subject=?,content=? where num=?");
			pstmt.setString(1, article.getSubject());
			pstmt.setString(2, article.getContent());
			pstmt.setInt(3, article.getNum());
			x=pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return x;
	}
	//건의사항 삭제할 글
	public int deleteArticle(int num,int ref,int re_level,int re_step)throws Exception{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String dbpasswd="";
		int dbref=0;
		int dbre_step=0;
		int dbre_level=0;
		int dbre_step2=0;
		int x=-1;
		try{
			conn=getConnection();
			pstmt=conn.prepareStatement("select * from prop_board where num=?");
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			if(rs.next()){
				dbref=rs.getInt("ref");
				dbre_step=rs.getInt("re_step");
				dbre_level=rs.getInt("re_level");
				String sql1="select ref,re_step,re_level from prop_board where ref="+dbref+" and re_step >"+dbre_step+ " and re_level ="+dbre_level;
				pstmt=conn.prepareStatement(sql1);
				rs=pstmt.executeQuery();
				if(rs.next()){
					dbre_step2=rs.getInt("re_step");
					String sql="delete from prop_board where ref="+dbref+" and "+dbre_step+" <=re_step <"+dbre_step2+ " and re_level>="+dbre_level;
					pstmt=conn.prepareStatement(sql);
					pstmt.executeUpdate();
				}else{
					String sql="delete from prop_board where ref="+dbref+" and re_step>="+dbre_step;
					pstmt=conn.prepareStatement(sql);
					pstmt.executeUpdate();
				}
					x=1;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return x;
	}
	
	//
	public int idCheck(String id, String ref )throws Exception{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		PrBoardDataBean article=null;
		int idCheck= 0;
		try{
			conn=getConnection();		
			pstmt=conn.prepareStatement("select * from prop_board where id = ? and ref = ?");
			pstmt.setString(1, id);
			pstmt.setString(2, ref);
			rs=pstmt.executeQuery();
			if(rs.next()){
				idCheck = 1;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return idCheck;
	}
}
