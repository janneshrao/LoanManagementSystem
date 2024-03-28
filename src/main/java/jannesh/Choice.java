package jannesh;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/choice")
public class Choice extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		RequestDispatcher rd;
		String choice = req.getParameter("choice");

		// session tracking start
		Cookie sessionTracking[] = req.getCookies();
		if (sessionTracking == null) {
			out.print("<html><body><b>Session Expired...!!</b><br></body></html>");
			rd = req.getRequestDispatcher("index.html");
			rd.include(req, res);
		} else {
			// session tracking end
			
			ServletContext sct = this.getServletContext();
			if((String) sct.getAttribute("name") != null) out.print("Welcome : "+ (String) sct.getAttribute("name"));
			
			switch (choice) {
			case "Add Loan":
				rd = req.getRequestDispatcher("addLoan.html");
				rd.include(req, res);
				break;
			case "Delete Loan":
				rd = req.getRequestDispatcher("deleteLoan.html");
				rd.include(req, res);
				break;
			case "Pay Loan":
				rd = req.getRequestDispatcher("payLoan.html");
				rd.include(req, res);
				break;
			case "Logout":
				Cookie c[] = req.getCookies();
				c[0].setMaxAge(0);
				res.addCookie(c[0]);
				
				sct.removeAttribute("name");
				
				System.out.println((String) sct.getAttribute("name"));
				
				out.print("<html><body><b>Logout Successfull...!!</b></body></html><br>");

				rd = req.getRequestDispatcher("index.html");
				rd.forward(req, res);
				break;
			default:
				out.print("<html><body><b>Please enter valid choice</b></body></html>");
			}
		}
	}

}
