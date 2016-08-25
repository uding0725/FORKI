package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import DAO_DTO.ImgDataBean;
import DAO_DTO.KiderDBBean;


public class UploadImgAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String schul_num = (String) session.getAttribute("schul_num");
		
		
		String realpath = request.getRealPath("/content/images/slides"); 
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		int size = 10485760;
		MultipartRequest multi = new MultipartRequest(request, realpath, size, new DefaultFileRenamePolicy());
		String filename = multi.getFilesystemName("img");
		String message = multi.getParameter("message");
		filename = new String(filename.getBytes("8859_1"),"utf-8");
		message = new String(message.getBytes("8859_1"),"utf-8");

		ImgDataBean DBdata = new ImgDataBean();
		DBdata.setFile_name(filename);
		DBdata.setMessage(message);
		DBdata.setPath(realpath);
		DBdata.setSchul_num(schul_num);

		
		KiderDBBean DBpro = KiderDBBean.getInstance();
		int re = DBpro.insertImg(DBdata);
		
		request.setAttribute("re", re);

		return "UploadImg.jsp";
	}

}
