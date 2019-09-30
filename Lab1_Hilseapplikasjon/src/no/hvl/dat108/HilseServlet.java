package no.hvl.dat108;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/HilseServlet")
public class HilseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String serverinfo;
	@Override
	public void init() throws ServletException {
		serverinfo = getServletContext().getServerInfo();
	}


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			String navn = "Verden";
			if(request.getParameter("navn") != null) {
				navn = request.getParameter("navn");
			}
			Date naa = new Date();
			String dato = DateFormat.getDateInstance(DateFormat.LONG).format(naa);
			response.setContentType("text/html; charset=ISO-8859-1");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"ISO-8859-1\">");
			out.println("<title>Lab1_Hilseapplikasjon</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Hallo " + navn + "!</h1>");
			out.println("<p>Denne siden ble produsert " + dato + ".</p>");
			out.println("<p>" + serverinfo + "</p>");
			out.println("</body>");
			out.println("</html>");
			 
			 
	}

}
