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
import bean.StudentBean;
import dao.StudentDao;


@WebServlet("/searchstudent")
public class SearchStudentServlet extends HttpServlet{

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
		try {
			searchStudent(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
	private void searchStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out=response.getWriter();

		int rollno = Integer.parseInt(request.getParameter("rollno"));
		StudentBean searchedStudent = StudentDao.getRecordByRollno(rollno);

		if(searchedStudent.getRollno() > 0)
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("accountant/viewsearchedstudent.jsp");
			request.setAttribute("searchedStudent", searchedStudent);
			dispatcher.forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("accountant/viewstudent.jsp").include(request, response);
			out.println("<center><p>Sorry, no record found for rollno: " + rollno + "</p></center>");

		}
	}
}
