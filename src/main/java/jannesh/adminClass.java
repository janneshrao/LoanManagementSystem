package jannesh;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/adminLogin")
public class adminClass extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		String uname = req.getParameter("username");
		String pword = req.getParameter("pword");

		adminDAO obj = new adminDAO();
		String validatePword = obj.retriveAdmin(uname);
		
		RequestDispatcher rd;
		
		if(pword.equals(validatePword)) {
			rd = req.getRequestDispatcher("adminHome.html");
			rd.forward(req, res);
		} else {
			out.print("<html><body><b>Enter valid credentials</b></body></html>");
			rd = req.getRequestDispatcher("adminLogin.html");
			rd.include(req, res);
		}
		
	}
	
}
