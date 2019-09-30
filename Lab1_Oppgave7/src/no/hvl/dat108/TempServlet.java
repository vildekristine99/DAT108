package no.hvl.dat108;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/regne")
public class TempServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public TempServlet() {
		super();
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ValidateInput valid = new ValidateInput();
		
		String temp = request.getParameter("temp");
		String omregning = request.getParameter("radio");
		
		String responsmld = "";
		Double svar = 0.0;
		String symbol = "\u00B0";
		
		if(valid.inputIsValid(temp, omregning)) {
			Double tmp = Double.parseDouble(temp);
			if(omregning.equals("cf")) {
				svar = (tmp * 1.8) + 32;
				responsmld = "<h1>"+ String.format("%.1f", tmp) + symbol + "C = " +  String.format("%.1f", svar) + symbol+ "F </h1>";
			} else if(omregning.equals("fc")) {
				svar = (tmp - 32) / (1.8);
				responsmld = "<h1>"+ String.format("%.1f", tmp) + symbol + "F = " +  String.format("%.1f", svar) + symbol+ "C </h1>";
			}
		} else {
			responsmld = "<p>Ugyldig brukerinput. Temperaturen må være ett tall (lik eller over det absolutte nullpunkt). Pass også på at du har valgt en av omregningene før du trykker \"Regn om\"</p>";
		}
		
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
		out.println("<title>Temperatur</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>Temperaturomregning resultat</h2>");
		out.println(responsmld);
		out.println("<button type=\"button\"><a href=\"/Lab17/\">Prøv igjen</a></button>");
		out.println("</body>");
		out.println("</html>");
	}

	
}
