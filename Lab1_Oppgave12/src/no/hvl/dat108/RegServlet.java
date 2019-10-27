package no.hvl.dat108;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/registrer")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String fornavn = "";
    	String etternavn = "";
    	Cookie[] cookies = request.getCookies();
    	if(cookies !=  null) {
    		fornavn = c.getName();
    		etternavn = c.getValue();
    		
     	}
    	
        response.setContentType("text/html; charset=ISO-8859-1");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"ISO-8859-1\">");
        out.println("<title>Registrer</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<form action=\"registrer\" method=\"post\">");
        out.println("  <fieldset>");
        out.println("    <legend>Personlige opplysninger</legend>");
        out.println("    <p>Fornavn: <input type=\"text\" name=\"fronavn\"/></p>");
        out.println("    <p>Etternavn: <input type=\"text\" name=\"etternavn\"/></p>");
        out.println("    <input type=\"submit\" value=\"Registrer\" />");
        out.println("  </fieldset>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
        
    }

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fornavn = request.getParameter("fornavn");
		String etternavn = request.getParameter("etternavn");
		
		Cookie[] cookies = request.getCookies();
		
		
		Cookie c = new Cookie(fornavn, etternavn);
		response.addCookie(c);
	}

}
