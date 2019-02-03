package edu.cuny.csi.csc330.patterns;

import java.util.*;

public class LowEvenNumberIterator implements Iterator {
	
	private int [] items; 
	private int current = 0; 

	public LowEvenNumberIterator()  {
		// TODO Auto-generated constructor stub
	}
	
	public void setItems(int [] items) {
		this.items = items; 
	}
	
	public boolean hasNext() {
		if(current < items.length )
				return true;
		return false;
	}
	
	public Object next() {
		Integer item = new Integer(items[current]);
		current++;
		return item; 
	}
	
	public void remove() {
		System.out.println("remove() not implemented - read-only list");
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
