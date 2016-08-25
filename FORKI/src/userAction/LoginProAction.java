package userAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import action.*;

public class LoginProAction implements CommandAction{
	
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable{
		
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String passwd  = request.getParameter("passwd");
		
		HttpSession session = request.getSession();
		

		LogonDBBean manager = LogonDBBean.getInstance();
		int check= manager.userCheck(id,passwd);
		if(check==1){
			LogonDataBean DBdata = manager.getDBdata(id);
			session.setAttribute("id", id);
			session.setAttribute("grade", DBdata.getM_grade());
			
			//관리자나 일반회원은 글쓰기할때 닉네임출력
			if(DBdata.getM_grade()==0||DBdata.getM_grade()==1){
			session.setAttribute("writer", DBdata.getNickname());
			}
			
			//기업은 글쓰기할때 닉네임 출력
			if(DBdata.getM_grade()==2){
			session.setAttribute("writer", DBdata.getSchul_nm());
			}
			}
		request.setAttribute("check", new Integer(check));
		
		return "/content/join/factor/user/loginPro.jsp";//�ش� ��
		
	}
}