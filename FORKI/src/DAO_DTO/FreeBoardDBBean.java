package DAO_DTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import DAO_DTO.FreeBoardDataBean;
import jdbc.JdbcUtil;

public class FreeBoardDBBean {
	
	private static FreeBoardDBBean instance = new FreeBoardDBBean();
	
	public static FreeBoardDBBean getInstance(){
		return instance;
	}
	
	private Connection getConnection() throws Exception{
		String jdbcDriver = "jdbc:apache:commons:dbcp:/pool";
		return DriverManager.getConnection(jdbcDriver);
	}
	
	//글쓰기
	public void insertArticle(FreeBoardDataBean article) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int num = article.getNum();
		
		int number = 0;
		String sql = "";

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select max(num) from board");
			rs = pstmt.executeQuery();

			if (rs.next())
				number = rs.getInt(1) + 1;
			else
				number = 1;

			// 쿼리를 작성
			sql = "insert into board(num,id,writer,subject,content,reg_date,title,readcount) values(board_num.NEXTVAL,?,?,?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, article.getId());
			pstmt.setString(2, article.getWriter());
			pstmt.setString(3, article.getSubject());
			pstmt.setString(4, article.getContent());
			pstmt.setTimestamp(5, article.getReg_date());
			pstmt.setString(6, article.getTitle());
			pstmt.setInt(7,article.getReadcount());
			
			pstmt.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(conn);
			JdbcUtil.close(pstmt);
		}	
	}
	
	
	//전체 글 수 구하기
	   public int getArticleCount(String type,String title,String f) throws Exception{
		      Connection conn = null;
		      PreparedStatement pstmt = null;
		      ResultSet rs = null;
		      
		      int x = 0;
		      try{
		         conn = getConnection();
		         switch(type){
		         case "0":
		            pstmt = conn.prepareStatement("select count(*) from board "
		               + "where title like ? and (subject like ? or content like ? )");
		            pstmt.setString(1, "%"+title+"%");
		            pstmt.setString(2, "%"+f+"%");
		            pstmt.setString(3, "%"+f+"%");
		         break;
		         case "1":
		            pstmt = conn.prepareStatement("select count(*) from board "
		                  + "where title like ? and subject like ? ");
		            pstmt.setString(1, "%"+title+"%");
		            pstmt.setString(2, "%"+f+"%");
		         break;
		         case "2":
		            pstmt = conn.prepareStatement("select count(*) from board "
		                  + "where title like ? and content like ? ");
		            pstmt.setString(1, "%"+title+"%");
		            pstmt.setString(2, "%"+f+"%");
		         break;
		         }
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
		   

	/*public int getArticleCount() throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int x = 0;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement("select count(*) from board");
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
	}*/
	
	

	//페이지당 갯수에 맞춰서 나오기
	   public List getArticles(int start, int end,String type,String title,String f) throws Exception{
		      
		      Connection conn = null;
		      PreparedStatement pstmt = null;
		      ResultSet rs = null;
		      List articleList = null;
		      
		      try{
		         
		      conn=getConnection();
		      switch(type){
		      case "0":
		      pstmt = conn.prepareStatement("select * from (select f.*, rownum r from "+
		              "(select * from board order by reg_date desc) f "+
		              "order by reg_date desc)  where (r >= ? and r <= ?) and title like ? and (subject like ? or content like ? ) ");
		      pstmt.setInt(1, start);
		      pstmt.setInt(2, end);
		      pstmt.setString(3, "%"+title+"%");
		      pstmt.setString(4, "%"+f+"%");
		      pstmt.setString(5, "%"+f+"%");
		      break;
		      case "1":
		         pstmt = conn.prepareStatement("select * from (select f.*, rownum r from "+
		                 "(select * from board order by reg_date desc) f "+
		                 "order by reg_date desc)  where (r >= ? and r <= ?) and title like ? and subject like ? ");
		         pstmt.setInt(1, start);
		         pstmt.setInt(2, end);
		         pstmt.setString(3, "%"+title+"%");
		         pstmt.setString(4, "%"+f+"%");
		         break;
		      case "2":
		         pstmt = conn.prepareStatement("select * from (select f.*, rownum r from "+
		                 "(select * from board order by reg_date desc) f "+
		                 "order by reg_date desc)  where (r >= ? and r <= ?) and title like ? and content like ? ");
		         pstmt.setInt(1, start);
		         pstmt.setInt(2, end);
		         pstmt.setString(3, "%"+title+"%");
		         pstmt.setString(4, "%"+f+"%");
		         break;
		      }   
		      
		      
		      
		      rs = pstmt.executeQuery();
		      
		      if(rs.next()){
		         articleList = new ArrayList(end);
		         do {
		            FreeBoardDataBean article = new FreeBoardDataBean();
		            article.setNum(rs.getInt("num"));
		            article.setId(rs.getString("id"));
		            article.setWriter(rs.getString("writer"));
		            
		            if((rs.getString("title")).equals("0")){
		               article.setTitle("[소곤소곤]");
		            } else if((rs.getString("title")).equals("1")){
		               article.setTitle("[유익한 경로]");
		            } else{
		               article.setTitle("[기타]");
		            }
		            
		            article.setSubject(rs.getString("subject"));
		            article.setContent(rs.getString("content"));
		            article.setReadcount(rs.getInt("readcount"));
		            article.setReg_date(rs.getTimestamp("reg_date"));

		            articleList.add(article);
		            //레코드를 board.dataBean에 저장후 list에 저장
		            } while (rs.next());
		               }
		         } catch (Exception ex) {
		            ex.printStackTrace();
		         } finally {
		            JdbcUtil.close(rs);
		            JdbcUtil.close(conn);
		            JdbcUtil.close(pstmt);
		         }

		   return articleList;
		      }

	/*public List getArticles(int start, int end) throws Exception{
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List articleList = null;
		
		try{
			
		conn=getConnection();
		
		pstmt = conn.prepareStatement("select num, id, writer, title, subject, content, readcount, reg_date, r " +
				"from (select num, id, writer, title, subject, content, readcount, reg_date, rownum r from"+
				" (select num, id, writer, title, subject, content, readcount, reg_date from board order by reg_date desc)"+
				" order by reg_date desc) where r >= ? and r <= ? ");
		
		pstmt.setInt(1, start);
		pstmt.setInt(2, end);
		rs = pstmt.executeQuery();
		
		if(rs.next()){
			articleList = new ArrayList(end);
			do {
				FreeBoardDataBean article = new FreeBoardDataBean();
				article.setNum(rs.getInt("num"));
				article.setId(rs.getString("id"));
				article.setWriter(rs.getString("writer"));
				
				if((rs.getString("title")).equals("0")){
					article.setTitle("[소곤소곤]");
				} else if((rs.getString("title")).equals("1")){
					article.setTitle("[유익한 경로]");
				} else{
					article.setTitle("[기타]");
				}
				
				article.setSubject(rs.getString("subject"));
				article.setContent(rs.getString("content"));
				article.setReadcount(rs.getInt("readcount"));
				article.setReg_date(rs.getTimestamp("reg_date"));
			

				articleList.add(article);
				//레코드를 board.dataBean에 저장후 list에 저장
				} while (rs.next());
					}
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(conn);
				JdbcUtil.close(pstmt);
			}

	return articleList;
		}*/
		
	//상세보기
	public FreeBoardDataBean getArticle(int num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		FreeBoardDataBean article = null;
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("update board set readcount=readcount+1 where num = ?");
			pstmt.setInt(1, num);
			pstmt.executeUpdate();

			pstmt = conn.prepareStatement("select * from board where num = ?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				article = new FreeBoardDataBean();
				article.setNum(rs.getInt("num"));
				article.setId(rs.getString("id"));
				article.setWriter(rs.getString("writer"));
				article.setTitle(rs.getString("title"));
				article.setSubject(rs.getString("subject"));
				article.setReg_date(rs.getTimestamp("reg_date"));
				article.setReadcount(rs.getInt("readcount"));
				article.setContent(rs.getString("content"));
				
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return article;
	}
	
	//수정할때 폼가져오기 update
	public FreeBoardDataBean updateGetArticle(int num) throws Exception{
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		FreeBoardDataBean article = null;
		try{
		conn = getConnection();
		pstmt = conn.prepareStatement("select * from board where num=?");
		pstmt.setInt(1, num);
		
		rs = pstmt.executeQuery();
		if(rs.next()){
			article = new FreeBoardDataBean();
			article.setNum(rs.getInt("num"));
			article.setId(rs.getString("id"));
			article.setWriter(rs.getString("writer"));
			article.setTitle(rs.getString("title"));
			article.setSubject(rs.getString("subject"));
			article.setReg_date(rs.getTimestamp("reg_date"));
			article.setReadcount(rs.getInt("readcount"));
			article.setContent(rs.getString("content"));

		}
		}catch(Exception ex){
			ex.printStackTrace();
		} finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return article;
	}
	
	//수정버튼 updatePro
	public int updateArticle(FreeBoardDataBean article, String id){
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;
		
		
		try{
			conn = getConnection();
			if(id != null){
			pstmt = conn.prepareStatement("update board set title=?, subject=?, content=? where num =?");
			pstmt.setString(1,article.getTitle());
			pstmt.setString(2, article.getSubject());
			pstmt.setString(3, article.getContent());
			pstmt.setInt(4, article.getNum());
			
			pstmt.executeUpdate();
			x = 1;
			
			}
			
			else{
				x = 0;
			}
					
		} catch(Exception ex){
			ex.printStackTrace();
		} finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return x;
	}   
	
	//실제 데이터 삭제
	public int deleteArticle(int num,String id){
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		FreeBoardDataBean fbdb = new FreeBoardDataBean();
		
		int x = -1;
		
		try{
			if(id != null){
			conn = getConnection();
			pstmt = conn.prepareStatement("delete from board where num=?");
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			x = 1;
			}
			else{
				x = 0;
			}
		} catch(Exception ex){
			ex.printStackTrace();
		} finally{
			JdbcUtil.close(conn);
			JdbcUtil.close(pstmt);
		}
		
		return x;
	}


	
}
