


/**
 * Hexagon.java
 * @author Neil Woodhouse 851182 - (based on shape classes by Daniel Archambault and Liam O’Reilly)
 */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Hexagon is a shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of
 * the Hexagon's bounding rectangle.
 */

public class Hexagon extends ClosedShape {
    //The width and height of the hexagon
	private int width, height;


    /**
     * Creates a Hexagon.
     * @param insertionTime
	 * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param width The width of the hexagon
	 * @param height The height of the hexagon
	 * @param colour The line colour or fill colour.
     * @param isFilled True if the Hexagon is filled with colour, false if opaque.
     */
    public Hexagon(int insertionTime, int x, int y, int vx, int vy, int width, int height, Color colour, boolean isFilled) {
    	super (insertionTime, x, y, vx, vy, colour, isFilled);
    	this.width = width;
    	this.height = height;
    }
    
    /**
     * Method to convert a Hexagon to a string.
     */
    public String toString () {
    	String result = "This is a Hexagon\n";
    	result += super.toString ();
		result += "Its width is " + this.width + " and its height is " + this.height + "\n";
    	return result;
    }


    /**
     * @return The width of the hexagon
     */
 	public int getWidth() {
		return width;
	}

 	/**
 	 * @return The height of the hexagon
 	 */
 	public int getHeight() {
		return height;
	}
    
    /**
     * Draw the hexagon on the screen.
     * @param g The graphics object of the scene component.
     */
    public void draw (GraphicsContext g) {
    	double[] xPoints = {x + 0.25 * width, x + 0.75 * width, x + width, x + 0.75 * width, x + 0.25 * width , x};
    	double[] yPoints = {y, y, y + 0.5 * height, y + height, y + height, y + 0.5 * height};
    	g.setFill( colour );
    	g.setStroke( colour );
    	if (isFilled) {
    		g.fillPolygon(xPoints, yPoints, 6);
    	} 
    	else {
    		g.strokePolygon( xPoints, yPoints, 6);
	    }
    }
}
