import static org.junit.Assert.*;

import org.junit.Test;

public class FractionTest {

	@Test
	public void testMult() {
		Fraction fract1 = new Fraction(1, 2);
		Fraction fract2 = new Fraction(3, 4);
		Fraction fract3 = fract1.multiply(fract2);
		assertTrue(fract3.getNumerator() == 3);
		assertTrue(fract3.getDenominator() == 8);
		
	}
	
	@Test
	public void testAdd() {
		Fraction fract1 = new Fraction(1, 2);
		Fraction fract2 = new Fraction(3, 4);
		Fraction fract3 = fract1.add(fract2);
		fract3.printFraction();
		assertTrue(fract3.getNumerator() == 5);
		assertTrue(fract3.getDenominator() == 4);
	}
	
	@Test
	public void testReciprocal() {
		Fraction fract1 = new Fraction(1, 2);
		Fraction fract2 = fract1.reciprocal();
		assertTrue(fract2.getNumerator() == 2);
		assertTrue(fract2.getDenominator() == 1);
	}
	
	@Test
	public void testSimplify() {
		Fraction fract1 = new Fraction(16, 32);
		Fraction fract2 = fract1.simplify();
		assertTrue(fract2.getNumerator() == 1);
		assertTrue(fract2.getDenominator() == 2);
	}
	
	
}
