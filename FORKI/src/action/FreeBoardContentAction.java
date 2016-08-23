package action;


import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.FrReplyDBBean;
import DAO_DTO.FrReplyDataBean;
import DAO_DTO.FreeBoardDBBean;
import DAO_DTO.FreeBoardDataBean;

public class FreeBoardContentAction implements CommandAction {
	
	public String requestPro (HttpServletRequest request, HttpServletResponse response) throws Throwable{
		
		System.out.println("content시작");
		
		
		String pageNum = request.getParameter("pageNum");
		int num = Integer.parseInt(request.getParameter("num"));
		
		if(request.getParameter("pageNum")==null){
			pageNum="1";
		}
		
		System.out.println(num); 
		
		FreeBoardDBBean fbdbb = FreeBoardDBBean.getInstance();
		FreeBoardDataBean article = fbdbb.getArticle(num);
		
		System.out.println("updateGetArticle 성공 ");
		List replyList = null;
		int replySize = 10;// 한 페이지의 글의 개수 한글
		String rePage = request.getParameter("rePageNum");
		if(rePage == null){
			rePage = "1";
		}
		System.out.println("repage::"+rePage);
		int currentRePage = Integer.parseInt(rePage);
		System.out.println("cureentrePage:"+ currentRePage);
		int startRow = (currentRePage - 1) * replySize + 1;// 한 페이지의 시작글 번호
		int endRow = currentRePage * replySize;// 한 페이지의 마지막 글번호
		int reCount = 0;
	
		
		FrReplyDBBean frdbb=FrReplyDBBean.getInstance();
		
		
		reCount=frdbb.getReplyCount(num);
		System.out.println("reCount::"+ reCount);
		int re_max = 0;
		
		if (reCount > 0) {
			replyList = frdbb.getReply(startRow, endRow, num);// 현재 페이지에 해당하는 글의 갯수
			FrReplyDataBean frdb = new FrReplyDataBean(); // 목록
			System.out.println("getReply성공");
			re_max = frdbb.getMax(num);
			
														
		} else {
			replyList = Collections.EMPTY_LIST;
		}
		
		request.setAttribute("re_max", re_max);
		request.setAttribute("currentRePage", currentRePage);
		request.setAttribute("num", new Integer(num));
        request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("article", article);
		request.setAttribute("replyList", replyList);
		request.setAttribute("reCount", reCount);
		request.setAttribute("replySize", replySize);
		request.setAttribute("rePageNum", rePage);
		
		System.out.println("content 끝 ");
		return "freeBoardContent.jsp";
	}

}
