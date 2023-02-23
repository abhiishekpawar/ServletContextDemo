package org.pentagonspcae.contextApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import org.omg.IOP.ServiceContext;
@WebServlet("/ep")
public class ElectronicProduct extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse resp) 
			throws ServletException, IOException 
	{
		ServletContext ctx = getServletContext();
		
		//FETCHING CONTEXT PARAMETER
		String offermsg = ctx.getInitParameter("ofm");
		String offerperc= ctx.getInitParameter("ofp");
		
		//ADD ATTRIBUTE INTO THE SCOPE
		product p = new product();
		ctx.setAttribute("prd", p);
		
		
		PrintWriter out = resp.getWriter();
		out.println("<html><body bgcolor='orange'><h1>Electronic product deatils</h1>"
				+ "<br></br>"+offermsg+"the discount is "+offerperc+" %"+"<br></br>"
						+ "<a href=\"product.html\">Back</a>"+"</body></html>");
		
		out.flush();
		out.close();
				
	}
	
	
	

}
