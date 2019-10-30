package no.hvl.dat108;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "oblig3_2019", name = "Deltager")
public class Deltager {
	@Id
	private String mobil;
	private String passordhash;
	private String passordsalt;
	private String fornavn;
	private String etternavn;
	private char kjonn;
	
	public Deltager() {
		
	}
	
	public Deltager(String mobil, String passordhash, String passordsalt, String fornavn, String etternavn,
			char kjonn) {
		this.mobil = mobil;
		this.passordhash = passordhash;
		this.passordsalt = passordsalt;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.kjonn = kjonn;
	}
	
	public String getMobil() {
		return mobil;
	}
	public void setMobil(String mobil) {
		this.mobil = mobil;
	}
	public String getPassordhash() {
		return passordhash;
	}
	public void setPassordhash(String passordhash) {
		this.passordhash = passordhash;
	}

	public String getPassordsalt() {
		return passordsalt;
	}

	public void setPassordsalt(String passordsalt) {
		this.passordsalt = passordsalt;
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
	public char getKjonn() {
		return kjonn;
	}
	public void setKjonn(char kjonn) {
		this.kjonn = kjonn;
	}
	
	
}
