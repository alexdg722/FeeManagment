package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.AccountantBean;
import dao.AccountantDao;

@WebServlet("/addaccountant")
public class AddAccountantServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		if(session == null || session.getAttribute("admin")==null)
		{
			request.getRequestDispatcher("admin/adminlogin.jsp").include(request, response);
			out.println("<center><h2>Not Admin!</h2><center>");
		}
		else
		{
			response.sendRedirect("admin/addaccountant.jsp");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		if(session == null || session.getAttribute("admin")==null)
		{
			out.println("<p>Not Admin!</p>");
			request.getRequestDispatcher("admin/adminlogin.jsp").include(request, response);
		}
		else
		{
			if(AccountantAdded(request, response) == 1)
			{
				ViewAccountantServlet.accountantList(request, response);
				out.println("<center><h3>Accountant added succesfully.</h3><center>");
			}
			else
			{
				request.getRequestDispatcher("admin/addaccountant.jsp").include(request, response);
				out.println("<center><h3>OOPS..Something went wrong!</h3><center>");
			}
		}

	}
	
	private int AccountantAdded(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		int status = 0;
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
		
		AccountantBean bean = new AccountantBean(firstname, lastname, email, password, address, contact);
		try {
			status=AccountantDao.save(bean);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		return status;
	}
		
}
