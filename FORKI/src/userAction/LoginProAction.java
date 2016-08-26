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
		

		LogonDBBean manager1 = LogonDBBean.getInstance();
		comAction.LogonDBBean manager2 = comAction.LogonDBBean.getInstance();
		int check = manager1.userCheck(id,passwd);
		int certi = manager1.certifyCheck(id,passwd);
		int reg_check = manager2.getDBK_ETCdata(id);
		int grade = 0;
		String schul_num = "";		
		if(check==1){
			//블랙리스트 유무 검사
			String black = manager1.userBlack(id);
			System.out.println("DDDDD" + black);
			if (black != null && !black.equals("")) {	
				request.setAttribute("blackCheck", "black");
				request.setAttribute("content", black);
				
				return "/content/join/factor/user/loginPro.jsp";
			}
			
			LogonDataBean DBdata1 = manager1.getDBdata(id);
			grade = DBdata1.getM_grade();
			String aa =  Integer.toString(grade);
			session.setAttribute("id", id);

			session.setAttribute("grade", aa);
			
			//愿�由ъ옄�굹 �씪諛섑쉶�썝�� 湲��벐湲고븷�븣 �땳�꽕�엫異쒕젰
			if(DBdata1.getM_grade()==0||DBdata1.getM_grade()==1){
			session.setAttribute("writer", DBdata1.getNickname());
			}
			
			//湲곗뾽�� 湲��벐湲고븷�븣 �땳�꽕�엫 異쒕젰
			if(DBdata1.getM_grade()==2){
			session.setAttribute("writer", DBdata1.getSchul_nm());
			
			comAction.LogonDataBean DBdata2 = manager2.getDBSchul(id);
			schul_num = DBdata2.getSchul_num();
			session.setAttribute("schul_num", schul_num);
			}
		}
		

		request.setAttribute("check", new Integer(check));
		request.setAttribute("certi", new Integer(certi));
		request.setAttribute("grade", new Integer(grade));
		request.setAttribute("reg_check", new Integer(reg_check));
		
		return "/content/join/factor/user/loginPro.jsp";//占쌔댐옙 占쏙옙
		
	}
}