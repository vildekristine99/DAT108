package no.hvl.dat108;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "f15demo", name = "student")
public class Student {

    @Id
    private String id;
    private String navn;
    
    @ManyToOne
    @JoinColumn(name="klasse_kode", referencedColumnName = "kode")
    private Klasse klasse;

	public String getId() {
		return id;
	}

	public String getNavn() {
		return navn;
	}

	public Klasse getKlasse() {
		return klasse;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public void setKlasse(Klasse klasse) {
		this.klasse = klasse;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", navn=" + navn + ", klasse=" + klasse.getKode() + "]";
	}
	
}
