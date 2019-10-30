package no.hvl.dat108;

public class Skjema {
	private String fornavnError;
	private String etternavnError;
	private String mobilError;
	private String passordError;
	private String passordRepetertError;
	private String kjonnError;
	
	private String fornavn;
	private String etternavn;
	private String mobil;
	private String passord;
	private String passordRepetert;
	private char kjonn;
	
	
	Skjema(String mobil, String passord, String passordRepetert, String fornavn, String etternavn, char kjonn){
		this.mobil = mobil;
		this.passord = passord; 
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.kjonn = kjonn;
		this.passordRepetert = passordRepetert;
	}
	
	public boolean erGyldig() {
		return passordGyldig(passord, passordRepetert)
				&& mobilGyldig(mobil)
				&& fornavnGyldig(fornavn)
				&& etternavnGyldig(etternavn)
				&& kjonnGyldig(kjonn);
	}
	
	public void settOppFeilmeldinger() {
		if(!passordGyldig(passord, passordRepetert)) {	
			if(passord.equals(passordRepetert)) {
				passord = "";
				passordError = "Ugyldig passord";
			} else {
				passordRepetert = "";
				passordRepetertError = "Passord mÂ vÊre like";
			}
		}
		
		if(!mobilGyldig(mobil)) {
			mobil = "";
			mobilError = "Ugyldig mobilnummer";
		}
		
		if(!etternavnGyldig(etternavn)) {
			etternavn = "";
			etternavnError = "Ugyldig etternavn"; 
		}
		
		if(!fornavnGyldig(fornavn)) {
			fornavn = "";
			fornavnError = "Ugyldig fornavn";
		}
		
		if(!kjonnGyldig(kjonn)) {
			kjonnError = "Velg ett kjonn";
		}
	}

	public static boolean passordGyldig(String passord1, String passord2) {
		return passord1.equals(passord2)
				&& !passord1.isEmpty() && passord1 != null
						&& passord1.length() > 7;
	}
	 
	
	public static boolean mobilGyldig(String mobil) {
		return mobil.matches("^[0-9]{8}$") && !mobil.isEmpty() && mobil != null;
	}
	
	public static boolean fornavnGyldig(String fornavn) {
		return fornavn.matches("^[A-Z∆ÿ≈][a-zÊ¯ÂA-Z∆ÿ≈ -]{2,20}$") && !fornavn.isEmpty() && fornavn != null;
	}
	
	public static boolean etternavnGyldig(String etternavn) {
		return etternavn.matches("^[A-Z∆ÿ≈][a-zÊ¯ÂA-Z∆ÿ≈-]{2,20}$") && !etternavn.isEmpty() && etternavn != null;
	}
	
	public static boolean kjonnGyldig(char kjonn) {
		return (kjonn == 'K' || kjonn == 'M');
	}
	
	public String getFornavnError() {
		return fornavnError;
	}

	public void setFornavnError(String fornavnError) {
		this.fornavnError = fornavnError;
	}

	public String getEtternavnError() {
		return etternavnError;
	}

	public void setEtternavnError(String etternavnError) {
		this.etternavnError = etternavnError;
	}

	public String getMobilError() {
		return mobilError;
	}

	public void setMobilError(String mobilError) {
		this.mobilError = mobilError;
	}

	public String getPassordError() {
		return passordError;
	}

	public void setPassordError(String passordError) {
		this.passordError = passordError;
	}

	public String getPassordRepetertError() {
		return passordRepetertError;
	}

	public void setPassordRepetertError(String passordRepetertError) {
		this.passordRepetertError = passordRepetertError;
	}

	public String getKjonnError() {
		return kjonnError;
	}

	public void setKjonnError(String kjonnError) {
		this.kjonnError = kjonnError;
	}
	 
	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getMobil() {
		return mobil;
	}

	public void setMobil(String mobil) {
		this.mobil = mobil;
	}

	public String getPassord() {
		return passord;
	}

	public void setPassord(String passord) {
		this.passord = passord;
	}

	public String getPassordRepetert() {
		return passordRepetert;
	}

	public void setPassordRepetert(String passordRepetert) {
		this.passordRepetert = passordRepetert;
	}

	public char getKjonn() {
		return kjonn;
	}

	public void setKjonn(char kjonn) {
		this.kjonn = kjonn;
	}
}
