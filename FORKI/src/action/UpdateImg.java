package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

public class UpdateImg implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {


	

		@SuppressWarnings("deprecation")
		String path = request.getRealPath("/upload");


		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		MultipartRequest multi = new MultipartRequest(request, path);


		g.setImg(multi.getFilesystemName("img"));

		// ������ ���� �� �߱⿡ dao���� ��ó���� �ñ�
		GoodsDao dao = new GoodsDao();
		int re = dao.insertGoods(g);

		if (re == 1) {
			out.println("����");
		} else {
			out.println("����");
		}

		return null;
	}

}
