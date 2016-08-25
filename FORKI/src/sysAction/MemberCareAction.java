package sysAction;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import action.*;

public class MemberCareAction implements CommandAction{
	
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable{
		
			request.setCharacterEncoding("UTF-8");
			
			String pageNum = request.getParameter("pageNum"); // 페이지 번호
			if (pageNum == null) {
				pageNum = "1";
			}
			
			int pageSize = 10;// 한 페이지의 글의 개수 한글
			int currentPage = Integer.parseInt(pageNum);
			int startRow = (currentPage - 1) * pageSize + 1;// 한 페이지의 시작글 번호
			int endRow = currentPage * pageSize;// 한 페이지의 마지막 글번호
			int count = 0;
			int number = 0;
			
		      List Memlist = null;
		      SystemDBBean DBAPPRO = SystemDBBean.getInstance();// DB연동
		      count = DBAPPRO.getMemberCount();// 전체 글의 수


				if (count > 0) {
					Memlist = DBAPPRO.getMemCareList(startRow, endRow);// 현재 페이지에 해당하는 글의 갯수
				} else {
					Memlist = Collections.EMPTY_LIST;//목록
				}

			request.setAttribute("currentPage", new Integer(currentPage));
			request.setAttribute("startRow", new Integer(startRow));
			request.setAttribute("endRow", new Integer(endRow));
			request.setAttribute("count", new Integer(count));
			request.setAttribute("pageSize", new Integer(pageSize));
			request.setAttribute("number", new Integer(number));
			request.setAttribute("Memlist", Memlist);
			return "/content/adminPage/SysMemberCare.jsp";
			
	}

}
