package edu.cuny.csi.csc330.patterns;

import java.util.*;

public class ListCollectionFactory extends BaseFactory {
	
	private static int DEFAULT_LIST_SIZE = 500; 
	private static int ENTERPRISE_LIST_SIZE = DEFAULT_LIST_SIZE * 100; 

	private ListCollectionFactory() {
		 
	}
	
	public static List createList() {
		return createList(env); 
	}
	
	public static List createList(String hint) {
		
		List list; 
		
		if("j2ee".equalsIgnoreCase(hint)) {
			list = new Vector(ENTERPRISE_LIST_SIZE);
		}
		else {
			list = new ArrayList(DEFAULT_LIST_SIZE);
		}
		
		return list; 
	}

}
