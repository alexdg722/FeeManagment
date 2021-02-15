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

@WebServlet("/viewstudent")
public class ViewStudentServlet extends HttpServlet {

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
        
		if(session == null || session.getAttribute("accountant") == null)
		{
			request.getRequestDispatcher("accountant/accountantlogin.jsp").include(request, response);
			out.println("<center><h3>You need to log in first.</h3></center>");
		}
		else
		{
		listStudent(request, response);
		}

	}
	
	public static void listStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		List<StudentBean> studentList = StudentDao.getAllRecords();
		
		request.setAttribute("studentList", studentList);
		request.getRequestDispatcher("accountant/viewstudent.jsp").include(request, response);
	}
}
