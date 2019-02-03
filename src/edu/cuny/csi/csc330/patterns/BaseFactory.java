package edu.cuny.csi.csc330.patterns;

import java.util.*;

public class BaseFactory {
	
	private static String DEFAULT_ENV = "j2se"; 
	protected static String env; 
	
	static {
		// so we're expecting a file in our CLASSPATH called PropertyBundleDemo.properties
		ResourceBundle bundle = ResourceBundle.getBundle("SampleFactory");
		
		if ( bundle.containsKey("deployment") ) {
			env = bundle.getString("deployment");
		}
		else {
			env = DEFAULT_ENV;
		}
	}
	

}
