package sysAction;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.FreeBoardDBBean;
import DAO_DTO.FreeBoardDataBean;
import action.*;

public class ApprobationAction implements CommandAction{
	
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable{
		
			request.setCharacterEncoding("UTF-8");
			
			String pageNum = request.getParameter("pageNum"); // ������ ��ȣ
			if (pageNum == null) {
				pageNum = "1";
			}
			
			int pageSize = 10;// �� �������� ���� ���� �ѱ�
			int currentPage = Integer.parseInt(pageNum);
			int startRow = (currentPage - 1) * pageSize + 1;// �� �������� ���۱� ��ȣ
			int endRow = currentPage * pageSize;// �� �������� ������ �۹�ȣ
			int count = 0;
			int number = 0;
			
		      List articleList = null;
		      SystemDBBean DBAPPRO = SystemDBBean.getInstance();// DB����
		      count = DBAPPRO.getApproCount();// ��ü ���� ��


				if (count > 0) {
				 articleList = DBAPPRO.getApproList(startRow, endRow);// ���� �������� �ش��ϴ� ���� ����
				} else {
					articleList = Collections.EMPTY_LIST;//���
				}

			request.setAttribute("currentPage", new Integer(currentPage));
			request.setAttribute("startRow", new Integer(startRow));
			request.setAttribute("endRow", new Integer(endRow));
			request.setAttribute("count", new Integer(count));
			request.setAttribute("pageSize", new Integer(pageSize));
			request.setAttribute("number", new Integer(number));
			request.setAttribute("articleList", articleList);
			
			return "/content/adminPage/SysApprobation.jsp";
			
	}

}