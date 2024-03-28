package jannesh;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/adminAction")
public class AdminAction extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		adminDAO obj = new adminDAO();
		ArrayList<User> list = obj.getAllUsers();
		System.out.println(list.toString());
		
		out.print("<html><body>");
		out.print("<html><body><b>Name  | Username</b></body></html>");
		out.print("<html><body><br>----------------------------<br></body></html>");
		for(int i=0;i<list.size();i++) {
			out.println(list.get(i));
			out.print("<html><br><br></body></html>");
		}
		out.print("</body></html>");
		
		
	}
	

}
