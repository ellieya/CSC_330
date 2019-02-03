package edu.cuny.csi.csc330.patterns;

import java.util.*;

public class LowEvenNumberCollection implements Iterable {
	
	private int [] numbers = {2,4,6,8,10,12,14,16,18,20};

	public LowEvenNumberCollection() {
		// TODO Auto-generated constructor stub
	}
	
	public Iterator iterator() {
		LowEvenNumberIterator it = new LowEvenNumberIterator(); 
		it.setItems(numbers);
	
		
		return it ;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LowEvenNumberCollection collection = new LowEvenNumberCollection();
		
		Iterator it = collection.iterator();
		while(it.hasNext()) {
			Integer i = (Integer) it.next();
			System.out.println(i);
		}

	}

}
