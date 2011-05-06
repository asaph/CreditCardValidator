/**
 * 
 */
package org.asaph.creditcard;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author asaphengel
 *
 */
public class LuhnTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link org.asaph.creditcard.Luhn#Luhn(int)}.
	 */
	@Test
	public final void testLuhnInt() {
		Luhn luhn = new Luhn(5);
		assertEquals(5, luhn.getModOperand());
	}

	/**
	 * Test method for {@link org.asaph.creditcard.Luhn#Luhn()}.
	 */
	@Test
	public final void testLuhn() {
		Luhn luhn = new Luhn();
		assertEquals(10, luhn.getModOperand());
	}

	/**
	 * Test method for {@link org.asaph.creditcard.Luhn#isValid()}.
	 */
	@Test
	public final void testValid() {
		Luhn luhn = new Luhn();
		assertTrue(luhn.isValid("4111111111111111"));
	}

	/**
	 * Test method for {@link org.asaph.creditcard.Luhn#isValid()}.
	 */
	@Test
	public final void testNotValid() {
		Luhn luhn = new Luhn();
		assertFalse(luhn.isValid("4111111111111110"));
	}

	/**
	 * Test method for {@link org.asaph.creditcard.Luhn#isValid()}.
	 */
	@Test(expected=IllegalArgumentException.class)
	public final void testIllegalArgumentToIsValid() {
		Luhn luhn = new Luhn();
		luhn.isValid("4111111somewords111111110");
	}
}
