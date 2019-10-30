package no.hvl.dat108;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Metoder {
	public static void loggInn(HttpServletRequest request, String mobilnr, String fornavn, String etternavn, char kjonn) {
		loggUt(request);
		HttpSession sesjon = request.getSession();
	    sesjon.setAttribute("mobil", mobilnr);
	    sesjon.setAttribute("fornavn", fornavn);
	    sesjon.setAttribute("etternavn", etternavn);
	    sesjon.setAttribute("kjonn", kjonn);
	}
	
	public static void loggUt(HttpServletRequest request) {
		HttpSession sesjon = request.getSession(false);
	    if (sesjon != null) {
	        sesjon.invalidate();
	    }
	}

}
