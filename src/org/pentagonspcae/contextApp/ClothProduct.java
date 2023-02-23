package org.pentagonspcae.contextApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/cp")
public class ClothProduct extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		ServletContext ctx = getServletContext();

		// FETCHING CONTEXT PARAMETER
		String offermsg = ctx.getInitParameter("ofm");
		String offerperc = ctx.getInitParameter("ofp");
		
		//FETCHING ATRIBUTE BACK FROM SCOPE
		product pd = (product) ctx.getAttribute("prd");//downcast to product
		
		PrintWriter out = resp.getWriter();
		out.println("<html><body bgcolor='orange'><h1>Cloth product deatils</h1>"
				+ "<br></br>"+offermsg+"the discount is "+offerperc+" %"+"<br></br>"
						+ "<a href=\"product.html\">Back</a>"+"</body></html>");
		
		out.flush();
		out.close();
		
	}

}
