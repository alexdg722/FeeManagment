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

import bean.AccountantBean;
import dao.AccountantDao;

@WebServlet("/updateaccountant")
public class UpdateAccountantServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession();
		
		if(session == null || session.getAttribute("admin")==null)
		{
			request.getRequestDispatcher("admin/adminlogin.jsp").include(request, response);
			out.println("<center><h3>You need to log in first.</h3></center>");
		}
		else
		{
			try 
			{
			updateAccountant(request, response);
			ViewAccountantServlet.accountantList(request, response);
			out.println("<center><h3>Accountant updated succesfully.</h3></center>");
			} catch (SQLException | IOException e) {
			e.printStackTrace();
			}
		}
	}

	private void updateAccountant(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
	 	String email = request.getParameter("email");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
	
		AccountantBean bean = new AccountantBean(id,firstname,lastname, email, password, address, contact);
		AccountantDao.update(bean);
		
	}
}
