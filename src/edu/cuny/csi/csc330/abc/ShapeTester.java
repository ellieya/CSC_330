package edu.cuny.csi.csc330.abc;

import java.util.*;


public class ShapeTester {
	
	protected  int flag = 0; 
	
	protected static void drawShape(GeometricShape shape) {
		System.out.println(shape.getClass().getSimpleName());
		shape.draw();
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// List<GeometricShape> list = new ArrayList<GeometricShape>(10);
		List<GeometricShape> list = new Vector<GeometricShape>(10);
		
		
		list.add(new Circle(40) );
		list.add(new Rectangle(100, 200) );
		list.add(new Circle(80) );
		
		System.out.println("in main()");
		
		

		for(GeometricShape gs : list) {  
			ShapeTester.drawShape(gs);
		}
		
		ShapeTester st = new ShapeTester(); 
		st.flag = 1; 
		
		
	}

}
