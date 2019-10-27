package no.hvl.dat108;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PaameldingServlet
 */
@WebServlet("/paamelding")
public class PaameldingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	DeltagerEAO deltagerEAO;
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/paamelding.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Skjema Skjema = new Skjema(request);
		
		if(!Skjema.erGyldig()) {
			Skjema.settOppFeilmeldinger();
			request.getSession().setAttribute("DeltagerValidering", Skjema);
			response.sendRedirect("paamelding");
		} else {
			request.getSession().removeAttribute("DeltagerValidering");
			
			Deltager deltager = Skjema.nyDeltager();
			deltagerEAO.leggTilDeltager(deltager);
			
			response.sendRedirect("bekreftelse");
		}
		
		
		
	}

}
