package edu.cuny.csi.csc330.abc;

public class Rectangle extends GeometricShape {
	
	
	protected int width;
	protected int height;

	public Rectangle() {
		// TODO Auto-generated constructor stub
	}
	
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public void draw() {
		// 
		System.out.printf(" Drawing based on width=%d & height=%d\n", width, height);

	}

	@Override
	public void resize() {
		// resize 

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
