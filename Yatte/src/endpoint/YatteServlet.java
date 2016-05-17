package endpoint;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class YatteServlet
 */
@WebServlet("/yatte")
public class YatteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public YatteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 来たらnameを見る、なければyatteLoginにフォワード、あればpost
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		if (session.getAttribute("name") == null) {
			YatteDao dao = new YatteDao();
			List<yatteName> yName = dao.name();
			request.setAttribute("nameList", yName);
			System.out.println(request.getAttribute("nameList"));
			RequestDispatcher rd = request.getRequestDispatcher("/yatteLogin.jsp");
			rd.forward(request, response);
		} else {
			doPost(request, response);
		}
	}

	/**
	 *
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		request.setCharacterEncoding("UTF-8");
		if (session.getAttribute("name") == null) {
			session.setAttribute("name", request.getParameter("name"));
		}
		System.out.println(" これが名前やぞ " + session.getAttribute("name"));
		YatteDao dao = new YatteDao();
		List<yatteName> yName = dao.name();
		request.setAttribute("nameList", yName);
		response.setContentType("text/html; charset=UTF-8");
		RequestDispatcher rd = request.getRequestDispatcher("/yatte.jsp");
		rd.forward(request, response);
	}
}