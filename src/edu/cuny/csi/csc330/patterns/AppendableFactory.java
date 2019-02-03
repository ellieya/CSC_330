package edu.cuny.csi.csc330.patterns;

import java.util.*;

public class AppendableFactory extends BaseFactory {
	
	private static int DEFAULT_BUFFER_SIZE = 1000; 
	private static int ENTERPRISE_BUFFER_SIZE = DEFAULT_BUFFER_SIZE * 10; 


	private AppendableFactory() {
		 
	}
	
	public static Appendable createAppendable() {
		return createAppendable(env); 
	}
	
	public static Appendable createAppendable(String hint) {
		
		Appendable buffer; 
		
		if("j2ee".equalsIgnoreCase(hint)) {
			buffer = new StringBuffer(ENTERPRISE_BUFFER_SIZE);
		}
		else {
			buffer = new StringBuilder(DEFAULT_BUFFER_SIZE);
		}
		
		return buffer; 
	}

}
