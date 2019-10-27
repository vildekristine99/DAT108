package no.hvl.dat108;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class Teste {
	
	@Test
	public void ErGyldig() {
		Deltager d = new Deltager("98422251", "passord123", "Vilde Kristine", "Fossum", 'K');
		Assert.assertTrue(Skjema.erGyldig(d, "passord123"));
	}

}
