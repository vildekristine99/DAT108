package no.hvl.dat108;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import no.hvl.dat108.ValidateInput;

public class TestServletTemp {
	private ValidateInput validator = new ValidateInput();
	
	@Test
	public void nullStringInvalid() {
		assertFalse(validator.inputIsValid(null, null));
	}
	
	@Test
	public void tomStringInvalid() {
		assertFalse(validator.inputIsValid("", ""));
	}
	
	@Test
	public void toSmallCInvalid() {
		assertFalse(validator.inputIsValid("-4000.0", "cf"));
	}
	
	@Test
	public void toSmallKInvalid() {
		assertFalse(validator.inputIsValid("-4000.0", "fc"));
	}
	
	@Test
	public void tallNotValid() {
		assertFalse(validator.inputIsValid("jeirj", "fc"));
		assertFalse(validator.inputIsValid("  ", "fc"));
		assertFalse(validator.inputIsValid("3", "cf"));
	}
	
	@Test
	public void ansRigth() {
		Double tall = 34.6;
		Double tall2 = 34.567;
		assertTrue((toOneDecimal(tall2)) == tall);
	}
	
	private double toOneDecimal(Double i) {
		return Math.round(i*10.0)/10.0;
	}
	
}
