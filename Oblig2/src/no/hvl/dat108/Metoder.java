package no.hvl.dat108;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class Metoder {
	
	public static void loggUt(HttpServletRequest req) {
		HttpSession sesjon = req.getSession(false);
		if(sesjon != null) {
			sesjon.invalidate();
		}
	}
	
	
}