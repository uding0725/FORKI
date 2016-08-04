package DAO_DTO;
//공지사항DAO
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

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
	//공지사항쓰기
	public void insertArticle(NotifyDataBean article)throws Exception{
	}
	
	//공지사항개수 가지고옴
	public int getArticleCount()throws Exception{
		return 1;
	}
	
	//공지사항페이징을 설정
	public List getArticles(int start,int end)throws Exception{
		List articleList=null;
		return articleList;
	}
	//db로 한줄씩 공지사항을 가지고옴
	public NotifyDataBean getArticle(int num)throws Exception{
	}
	//공지사항를 하나를 가지고 올때
	public NotifyDataBean updateGetArticle(int num)throws Exception{
	}
	//실제 데이터를 update시키는 부분
	public int updateArticle(NotifyDataBean article)throws Exception{
	}
	//공지사항 삭제
	public int deleteArticle(int num)throws Exception{	
	}
}
