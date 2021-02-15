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
import dao.StudentDao;

@WebServlet("/deletestudent")
public class DeleteStudentServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		HttpSession session=request.getSession();
		
		if(session == null || session.getAttribute("accountant")==null)
		{
			request.getRequestDispatcher("admin/adminlogin.jsp").include(request, response);
			out.println("</center><h3>You need to log in first.</h3></center>");
		}
		else
		{
			deleteStudent(request, response);
		}
	}
	
	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	{
		String srollno = request.getParameter("rollno");
		int rollno = Integer.parseInt(srollno);
		StudentDao.delete(rollno);
		RequestDispatcher rd = request.getRequestDispatcher("viewstudent");
		rd.forward(request, response);

	}
}
