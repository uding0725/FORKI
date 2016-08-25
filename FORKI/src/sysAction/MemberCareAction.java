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
			
		      List Memlist = null;
		      SystemDBBean DBAPPRO = SystemDBBean.getInstance();// DB����
		      count = DBAPPRO.getMemberCount();// ��ü ���� ��


				if (count > 0) {
					Memlist = DBAPPRO.getMemCareList(startRow, endRow);// ���� �������� �ش��ϴ� ���� ����
				} else {
					Memlist = Collections.EMPTY_LIST;//���
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
