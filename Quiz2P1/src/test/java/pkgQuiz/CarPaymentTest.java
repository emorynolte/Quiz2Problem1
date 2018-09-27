package pkgQuiz;


import static org.junit.Assert.*;

import org.apache.commons.math3.util.Precision;
import org.junit.Test;

public class CarPaymentTest {

	@Test
	public void CarPaymentTester() {
	
		int totalCost = 35000;
		double interestRate = 10;
		int loanLength = 60;
		
		// I imported a rounding method from apache.commons.math3 here because my doubles were always off by tiny amounts due to the error we discussed in class
		
		CarPayment c = new CarPayment(totalCost, 0, loanLength, interestRate);
		
		assertTrue(Precision.round(c.monthlyPayment(),2) == 743.65);
		assertTrue(Precision.round(c.totalInterest(),2) == 9618.79);
		
		int downPayment = 10000;
		
		CarPayment d = new CarPayment(totalCost, downPayment, loanLength, interestRate);
		
		assertTrue(Precision.round(d.monthlyPayment(),2) == 531.18);
		assertTrue(Precision.round(d.totalInterest(),2) == 6870.57);
	}

}
