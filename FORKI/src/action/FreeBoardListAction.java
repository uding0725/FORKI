package action;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.FreeBoardDBBean;
import DAO_DTO.FreeBoardDataBean;


public class FreeBoardListAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		
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
		  String searchn = request.getParameter("searchn");
	      String type = request.getParameter("type");
	      String title = request.getParameter("title");
	      if(searchn==null) searchn = "";
	      if(type==null) type="0";
	      if(title==null) title="";


		List articleList = null;
		FreeBoardDBBean fbdbb = FreeBoardDBBean.getInstance();// DB연동
		

		
		count = fbdbb.getArticleCount(type,title,searchn);// 전체 글의 수


		if (count > 0) {
			   articleList = fbdbb.getArticles(startRow, endRow ,type,title,searchn);// 현재 페이지에 해당하는 글의 갯수
			FreeBoardDataBean fbdb = new FreeBoardDataBean(); 
			
														// 목록
		} else {
			articleList = Collections.EMPTY_LIST;
		}

		number = count - (currentPage - 1) * pageSize;// 글목록에 표시할 글번호
		// 해당 뷰에서 사용할 속성
		
		request.setAttribute("date", date);
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
