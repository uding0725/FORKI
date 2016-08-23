package DAO_DTO;
//��������DAO
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import jdbc.JdbcUtil;

public class NotifyDBBean {

	private static NotifyDBBean instance=new NotifyDBBean();
	
	public static NotifyDBBean getInstance(){
		return instance;
	}
	private NotifyDBBean(){}
	
	private Connection getConnection() throws Exception{
		String jdbcDriver="jdbc:apache:commons:dbcp:/pool";
		return DriverManager.getConnection(jdbcDriver);
	}
	//�������׾���
	public void insertArticle(NotifyDataBean article)throws Exception{
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int number = 0;
        String sql="";
		try{
			
			conn = getConnection();
			pstmt = conn.prepareStatement("select max(num) from notify");
			rs = pstmt.executeQuery();
			
			if (rs.next())
				number = rs.getInt(1) + 1;
			else
				number = 1;
			
            		sql = "insert into notify(num,id,writer,subject,content,reg_date,readcount) values(?,?,?,?,?,?,?)";

		    		pstmt = conn.prepareStatement(sql);
		    		pstmt.setInt(1, number);
		    		pstmt.setString(2, article.getId());
		    		pstmt.setString(3, article.getWriter());
		    		pstmt.setString(4, article.getSubject());
		            pstmt.setString(5, article.getContent());
        	        pstmt.setTimestamp(6, article.getReg_date());
                    pstmt.setInt(7, article.getReadcount());
                    
		            pstmt.executeUpdate();
		            
		        } catch(Exception ex) {
		            ex.printStackTrace();
		        } finally {
		        	JdbcUtil.close(rs);
		        	JdbcUtil.close(pstmt);
		        	JdbcUtil.close(conn);
		        }
		    }
		   
	
	//�������װ��� �������
	public int getArticleCount()throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int x = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select count(*) from notify");
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				x=rs.getInt(1);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
        	JdbcUtil.close(pstmt);
        	JdbcUtil.close(conn);
		}
		return x;
	}
	//�������� �˻� ���� �������
	public int getArticleCount(int n,String search)throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String[] col_nm={"all","subject","content"};
		int x = 0;
		try {
			conn = getConnection();
			if(n==0){
				pstmt = conn.prepareStatement("select count(*) from NOTIFY where subject like '%"+search+"%' and content like '%"+search+"%'");
			}else
			{
				pstmt = conn.prepareStatement("select count(*) from NOTIFY where "+col_nm[n] +" like '%"+search+"%'");
			}
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				x=rs.getInt(1);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
        	JdbcUtil.close(pstmt);
        	JdbcUtil.close(conn);
		}
		return x;
	}
	
	//������������¡�� ����
	public List getArticles(int start,int end)throws Exception{
		Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
		List articleList=null;
		 try {
	            conn = getConnection();
	            
	            pstmt = conn.prepareStatement(
                "select num,id,writer,subject,content,readcount,reg_date,r " +
	            "from(select num,id,writer,subject,content,readcount,reg_date,rownum r " +
                "from(select num,id,writer,subject,content,readcount,reg_date " +
	            "from notify order by num desc) order by num desc) where r>= ? and r <= ? ");
	            pstmt.setInt(1, start);
	            pstmt.setInt(2, end);
	            rs = pstmt.executeQuery();
	            if(rs.next()){
	            	articleList = new ArrayList(end);
	            	do{
	            		NotifyDataBean article = new NotifyDataBean();
	            		article.setNum(rs.getInt("num"));
	            		article.setWriter(rs.getString("writer"));
	            		article.setId(rs.getString("id"));
	            		article.setSubject(rs.getString("subject"));
	            		article.setContent(rs.getString("content"));
	            		article.setReadcount(rs.getInt("readcount"));
	            		article.setReg_date(rs.getTimestamp("reg_date"));
	            		
	            		articleList.add(article);
	            	}while(rs.next());
	    	    }
	            } catch(Exception ex) {
	                ex.printStackTrace();
	            } finally {
	            	JdbcUtil.close(rs);
		        	JdbcUtil.close(pstmt);
		        	JdbcUtil.close(conn);
	            }
	    	return articleList;
	        }
	//������������¡�� ����
		public List getArticles(int start,int end,int n,String search)throws Exception{
			Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
			List articleList=null;
			String[] col_nm={"all","subject","content"};
			 try {
		            conn = getConnection();
		            if(n==0){
			            pstmt = conn.prepareStatement(
		                "select num,id,writer,subject,content,readcount,reg_date,r " +
			            "from(select num,id,writer,subject,content,readcount,reg_date,rownum r " +
		                "from(select num,id,writer,subject,content,readcount,reg_date " +
			            "from notify order by num desc) where subject like '%"+search+"%' and content like '%"+search+"%' order by num desc) where r>= ? and r <= ? ");
		            }else{
		                pstmt = conn.prepareStatement(
		    	                "select num,id,writer,subject,content,readcount,reg_date,r " +
		    		            "from(select num,id,writer,subject,content,readcount,reg_date,rownum r " +
		    	                "from(select num,id,writer,subject,content,readcount,reg_date " +
		    		            "from notify order by num desc) where "+col_nm[n] +" like '%"+search+"%' order by num desc) where r>= ? and r <= ? ");
		            }
		            pstmt.setInt(1, start);
		            pstmt.setInt(2, end);
		            rs = pstmt.executeQuery();
		            if(rs.next()){
		            	articleList = new ArrayList(end);
		            	do{
		            		NotifyDataBean article = new NotifyDataBean();
		            		article.setNum(rs.getInt("num"));
		            		article.setWriter(rs.getString("writer"));
		            		article.setId(rs.getString("id"));
		            		article.setSubject(rs.getString("subject"));
		            		article.setContent(rs.getString("content"));
		            		article.setReadcount(rs.getInt("readcount"));
		            		article.setReg_date(rs.getTimestamp("reg_date"));
		            		
		            		articleList.add(article);
		            	}while(rs.next());
		    	    }
		            } catch(Exception ex) {
		                ex.printStackTrace();
		            } finally {
		            	JdbcUtil.close(rs);
			        	JdbcUtil.close(pstmt);
			        	JdbcUtil.close(conn);
		            }
		    	return articleList;
		        }
	
	//db�� ���پ� ���������� �������
	public NotifyDataBean getArticle(int num)throws Exception{
		Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        NotifyDataBean article = null;
      
        try {
                conn = getConnection();

                pstmt = conn.prepareStatement(
                "update notify set readcount=readcount+1 where num = ?");
                pstmt.setInt(1, num);
    	        pstmt.executeUpdate();

                pstmt = conn.prepareStatement(
                "select * from notify where num = ?");
                pstmt.setInt(1, num);
                rs = pstmt.executeQuery();
                
                if(rs.next()){
                	 article = new NotifyDataBean();
                	 article.setNum(rs.getInt("num"));
	            	 article.setWriter(rs.getString("writer"));
	            	 article.setId(rs.getString("id"));
	            	 article.setSubject(rs.getString("subject"));
	            	 article.setContent(rs.getString("content"));
	            	 article.setReadcount(rs.getInt("readcount"));
	            	 article.setReg_date(rs.getTimestamp("reg_date"));
                }
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
        	JdbcUtil.close(rs);
        	JdbcUtil.close(pstmt);
        	JdbcUtil.close(conn);
        }
	return article;
    }
	//�������׸� �ϳ��� ������ �ö�
	public NotifyDataBean updateGetArticle(int num)throws Exception{
		Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        NotifyDataBean article = null;
        try {
            conn = getConnection();

            pstmt = conn.prepareStatement(
            "select * from notify where num = ?");
            pstmt.setInt(1, num);
            rs = pstmt.executeQuery();
            
            if(rs.next()){
            	 article = new NotifyDataBean();
            	 article.setNum(rs.getInt("num"));
            	 article.setWriter(rs.getString("writer"));
            	 article.setSubject(rs.getString("subject"));
            	 article.setContent(rs.getString("content"));
            	 article.setReg_date(rs.getTimestamp("reg_date"));
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
        	JdbcUtil.close(rs);
        	JdbcUtil.close(pstmt);
        	JdbcUtil.close(conn);
        }
	return article;
    }
	//���� �����͸� update��Ű�� �κ�
	public int updateArticle(NotifyDataBean article)throws Exception{
		Connection conn = null;
        PreparedStatement pstmt = null;
      
        String sql="";
        int x=-1;
         try{
        	 conn=getConnection();
        	 
        				sql="update notify set subject=?,content=? where num=?";
        		      
        			    pstmt = conn.prepareStatement(sql);
        			    pstmt.setString(1, article.getSubject());
        			    pstmt.setString(2, article.getContent());
        			    pstmt.setInt(3, article.getNum());
        			    x=pstmt.executeUpdate();
        
        	 } catch(Exception ex) {
                 ex.printStackTrace();
             } finally {
		        	JdbcUtil.close(pstmt);
		        	JdbcUtil.close(conn);
             }
     	 return x;
         }
	//�������� ���� 
	public int deleteArticle(int num)throws Exception{	
		Connection conn = null;
        PreparedStatement pstmt = null;

        int x=-1;
        try {
	    conn = getConnection();
			    pstmt = conn.prepareStatement("delete from notify where num=?");
	                    pstmt.setInt(1, num);
            x= pstmt.executeUpdate();

        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
  
        	JdbcUtil.close(pstmt);
        	JdbcUtil.close(conn);
        }
	return x;
    }
	
	public Vector getMain() throws Exception{
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Vector v = new Vector();
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from notify where num>=((select max(num) from notify)-1) order by num desc");
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				do{
				NotifyDataBean article = new NotifyDataBean();
           	 	article.setNum(rs.getInt("num"));
           	 	article.setWriter(rs.getString("writer"));
           	 	article.setSubject(rs.getString("subject"));
           	 	article.setContent(rs.getString("content"));
           	 	article.setReg_date(rs.getTimestamp("reg_date"));
				
           	 	v.add(article);
				}while(rs.next());
           	 	
			}
		}catch(Exception ex){
			ex.printStackTrace();
		} finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		
		return v;
	}
}