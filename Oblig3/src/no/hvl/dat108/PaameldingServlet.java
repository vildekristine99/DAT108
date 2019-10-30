package no.hvl.dat108;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/paamelding")
public class PaameldingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private DeltagerEAO deltagerEAO;
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/paamelding.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String mobil = request.getParameter("mobil");
		String passord = request.getParameter("passord"); 
		String passordRepetert = request.getParameter("passordRepetert");
		String fornavn = request.getParameter("fornavn");
		String etternavn = request.getParameter("etternavn"); 
		char kjonn = request.getParameter("kjonn").charAt(0);
		
		
		Skjema Skjema = new Skjema(mobil, passord, passordRepetert, fornavn, etternavn, kjonn);
		
		if(!Skjema.erGyldig()) {
			Skjema.settOppFeilmeldinger();
			request.getSession().setAttribute("Skjema", Skjema);
			response.sendRedirect("paamelding");
		} else {
			Hashing hash = new Hashing(Hashing.SHA256);
			
			byte[] salt = hash.getSalt();
			
			try {
				hash.generateHashWithSalt(passord, salt);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			
			String passordHash = hash.getPasswordHashinHex();
			String passordSalt = hash.getPasswordSalt();
			
			Deltager deltager = new Deltager(mobil, passordHash, passordSalt, fornavn, etternavn, kjonn);
			deltagerEAO.leggTilDeltager(deltager);
			
			Metoder.loggInn(request, mobil, etternavn, fornavn, kjonn);
			
			request.getSession().removeAttribute("Skjema");
			response.sendRedirect("bekreftelse");
		}
		
		
		
	}

}
