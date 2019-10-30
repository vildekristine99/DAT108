package no.hvl.dat108;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/bekreftelse")
public class BekreftelseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	private DeltagerEAO deltagerEAO;
	
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
    	String mobil = (String) request.getSession().getAttribute("mobil");
    	
		if(mobil != null) {
			request.getRequestDispatcher("WEB-INF/bekreftelse.jsp").forward(request, response);
		} else {
			response.sendRedirect("loggInn?feilkode=1");
		}
    }
}
