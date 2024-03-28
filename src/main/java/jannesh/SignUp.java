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
@WebServlet("/signup")
public class SignUp extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html");
		PrintWriter out = res.getWriter();

		String pword = req.getParameter("pword");
		String cpword = req.getParameter("cpword");

		if (pword.equals(cpword)) {
			String name = req.getParameter("name");
			String uname = req.getParameter("uname");

			User obj = new User();
			obj.setName(name);
			obj.setUname(uname);
			obj.setPword(pword);

			UserDAO dao = new UserDAO();
			int k = dao.saveUser(obj);
			if (k > 0) {
				out.print("<html><body>");
				out.print("<b>Sign up successfull..!!</b>");
				out.print("</html></body>");
			} else {
				out.print("<html><body>");
				out.print("<b>Internal Error, we are working on it..!!!</b>");
				out.print("</html></body>");
			}
		} else {
			out.print("<html><body>");
			out.print("<b>passwords doesn't match..!!</b>");
			out.print("</html></body>");

			RequestDispatcher rd = req.getRequestDispatcher("index.html");
			rd.include(req, res);
		}

	}

}
