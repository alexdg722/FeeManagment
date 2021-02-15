package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import bean.StudentBean;
import dao.StudentDao;

@WebServlet("/editstudent")
public class EditStudentServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(false);
		if(session == null||session.getAttribute("accountant") == null)
		{
			
			request.getRequestDispatcher("accountant/editstudent.jsp").include(request, response);
			out.println("<center><h3>You need to log in first.</h3></center>");
		}
		else
		{
		try {
			showEditForm(request, response);
		} catch (SQLException | ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
		int rollno = Integer.parseInt(request.getParameter("rollno"));
		StudentBean existingStudent = StudentDao.getRecordByRollno(rollno);
		RequestDispatcher dispatcher = request.getRequestDispatcher("accountant/editstudent.jsp");
		request.setAttribute("beanStudent", existingStudent);
		dispatcher.forward(request, response);

	}
}
