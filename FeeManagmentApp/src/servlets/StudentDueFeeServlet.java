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

import bean.StudentBean;
import dao.StudentDao;


@WebServlet("/duefee")
public class StudentDueFeeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(false);
		if(session == null||session.getAttribute("accountant") == null)
		{
			
			request.getRequestDispatcher("accountant/accountantlogin.jsp").include(request, response);
			out.println("<center><h3>You need to log in first.</h3></center>");
		}
		else
		{
		duefeeList(request, response);
		}
	}
	
	private void duefeeList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<StudentBean> dueFeeList=StudentDao.getDues();
		request.setAttribute("duefeelist", dueFeeList);
		request.getRequestDispatcher("accountant/duefee.jsp").include(request, response);

	}
}
