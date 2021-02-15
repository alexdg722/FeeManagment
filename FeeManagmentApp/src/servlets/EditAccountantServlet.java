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

import bean.AccountantBean;
import dao.AccountantDao;


@WebServlet("/editaccountant")
public class EditAccountantServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		
		if(session == null || session.getAttribute("admin")==null)
		{
			
			request.getRequestDispatcher("admin/editaccountant.jsp").include(request, response);
			out.println("<center><h3>You need to log in first22.</h3></center>");
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
		
		int id = Integer.parseInt(request.getParameter("id"));
		AccountantBean existingAccountant = AccountantDao.getRecordById(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("admin/editaccountant.jsp");
		request.setAttribute("bean", existingAccountant);
		dispatcher.forward(request, response);

	}
}
