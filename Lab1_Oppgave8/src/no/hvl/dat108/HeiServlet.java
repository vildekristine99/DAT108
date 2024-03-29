package no.hvl.dat108;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hilse")
public class HeiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String escapeHtml(String s) {
		String resultat = s;
		resultat = resultat.replaceAll("<", "&lt;");
		resultat = resultat.replaceAll(">", "&gt;");
		resultat = resultat.replaceAll("\"", "&quot;");
		resultat = resultat.replaceAll("\'", "&apos;");
		return resultat;
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String l = "se,no,en";
		Locale.LanguageRange.parse(l);
		String acceptLanguage = request.getHeader("Accept-Language");
		String brukerinput = request.getParameter("name");
		brukerinput = escapeHtml(brukerinput);
		
		response.setHeader("Content-Language", "en");
		response.setContentType("text/html; charset=ISO-8859-1");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<style type=\"text/css\">\r\n" + 
				"		body{\r\n" + 
				"			background-color: lightpink;\r\n" + 
				"			font-family: \"Arial\", Arial, sans-serif;\r\n" + 
				"			color: #544B4F;\r\n" + 
				"		} \r\n" + 
				"		form{\r\n" + 
				"			margin: 5px;\r\n" + 
				"			border-color: white;\r\n" + 
				"		}\r\n" + 
				"		legend{\r\n" + 
				"			margin: 2px;\r\n" + 
				"			border-color: white;\r\n" + 
				"			font-weight: bold;\r\n" + 
				"			color: #6A5F64;\r\n" + 
				"		}\r\n" + 
				"		fieldset {\r\n" + 
				"			border:1px solid white;\r\n" + 
				"		}\r\n" + 
				"		p {\r\n" + 
				"			color: #6A5F64;\r\n" + 
				"			padding: 10px;\r\n" + 
				"			border: 1px solid white;\r\\n"	+
				"		}\r\n" + 
				"		button {\r\n" + 
				"			background-color: white;\r\n" + 
				"			color: #544B4F;\r\n" + 
				"			cursor:pointer;\r\n" + 
				"			border-radius: 7px; \r\n" + 
				"			font-size: p15x;\r\n" + 
				"			padding-left: 8px;\r\n" + 
				"			padding-right: 8px;\r\n" + 
				"			padding-top: 5px;\r\n" + 
				"			padding-bottom: 5px;\r\n" + 
				"		}\r\n" + 
				"		a {" + 
				"			text-decoration: none;\r\n" +
				"			background-color: none;\r\n" +
				"		}\r\n" +
				"	</style>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>Hei</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>Hei " + brukerinput + "!</h2>");
		out.println("<p>" + acceptLanguage + "</p>");
		out.println("<button type=\"button\"><a href=\"/Lab18/\">Pr�v igjen</a></button>");
		out.println("</body>");
		out.println("</html>");
	}

}
