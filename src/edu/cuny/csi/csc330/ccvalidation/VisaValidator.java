/**
 * 
 */
package edu.cuny.csi.csc330.ccvalidation;

/**
 * @author lji
 *
 */
public class VisaValidator extends BaseValidator implements Validator {

	public Integer getAccountNumberLength() {
		return Integer.valueOf(16);
	}
	
	protected Boolean isValidSpecific() {
		return Boolean.TRUE;
	}
}
