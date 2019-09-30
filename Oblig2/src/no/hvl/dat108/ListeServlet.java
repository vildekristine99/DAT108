package no.hvl.dat108;


//import static no.hvl.dat108.UrlMapping.LISTE_URL;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringEscapeUtils;

import static no.hvl.dat108.UrlMappings.LISTE_URL;

@WebServlet("/" + LISTE_URL)
public class ListeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Liste liste;
	
	 @Override
	public void init() throws ServletException {
    	liste = new Liste();
    }
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sesjon = request.getSession(false);
		if(sesjon == null || sesjon.getAttribute("passord") == null) {
			response.sendRedirect("login?feilkode=2");
		} else {
			
			response.setContentType("text/html; charset=ISO-8859-1");
	
			PrintWriter out = response.getWriter();
	
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
	        out.println("<style type=\"text/css\">\r\n" + 
					"		body{\r\n" + 
					"			background-color: lightblue;\r\n" + 
					"		} \r\n" + 
					"		input[type=submit] {\r\n" + 
					"			cursor:pointer;\r\n" + 
					"		}\r\n" + 
					"	</style>");
			out.println("<meta charset=\"ISO-8859-1\">");
			out.println("<title>Handleliste</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<form action=\""+LISTE_URL+"\" method=\"post\">");
			out.println("<fieldset>");
			out.println("<legend>Handleliste</legend>");
			out.println("<p><input type=\"submit\" value=\"Legg til\"/> <input type=\"text\" name=\"vare\" /><br/></p>");
			out.println("</fieldset>");
			out.println("</form>");
			out.println("<p> Din handleliste:<br />");
			
	
	        // Inn noe kode her for � vise innhold i handleliste:
			
			for (Vare vare : liste.getListe()) {
				out.println("<form action=\""+LISTE_URL+"\" method=\"post\"> "
						+ "<input type=\"hidden\" name=\"inputId\" value=\"" + liste.indexOf(vare) + "\"/>"
						+ "<input type=\"submit\" value=\"Slett\"/>" + vare.getName() + "</form>");
			}
			
			out.println("</p>");
			out.println("</body>");
			out.println("</html>");
			
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			HttpSession sesjon = request.getSession(false);
			
			if(sesjon == null) {
				response.sendRedirect("login?feilkode=3");
			} else {
				
				String slett = request.getParameter("inputId");
				String vareInput = request.getParameter("vare");
				
				
				if(vareInput != null) {
					vareInput = StringEscapeUtils.escapeHtml(vareInput);
					if(vareInput.matches("^\\S(.*)$")) {
						synchronized(liste) {
							Vare vare = new Vare(vareInput);
							liste.addVare(vare);
						}
					}
				}
				
				if(slett != null) {
					slett = StringEscapeUtils.escapeHtml(slett);
					synchronized(liste) {
						int index = Integer.parseInt(slett);
						liste.deleteVare(index);
					}
				}
								
				response.sendRedirect(LISTE_URL);
			}
		
	}
}