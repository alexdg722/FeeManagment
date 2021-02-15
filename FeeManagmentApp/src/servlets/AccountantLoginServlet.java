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

@WebServlet("/accountantlogin")
public class AccountantLoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
	
		response.sendRedirect("accountant/accountantlogin.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		boolean status = AccountantDao.validate(email, password);
		if(status)
		{
			HttpSession session = request.getSession();
			session.setAttribute("accountant","true");
			RequestDispatcher rd = request.getRequestDispatcher("viewstudent");
			rd.forward(request,response);
		}
		else
		{
			request.getRequestDispatcher("accountant/accountantlogin.jsp").include(request, response);
			out.println("<center><p>Sorry, username or password error!</p></center>");
		}
	}
}
