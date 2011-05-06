/*
 * Copyright 2010 Asaph Engel
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

import java.util.Arrays;
import java.util.List;

/**
 * @author Asaph Engel
 *
 */
public class CreditCardType {
	// reference http://www.beachnet.com/~hstiles/cardtype.html
	public final static CreditCardType VISA = new CreditCardType("Visa", new Integer[] {16, 13}, "4", Luhn.LUHNMOD10);
	public final static CreditCardType MASTERCARD = new CreditCardType("Mastercard", 16, new String[] {"51", "52", "53", "54", "55"}, Luhn.LUHNMOD10);
	public final static CreditCardType AMEX = new CreditCardType("American Express", 15, new String[] {"34", "37"}, Luhn.LUHNMOD10);
	public final static CreditCardType DINERS_CLUB = new CreditCardType("Diners Club/Carte Blanche", 14, new String[] {"300", "301", "302", "303", "304", "305", "36", "38"}, Luhn.LUHNMOD10);
	public final static CreditCardType DISCOVER = new CreditCardType("Discover", 16, "6011", Luhn.LUHNMOD10);
	public final static CreditCardType ENROUTE = new CreditCardType("enRoute", 15, new String[] {"2014", "2149"}, Luhn.LUHNMOD10); // not mod 10 but "any"???
	public final static CreditCardType JCB1 = new CreditCardType("JCB", 16, "3", Luhn.LUHNMOD10);
	public final static CreditCardType JCB2 = new CreditCardType("JCB", 15, new String[] {"2131", "1800"}, Luhn.LUHNMOD10);
		
	protected String name;
	protected List<Integer> digitCounts;
	protected List<String> prefixes;
	protected CheckAlgorithm checkAlgorithm;
	
	public CreditCardType(String name, List<Integer> digitCounts, List<String> prefixes, CheckAlgorithm checkAlgorithm) {
		this.name = name;
		this.digitCounts = digitCounts;
		this.prefixes = prefixes;
		this.checkAlgorithm = checkAlgorithm;
	}
	
	public CreditCardType(String name, Integer[] digitCounts, String[] prefixes, CheckAlgorithm checkAlgorithm) {
		this(name, Arrays.asList(digitCounts), Arrays.asList(prefixes), checkAlgorithm);
	}
	
	public CreditCardType(String name, int digitCount, String[] prefixes, CheckAlgorithm checkAlgorithm) {
		this(name, new Integer[] {digitCount}, prefixes, checkAlgorithm);
	}
	
	public CreditCardType(String name, Integer[] digitCounts, String prefix, CheckAlgorithm checkAlgorithm) {
		this(name, digitCounts, new String[] {prefix}, checkAlgorithm);
	}
	
	public CreditCardType(String name, int digitCount, String prefix, CheckAlgorithm checkAlgorithm) {
		this(name, new Integer[] {digitCount}, new String[] {prefix}, checkAlgorithm);
	}
	
	public boolean isValid(String number) {
		int digitCount = number.length();
		if (!this.digitCounts.contains(digitCount)) {
			return false;
		}
		boolean prefixMatched = false;
		for (String prefix : this.prefixes) {
			if (number.startsWith(prefix)) {
				prefixMatched = true;
				break;
			}
		}
		if (!prefixMatched) {
			return false;
		}
		return this.checkAlgorithm.isValid(number);
	}
}
