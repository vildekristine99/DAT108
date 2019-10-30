package no.hvl.dat108;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeltakerlisteServlet
 */
@WebServlet("/deltagerliste")
public class DeltakerlisteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private DeltagerEAO deltagerEAO;
	
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mobil = (String) request.getSession().getAttribute("mobil");
    	
		if(mobil != null) {
    	
	    	List<Deltager> deltagerliste = deltagerEAO.hentDeltagereAlfabetisk();
	    	
	    	request.getSession().setAttribute("deltagerliste", deltagerliste);
	    	request.getRequestDispatcher("WEB-INF/deltagerliste.jsp").forward(request, response);
		} else {
			response.sendRedirect("loggInn?feilkode=1");
		}
	}

}
