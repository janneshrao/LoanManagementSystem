package jannesh;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		res.setContentType("text/html");
		PrintWriter out = res.getWriter();

		RequestDispatcher rd;
		if (req.getParameter("login").equals("Login")) {

			String uname = req.getParameter("username");
			String pword = req.getParameter("pword");

			User obj = new UserDAO().retriveUser(uname);

			if (pword.equals(obj.getPword())) {
				out.print("<html><body><b>Login Successfull..!!<b></body></html>");
				
				ServletContext sct = this.getServletContext();
				sct.setAttribute("name", obj.getName());

				Cookie c = new Cookie("uname", uname);
				c.setValue(uname);
				res.addCookie(c);

				rd = req.getRequestDispatcher("home.html");
				rd.include(req, res);

			} else {
				out.print("<html><body><b>Login Unuccessfull..!! Please try again<b></body></html>");
				rd = req.getRequestDispatcher("index.html");
				rd.include(req, res);
			}
		}
	}
}
