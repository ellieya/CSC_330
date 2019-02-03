/** 
 * Simple example of an abstract class that 
 * models a "text book" Class hierarchy - geometric shapes 
 */
package edu.cuny.csi.csc330.abc;

public abstract class GeometricShape {
	
	protected int x;
	protected int y;
	
	public GeometricShape() {
		// TODO Auto-generated constructor stub
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public void  moveTo(int x, int y) {
        this.x = x;
        this.y = y; 
    }
    
    abstract public void draw();
    abstract public void resize();

}



