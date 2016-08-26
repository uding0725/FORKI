package action;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO_DTO.HealthDBBean;
import DAO_DTO.KidDataBean;

public class KidModifyAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		int size = Integer.parseInt(request.getParameter("size"));
		int i = 0;
		KidDataBean Data = null;
		HealthDBBean DBpro = HealthDBBean.getInstance();

		List kidData = null;

		if (size != 0) {
			kidData = new ArrayList(size);
			System.out.println("ss " + size);
			do {
				i++;
				String kidName = request.getParameter("kidName" + i);
				String kinderName = request.getParameter("kinderName" + i);
				Data = new KidDataBean();
				if (kidName != null && kidName.equals(""))
					break;
				if (kinderName != null && kinderName.equals(""))
					break;
				Data.setId(id);
				Data.setNum(i);
				Data.setName(kidName);
				Data.setSchul_nm(kinderName);
				kidData.add(Data);
			} while (i < size);
		}
		
		
		
		DBpro.updateKid(id, size, kidData); 

		return "KidModify.jsp";
	}

}
