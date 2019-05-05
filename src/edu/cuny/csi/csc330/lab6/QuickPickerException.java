package edu.cuny.csi.csc330.lab6;

public class QuickPickerException extends Exception {
	
	private int code;
	private String propertyFileName;
	
	private static final String[] MESSAGE = {
			"FILE NOT FOUND",
			"MISSING PROPERTY"
	};

	private QuickPickerException() {
		
	}
	
	public QuickPickerException(String propertyFileName, int code) {
		this.code = code;
		this.propertyFileName = propertyFileName;
	}

	@Override
	public String toString() {
		return "QuickPickerException - ERROR CODE " + code + ": FILE NAME \"" + propertyFileName + "\" " + MESSAGE[code];
	}
	
	
}
