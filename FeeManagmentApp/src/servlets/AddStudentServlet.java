package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import bean.StudentBean;
import dao.StudentDao;

@WebServlet("/addstudent")
public class AddStudentServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		if(session == null || session.getAttribute("accountant")==null)
		{
			request.getRequestDispatcher("accountant/accountantlogin.jsp").include(request, response);
			out.println("<center><h2>Not Accountant!</h2><center>");
		}
		else
		{
			response.sendRedirect("accountant/addstudent.jsp");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		if(session == null || session.getAttribute("accountant")==null)
		{
			out.println("<p>Not Accountant!</p>");
			request.getRequestDispatcher("accountant/accountantlogin.jsp").include(request, response);
		}
		else
		{
			if(StudentAdded(request, response) == 1)
			{
				ViewStudentServlet.listStudent(request, response);
				out.println("<center><h3>Student added succesfully.</h3><center>");
			}
			else
			{
				request.getRequestDispatcher("accountant/addstudent.jsp.jsp").include(request, response);
				out.println("<center><h3>OOPS..Something went wrong!</h3><center>");
			}
		}

	}
	
	private int StudentAdded(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String name = request.getParameter("name");
	 	String email = request.getParameter("email");
		String sex = request.getParameter("sex");
		String course = request.getParameter("course");
		int fee = Integer.parseInt(request.getParameter("fee"));
		int paid = Integer.parseInt(request.getParameter("paid"));
		int due = fee - paid;
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
		
		StudentBean bean=new StudentBean(name, email, sex, course, fee, paid, due, address, contact);
		int status=StudentDao.save(bean);
		
	
		return status;
	}

}
