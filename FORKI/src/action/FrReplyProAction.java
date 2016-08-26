package action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.FrReplyDBBean;
import DAO_DTO.FrReplyDataBean;

public class FrReplyProAction implements CommandAction{

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		System.out.println("replyPro ����");
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println("�ѹ��� :" +num);
		
		
		int re_num = Integer.parseInt(request.getParameter("re_num"));
		String content = request.getParameter("re_content");
		Timestamp reg_date = new Timestamp(System.currentTimeMillis());
		String re_page = request.getParameter("re_page");
		if(re_num == 0 || re_page == null){
			re_num = 1;
			re_page = "1";
		}
		
		FrReplyDataBean frdb = new FrReplyDataBean();
		frdb.setNum(num);
		frdb.setId((String)request.getSession().getAttribute("id"));
		frdb.setWriter((String)request.getSession().getAttribute("writer"));
		frdb.setRe_num(re_num);
		frdb.setContent(content);
		frdb.setReg_date(reg_date);

		System.out.println((String)request.getSession().getAttribute("id"));
		
		FrReplyDBBean frdbb = FrReplyDBBean.getInstance();
		frdbb.insertReply(frdb);
		
		request.setAttribute("num", num);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("re_page", re_page);
		return "frReplyPro.jsp";
	}

}
