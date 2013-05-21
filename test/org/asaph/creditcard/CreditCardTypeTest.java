/*
 * Copyright 2010 asaph.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.asaph.creditcard;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author asaph
 *
 */
public class CreditCardTypeTest {
	// test credit card numbers from https://www.paypal.com/en_US/vhelp/paypalmanager_help/credit_card_numbers.htm
	public final static String AMEX_TEST_1 = "378282246310005";
	public final static String AMEX_TEST_2 = "371449635398431";
	public final static String AMEX_CORPORATE_TEST = "378734493671000";
	public final static String AUSTRALIAN_BANKCARD_TEST = "5610591081018250";
	public final static String DINERS_CLUB_TEST_1 = "30569309025904";
	public final static String DINERS_CLUB_TEST_2 = "38520000023237";
	public final static String DISCOVER_TEST_1 = "6011111111111117";
	public final static String DISCOVER_TEST_2 = "6011000990139424";
	public final static String JCB_TEST_1 = "3530111333300000";
	public final static String JCB_TEST_2 = "3566002020360505";
	public final static String MASTERCARD_TEST_1 = "5555555555554444";
	public final static String MASTERCARD_TEST_2 = "5105105105105100";
	public final static String VISA_TEST_1 = "4111111111111111";
	public final static String VISA_TEST_2 = "4012888888881881";
	public final static String VISA_13DIGIT_TEST = "4222222222222";
	
	public final static String VISA_WRONG_LENGTH_TEST = "411111111111116";

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
	 * Test method for {@link org.asaph.creditcard.CreditCardType#isValid(java.lang.String)}.
	 */
	@Test
	public final void testVisaWithValidNumbers() {
		assertTrue(CreditCardType.VISA.isValid(VISA_TEST_1));
		assertTrue(CreditCardType.VISA.isValid(VISA_TEST_2));
		assertTrue(CreditCardType.VISA.isValid(VISA_13DIGIT_TEST));
	}

	/**
	 * Test method for {@link org.asaph.creditcard.CreditCardType#isValid(java.lang.String)}.
	 */
	@Test
	public final void testVisaWithInvalidNumber() {
		assertFalse(CreditCardType.VISA.isValid("4111111111111112"));
	}

	/**
	 * Test method for {@link org.asaph.creditcard.CreditCardType#isValid(java.lang.String)}.
	 */
	@Test
	public final void testMastercardWithValidNumbers() {
		assertTrue(CreditCardType.MASTERCARD.isValid(MASTERCARD_TEST_1));
		assertTrue(CreditCardType.MASTERCARD.isValid(MASTERCARD_TEST_2));
	}

	/**
	 * Test method for {@link org.asaph.creditcard.CreditCardType#isValid(java.lang.String)}.
	 */
	@Test
	public final void testMastercardWithVisaNumber() {
		assertFalse(CreditCardType.MASTERCARD.isValid(VISA_TEST_1));
	}

	/**
	 * Test method for {@link org.asaph.creditcard.CreditCardType#isValid(java.lang.String)}.
	 */
	@Test
	public final void testAmexWithValidNumbers() {
		assertTrue(CreditCardType.AMEX.isValid(AMEX_TEST_1));
		assertTrue(CreditCardType.AMEX.isValid(AMEX_TEST_2));
		assertTrue(CreditCardType.AMEX.isValid(AMEX_CORPORATE_TEST));
	}

	/**
	 * Test method for {@link org.asaph.creditcard.CreditCardType#isValid(java.lang.String)}.
	 */
	@Test
	public final void testDinersClubWithValidNumbers() {
		assertTrue(CreditCardType.DINERS_CLUB.isValid(DINERS_CLUB_TEST_1));
		assertTrue(CreditCardType.DINERS_CLUB.isValid(DINERS_CLUB_TEST_2));
	}

	/**
	 * Test method for {@link org.asaph.creditcard.CreditCardType#isValid(java.lang.String)}.
	 */
	@Test
	public final void testDiscoverWithValidNumbers() {
		assertTrue(CreditCardType.DISCOVER.isValid(DISCOVER_TEST_1));
		assertTrue(CreditCardType.DISCOVER.isValid(DISCOVER_TEST_2));
	}


	/**
	 * Test method for {@link org.asaph.creditcard.CreditCardType#isValid(java.lang.String)}.
	 */
	@Test
	public final void testJCB1WithValidNumbers() {
		assertTrue(CreditCardType.JCB1.isValid(JCB_TEST_1));
		assertTrue(CreditCardType.JCB1.isValid(JCB_TEST_2));
	}
	
	@Test
	public final void testVisaWrongLength() {
		assertTrue(CreditCardType.VISA.checkAlgorithm.isValid(VISA_WRONG_LENGTH_TEST));
		assertFalse(CreditCardType.VISA.isValid(VISA_WRONG_LENGTH_TEST));
	}

}
