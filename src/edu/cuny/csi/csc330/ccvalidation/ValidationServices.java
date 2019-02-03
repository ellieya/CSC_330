/**
 * 
 */
package edu.cuny.csi.csc330.ccvalidation;

import java.util.*;
import java.util.concurrent.*;

/**
 * provides instances of CreditCard validation services ... 
 * This Class is not instantiated - it instead provides 
 * static factory methods that create an instance of Validator 
 * @author lji
 *
 */
public class ValidationServices {
	
	// default Service name 
	public static final String DEFAULT_SERVICE = "<def-service>";
	public static Map<String, Validator> validators = null; 
	
	static {
		validators = new ConcurrentHashMap<String, Validator>();
		
		/*
		 * place a default service in Service Hash
		 */
		registerProviders(); 
		
	}


	
	public static Validator getInstance() {
		
		return getInstance(DEFAULT_SERVICE);
	}
	
	public static Validator getInstance(String name) {
		Validator validator = validators.get(name);
		
		if(validator == null ) {
			throw new IllegalArgumentException(" Validator Instance Not Found: " + name);
		}
		
		return validator;
	}
	
	/**
	 * 
	 * @param classpath -- fully qualified Class name 
	 * 
	 * @return
	 */
	public static Validator newInstance(String classpath) {
	
		Validator validator = null;
		try {
			Class theClass = Class.forName(classpath);
			validator = (Validator) theClass.newInstance();
			
			
		}
		catch(Exception ex) {
			System.err.println("Could not create Validator: " + ex);
			System.exit(1);
		}
		
		// Should this be performed as part of creation? 
		register(classpath, validator);
		
		return validator;
	}
	
	
	public static void register(String name, Validator validator) {
		validators.put(name, validator);
		return;
	}
	
	private static void registerProviders() {
		
		Validator defValidator = createDefaultValidator();
		validators.put(DEFAULT_SERVICE, defValidator);
		return;
	}
	
	/**
	 * The logic to build a "default" Validator implementation should perhaps live elsewhere ... TBD
	 * @return
	 */
	private static Validator createDefaultValidator() {
		
		Validator validator = new CommonValidator(); 
		 
		return validator;
	}
	
	
}
