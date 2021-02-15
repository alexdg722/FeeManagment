package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import bean.StudentBean;
import dao.StudentDao;

@WebServlet("/updatestudent")
public class UpdateStudentServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession();
		
		if(session == null || session.getAttribute("accountant") == null)
		{
			request.getRequestDispatcher("accountant/accountantlogin.jsp").include(request, response);
			out.println("<center><h3>You need to log in first.</h3></center>");
		}
		else
		{
			try 
			{
		    updateStudent(request, response);
		    ViewStudentServlet.listStudent(request, response);
			out.println("<center><h3>Student updated succesfully.</h3></center>");
			} catch (SQLException | IOException e) {
			e.printStackTrace();
			}
		}
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		int rollno = Integer.parseInt(request.getParameter("rollno"));
		String name = request.getParameter("name");
	 	String email = request.getParameter("email");
		String sex = request.getParameter("sex");
		String course = request.getParameter("course");
		int fee = Integer.parseInt(request.getParameter("fee"));
		int paid = Integer.parseInt(request.getParameter("paid"));
		int due = (Integer.parseInt(request.getParameter("fee")) - Integer.parseInt(request.getParameter("paid")));
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
		
		StudentBean bean = new StudentBean(rollno,name, email, sex, course, fee, paid, due, address, contact);
		StudentDao.update(bean);
	}
}
