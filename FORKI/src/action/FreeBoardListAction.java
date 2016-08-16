package action;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.FreeBoardDBBean;
import DAO_DTO.FreeBoardDataBean;

public class FreeBoardListAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		
		String pageNum = request.getParameter("pageNum"); // �럹�씠吏� 踰덊샇
		if (pageNum == null) {
			pageNum = "1";
		}
		//int type=Integer.parseInt(request.getParameter("type"));
		int title = Integer.parseInt(request.getParameter("title"));
		//String searchn = request.getParameter("searchn");
		int pageSize = 10;// �븳 �럹�씠吏��쓽 湲��쓽 媛쒖닔 �븳湲�
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize + 1;// �븳 �럹�씠吏��쓽 �떆�옉湲� 踰덊샇
		int endRow = currentPage * pageSize;// �븳 �럹�씠吏��쓽 留덉�留� 湲�踰덊샇
		int count = 0;
		int number = 0;

		List articleList = null;
		FreeBoardDBBean fbdbb = FreeBoardDBBean.getInstance();// DB�뿰�룞
		
		//if(searchn == null && title >= 0){
		count = fbdbb.getArticleCount();// �쟾泥� 湲��쓽 �닔
		//}
		if (count > 0) {
			articleList = fbdbb.getArticles(startRow, endRow);// �쁽�옱 �럹�씠吏��뿉 �빐�떦�븯�뒗 湲��쓽 媛��닔
			FreeBoardDataBean fbdb = new FreeBoardDataBean();
														// 紐⑸줉
		} else {
			articleList = Collections.EMPTY_LIST;
		}

		number = count - (currentPage - 1) * pageSize;// 湲�紐⑸줉�뿉 �몴�떆�븷 湲�踰덊샇
		// �빐�떦 酉곗뿉�꽌 �궗�슜�븷 �냽�꽦
		request.setAttribute("currentPage", new Integer(currentPage));
		request.setAttribute("startRow", new Integer(startRow));
		request.setAttribute("endRow", new Integer(endRow));
		request.setAttribute("count", new Integer(count));
		request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("number", new Integer(number));
		request.setAttribute("articleList", articleList);

		
		
		return "freeBoardList.jsp";
	}
}
