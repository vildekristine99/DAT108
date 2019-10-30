package no.hvl.dat108;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loggInn")
public class InnloggingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	DeltagerEAO deltagerEAO;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String feilkode = request.getParameter("feilkode");
		
        request.getRequestDispatcher("WEB-INF/innlogging.jsp").forward(request, response);
        
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String mobil = request.getParameter("mobil");
		String passord = request.getParameter("passord");
		
		Deltager d = deltagerEAO.hentBruker(mobil);
		
		String feilmelding = "Ugyldig brukernavn og/eller passord";
		if(d == null) {		//bruker eksisterer ikke
			//feilkode
			request.getSession().setAttribute("feilmelding", feilmelding);
			response.sendRedirect("loggInn");
		} else {
			request.getSession().removeAttribute("feilmelding");
			Hashing hash = new Hashing(Hashing.SHA256);
			
			String passordHash = d.getPassordhash();
			String passordSalt = d.getPassordsalt();
			
			boolean likt = false;
			
			try {
				likt = hash.validatePasswordWithSalt(passord, passordSalt, passordHash);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			
			
			if(likt) {
				Metoder.loggInn(request, mobil, d.getFornavn(), d.getEtternavn(), d.getKjonn());
				response.sendRedirect("deltagerliste");
			} else {
				request.getSession().setAttribute("feilmelding", feilmelding);
				response.sendRedirect("loggInn");
			}
		}
	}

}
