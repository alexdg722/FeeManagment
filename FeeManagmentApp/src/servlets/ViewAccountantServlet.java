package servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.AccountantBean;
import dao.AccountantDao;


@WebServlet("/viewaccountant")
public class ViewAccountantServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
        PrintWriter out = response.getWriter();
		if(session == null || session.getAttribute("admin") == null)
		{ 
			request.getRequestDispatcher("admin/adminlogin.jsp").include(request, response);
			out.println("<center><h3>You need to log in first.</h3></center>");
		}
		else
		{
			accountantList(request, response);
		}

	}
	
	public static void accountantList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		List<AccountantBean> accountantList = AccountantDao.getAllRecords();
		request.setAttribute("accountantList", accountantList);
		request.getRequestDispatcher("admin/viewaccountant.jsp").include(request, response);
	}
	
	
}
