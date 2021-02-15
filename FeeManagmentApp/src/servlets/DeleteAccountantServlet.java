package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountantDao;

@WebServlet("/deleteaccountant")
public class DeleteAccountantServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		HttpSession session=request.getSession();
		
		if(session == null || session.getAttribute("admin")==null)
		{
			request.getRequestDispatcher("accountant/accountantlogin.jsp").include(request, response);
			out.println("</center><h3>You need to log in first./h3></center>");
		}
		else
		{
			deleteAccountant(request, response);
		}
	}
	
	private void deleteAccountant(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	{
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		AccountantDao.delete(id);
		RequestDispatcher rd = request.getRequestDispatcher("viewaccountant");
		rd.forward(request, response);
	}
	
}
