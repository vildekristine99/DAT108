package no.hvl.dat108;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class Teste {
	
	@Test
	public void FornavnErGyldig() {
		assertFalse(Skjema.fornavnGyldig("a"));
		assertFalse(Skjema.fornavnGyldig("Abcdefghijklmnopqrstuvwxyz"));
		assertFalse(Skjema.fornavnGyldig("*^¨43"));
		assertTrue(Skjema.fornavnGyldig("Vilde-Kristine Åse"));
	}
	
	@Test
	public void EtternavnErGyldig() {
		assertFalse(Skjema.etternavnGyldig("a"));
		assertFalse(Skjema.etternavnGyldig("Abcdefghijklmnopqrstuvwxyz"));
		assertFalse(Skjema.etternavnGyldig("Vilde-Kristine Åse"));
		assertTrue(Skjema.etternavnGyldig("Fossum-Gustavsen"));
	}
	
	@Test
	public void MobilErGyldig() {
		assertFalse(Skjema.mobilGyldig("123456789"));
		assertFalse(Skjema.mobilGyldig("jwor"));
		assertTrue(Skjema.mobilGyldig("98422251"));
	}
	
	@Test
	public void PassordErGyldig() {
		assertFalse(Skjema.passordGyldig("passord123", "passord1234"));
		assertFalse(Skjema.passordGyldig("pass", "pass"));
		assertTrue(Skjema.passordGyldig("passord123123", "passord123123"));
	}
	
	@Test
	public void KjonnErGyldig() {
		assertFalse(Skjema.kjonnGyldig('J'));
		assertTrue(Skjema.kjonnGyldig('M'));
	}
	
}
