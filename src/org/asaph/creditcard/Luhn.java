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

/**
 * @author asaph
 *
 */
public class Luhn implements CheckAlgorithm { 
	public final static int DEFAULT_MOD_OPERAND = 10;
	public final static Luhn LUHNMOD10 = new Luhn(DEFAULT_MOD_OPERAND);
	public final static Luhn LUHNMOD5 = new Luhn(5);
	
	protected int modOperand;

	public Luhn(int modOperand) {
		this.modOperand = modOperand;
	}
	
	public Luhn() {
		this(Luhn.DEFAULT_MOD_OPERAND);
	}

	/**
	 * @return the modOperand
	 */
	public int getModOperand() {
		return modOperand;
	}

	/**
	 * @param modOperand the modOperand to set
	 */
	public void setModOperand(int modOperand) {
		this.modOperand = modOperand;
	}
	
	public boolean isValid(String number) {
		int sum = 0;
		for (int i=number.length()-1, j=1; i>=0; i--, j++) {
			char ch = number.charAt(i);
			if (!Character.isDigit(ch)) {
				throw new IllegalArgumentException("Invalid number: " + number);
			}
			int n =  Character.digit(ch, 10);
			if (j % 2 == 0) {
				int doubled = n + n;
				if (doubled >= 10) {
					int onesColumn = doubled % 10;
					int tensColumn = (doubled - onesColumn)/10;
					sum += onesColumn + tensColumn;
				} else {
					sum += doubled;
				}
			} else {
				sum += n;
			}
		}
		return sum % this.modOperand == 0;
	}
}
