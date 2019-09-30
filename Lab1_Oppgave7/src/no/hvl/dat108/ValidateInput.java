package no.hvl.dat108;

public class ValidateInput {
	
	public boolean inputIsValid(String s, String radio) {
		return s != null
				&& radio != null
				&& !s.isEmpty()
				&& !radio.isEmpty()
				&& gyldigTall(s)
				&& withInRange(s, radio);
	}
	
	public boolean gyldigTall(String s) {
		return s.matches("^(\\-)?(\\d+)(\\.\\d+)$");
	}
	
	private boolean withInRange(String s, String radio) {
		boolean result = true;
		Double d = Double.parseDouble(s);
		if(radio.equals("cf"))
			if(d < -273.15) {
				result = false;
				return result;
			}
		if(radio.equals("fc")) {
			if(d < -459.67) {
				result = false;
				return result;
			}
		}
		return result;
	}
}
