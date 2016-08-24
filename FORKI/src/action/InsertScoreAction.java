package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO_DTO.ScoreDBBean;
import DAO_DTO.ScoreDataBean;

public class InsertScoreAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		int score = Integer.parseInt(request.getParameter("score"));
		String kinderNum = request.getParameter("num");
		String id = (String) session.getAttribute("id");

		int check = 0;
		
		if (id != null) {
			ScoreDBBean DBpro = ScoreDBBean.getInstance();
			ScoreDataBean DBdata = DBpro.getTotal(kinderNum);
			if (id.equals("admin")) {
				check = 1;
			} else {
				check = DBpro.checkScore(id);
				System.out.println(check);
			}

			if (check == 1) {
				double t_score = Double.parseDouble(DBdata.getT_score());
				double count = Integer.parseInt(DBdata.getCount());
				double total = 0;
				if (count != 0) {
					total = ((t_score * count) + score) / (count + 1);
					count++;
				} else {
					total = score;
					count++;
				}
				DBpro.setScore(total, (int) score, kinderNum, (int) count, id);
			}
		} else {
			check = -1;
		}
		request.setAttribute("num", kinderNum);
		request.setAttribute("check", check);

		return "InsertScore.jsp";
	}

}
