package DAO_DTO;
//��������DAO
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
	//�������׾���
	public void insertArticle(NotifyDataBean article)throws Exception{
	}
	
	//�������װ��� �������
	public int getArticleCount()throws Exception{
		return 1;
	}
	
	//������������¡�� ����
	public List getArticles(int start,int end)throws Exception{
		List articleList=null;
		return articleList;
	}
	//db�� ���پ� ���������� �������
	public NotifyDataBean getArticle(int num)throws Exception{
	}
	//�������׸� �ϳ��� ������ �ö�
	public NotifyDataBean updateGetArticle(int num)throws Exception{
	}
	//���� �����͸� update��Ű�� �κ�
	public int updateArticle(NotifyDataBean article)throws Exception{
	}
	//�������� ����
	public int deleteArticle(int num)throws Exception{	
	}
}
