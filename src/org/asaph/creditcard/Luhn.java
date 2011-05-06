/**
 * 
 */
package org.asaph.creditcard;

/**
 * @author Asaph Engel
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
