package no.hvl.dat108;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class DeltagerEAO {
	
	@PersistenceContext(name = "deltagerPU")
    private EntityManager em;
	
	public Deltager hentBruker(String mobil) {
		return em.find(Deltager.class, mobil);
	}
	
	public void leggTilDeltager(Deltager deltager) {
		em.persist(deltager);
	}
	
	public boolean brukerEksisterer(String mobil) {
		Deltager d = hentBruker(mobil);
		return d != null;
	}
	
	public List<Deltager> hentDeltagereAlfabetisk() {
		TypedQuery<Deltager> query = em.createQuery("SELECT d FROM Deltager d", Deltager.class);
        List<Deltager> deltagerliste = query.getResultList();
        Comparator<Deltager> firstThenLast = Comparator.comparing(Deltager::getFornavn).thenComparing(Deltager::getEtternavn);
    	deltagerliste = deltagerliste.stream().sorted(firstThenLast).collect(Collectors.toList());
    	return deltagerliste;
	}
	
	
}
