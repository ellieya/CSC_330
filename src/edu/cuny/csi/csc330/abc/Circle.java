package edu.cuny.csi.csc330.abc;

public class Circle extends GeometricShape {
	
	protected int radius;  

	public Circle() {
		super(); 
	}
	
	public Circle(int radius) {
		this.radius = radius;
	}

	
	@Override
	public void draw() {
		System.out.printf(" Drawing based on radius=%d\n", radius);

	}

	
	@Override
	public void resize() {
		// resize the circle 
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + ", x=" + x + ", y=" + y + "]";
	}



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
