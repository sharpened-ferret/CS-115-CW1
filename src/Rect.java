/**
 * Rect.java
 * @author Neil Woodhouse 851182 - (based on shape classes by Daniel Archambault and Liam O’Reilly)
 */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Rect is a shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of
 * the Rectangle.
 */

public class Rect extends ClosedShape {
    //The width and height of the rectangle
	private int width, height;

    /**
     * Creates a rectangle.
     * @param insertionTime the time delay before the object is rendered
	 * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param width The width of the rectangle.
	 * @param height The height of the rectangle.
     * @param colour The line colour or fill colour.
     * @param isFilled True if the rectangle is filled with colour, false if opaque.
     */
    public Rect(int insertionTime, int x, int y, int vx, int vy, int width, int height,  Color colour, boolean isFilled) {
    	super (insertionTime, x, y, vx, vy, colour, isFilled);
    	this.width = width;
    	this.height = height;
    }

	/**
	 * Creates a rectangle that can flash between two colours every two seconds.
	 * @param insertionTime the time delay before the object is rendered
	 * @param x The display component's x position.
	 * @param y The display component's y position.
	 * @param vx The display component's x velocity.
	 * @param vy The display component's y velocity.
	 * @param width The width of the rectangle.
	 * @param height The height of the rectangle.
	 * @param colour The line colour or fill colour.
	 * @param secondaryColour The alternate line colour or fill colour
	 * @param isFilled True if the rectangle is filled with colour, false if opaque.
	 * @param isFlashing True if the object flashes between primary and secondary colours
	 */
	public Rect(int insertionTime, int x, int y, int vx, int vy, int width, int height,  Color colour, Color secondaryColour, boolean isFilled, boolean isFlashing) {
		super (insertionTime, x, y, vx, vy, colour, secondaryColour, isFilled, isFlashing);
		this.width = width;
		this.height = height;
	}
    
    /**
     * Method to convert a rectangle to a string.
     */
    public String toString () {
    	String result = "This is a rectangle\n";
    	result += super.toString ();
		result += "Its width is " + this.width + " and its height is " + this.height + "\n";
    	return result;
    }
    
    /**
     * @param width resets the width.
     */
    public void setWidth(int width) {
    	this.width = width;
    }
    

    public void setHeight(int height) {
    	this.height = height;
    }

    /**
     * @return The width of the rectangle
     */
 	public int getWidth() {
		return width;
	}

 	/**
 	 * @return The height of the rectangle
 	 */
 	public int getHeight() {
		return height;
	}
    
    /**
     * Draw the rectangle on the screen.
     * @param g The graphics object of the scene component.
     */
    public void draw (GraphicsContext g) {
    	g.setFill( colour );
    	g.setStroke( colour );
    	if (isFilled) {
    		g.fillRect(x, y, width, height);
    	} 
    	else {
    		g.strokeRect( x, y, width, height);
	    }
    }
}
