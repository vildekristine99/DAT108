package no.hvl.dat108;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class DeltagerEAO {
	
	@PersistenceContext(name = "deltagerPU")
    private EntityManager em;
	
	public void leggTilDeltager(Deltager deltager) {
		em.persist(deltager);
	}
	
	public List<Deltager> hentDeltagere() {
		TypedQuery<Deltager> query = em.createQuery("SELECT d FROM Deltaker d", Deltager.class);
        return query.getResultList();
	}
}
