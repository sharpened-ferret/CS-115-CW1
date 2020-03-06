/**
 * Square.java
 * @author Neil Woodhouse 851182 - (based on shape classes by Daniel Archambault and Liam O’Reilly)
 */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Square is a shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of
 * the square.
 */

public class Square extends ClosedShape {
    //The side length of the square
	private int sideLength;


    /**
     * Creates a square.
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param sideLength The side length of the square.
     * @param colour The line colour or fill colour.
     * @param isFilled True if the square is filled with colour, false if opaque.
     */
    public Square(int insertionTime, int x, int y, int vx, int vy, int sideLength, Color colour, boolean isFilled) {
    	super (insertionTime, x, y, vx, vy, colour, isFilled);
    	this.sideLength = sideLength;
    
    }
    
    /**
     * Method to convert a square to a string.
     */
    public String toString () {
    	String result = "This is a square\n";
    	result += super.toString ();
	result += "Its side length is " + this.sideLength + "\n";
    	return result;
    }
    
    /**
     * @param sideLength Resets the side length.
     */
    public void setSideLength(int sideLength) {
    	this.sideLength = sideLength;
    }
    
    /**
     * @return The side length of the square.
     */
    public int getSideLength() {
    	return sideLength;
    }

    /**
     * @return The width of the square
     */
 	public int getWidth() {
		return sideLength;
	}

 	/**
 	 * @return The height of the square
 	 */
 	public int getHeight() {
		return sideLength;
	}
    
    /**
     * Draw the square on the screen.
     * @param g The graphics object of the scene component.
     */
    public void draw (GraphicsContext g) {
    	g.setFill( colour );
    	g.setStroke( colour );
    	if (isFilled) {
    		g.fillRect(x, y, sideLength, sideLength);
    	} 
    	else {
    		g.strokeRect( x, y, sideLength, sideLength);
	    }
    }
}
