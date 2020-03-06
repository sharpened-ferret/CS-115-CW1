
/**
 * This class reads a shape file.  For the format of this shape file, see the assignment description.
 * Also, please see the shape files ExampleShapes.txt, ExampleShapesStill.txt, and TwoRedCircles.txt
 *
 * @author Neil Woodhouse 851182
 *
 */

import javafx.scene.paint.Color;
import java.io.*;
import java.util.Scanner;

public class ReadShapeFile {

	// TODO: You will likely need to write four methods here. One method to
	// construct each shape
	// given the Scanner passed as a parameter. I would suggest static
	// methods in this case.

	/**
	 * Reads the data file used by the program and returns the constructed queue
	 * 
	 * @param in the scanner of the file
	 * @return the queue represented by the data file
	 */
	private static Queue<ClosedShape> readDataFile(Scanner in) {
		Queue<ClosedShape> shapeQueue = new Queue<ClosedShape>();

		//read in the shape files and place them on the Queue
		while (in.hasNextLine()) {
			String shape;
			String[] currentLine = in.nextLine().split(" ");
			shape = currentLine[0];

			switch (shape) {
				case "circle":
					Circle tempCircle = readCircle(currentLine);
					System.out.println(tempCircle);
					break;

				case "oval":
					Oval tempOval = readOval(currentLine);
					System.out.println(tempOval);
					break;

				case "square":
					Square tempSquare = readSquare(currentLine);
					System.out.println(tempSquare);
					break;

				case "rect":
					Rect tempRect =  readRect(currentLine);
					System.out.println(tempRect);
					break;

				default:
					break;
			}
//			System.out.println(shape + " "+ currentLine);
		}

		//Right now, returning an empty Queue.  You need to change this.
		return shapeQueue;
	}


	/**
	 * @param circleData a String array containing properties read from file, split at space characters
	 * @return a new circle object with the specified properties
	 */
	private static Circle readCircle(String[] circleData) {
		//Assigns the relevant portions of the circleData array to correctly typed variables.
		int xPosition = Integer.parseInt(circleData[1]);
		int yPosition = Integer.parseInt(circleData[2]);
		int xVelocity = Integer.parseInt(circleData[3]);
		int yVelocity = Integer.parseInt(circleData[4]);
		boolean isFilled = Boolean.parseBoolean(circleData[5]);
		int diameter = Integer.parseInt(circleData[6]);
		int insertionTime = Integer.parseInt(circleData[10]);

		//Creates an RGB colour from the r, g, and b values given
		Color colour = Color.rgb(Integer.parseInt(circleData[7]),
				Integer.parseInt(circleData[8]),
				Integer.parseInt(circleData[9]));

		Circle newCircle = new Circle(insertionTime, xPosition, yPosition,
				xVelocity, yVelocity, diameter, colour, isFilled);

		return newCircle;
	}

	/**
	 * @param ovalData a String array containing properties read from file, split at space characters
	 * @return a new circle object with the specified properties
	 */
	private static Oval readOval(String[] ovalData) {
		//Assigns the relevant portions of the ovalData array to correctly typed variables.
		int xPosition = Integer.parseInt(ovalData[1]);
		int yPosition = Integer.parseInt(ovalData[2]);
		int xVelocity = Integer.parseInt(ovalData[3]);
		int yVelocity = Integer.parseInt(ovalData[4]);
		boolean isFilled = Boolean.parseBoolean(ovalData[5]);
		int width = Integer.parseInt(ovalData[6]);
		int height = Integer.parseInt(ovalData[7]);
		int insertionTime = Integer.parseInt(ovalData[11]);

		//Creates an RGB colour from the r, g, and b values given
		Color colour = Color.rgb(Integer.parseInt(ovalData[8]),
				Integer.parseInt(ovalData[9]),
				Integer.parseInt(ovalData[10]));

		Oval newOval = new Oval(insertionTime, xPosition, yPosition,
				xVelocity, yVelocity, width, height, colour, isFilled);

		return newOval;
	}

	private static Square readSquare(String[] squareData) {
		//Assigns the relevant portions of the circleData array to correctly typed variables.
		int xPosition = Integer.parseInt(squareData[1]);
		int yPosition = Integer.parseInt(squareData[2]);
		int xVelocity = Integer.parseInt(squareData[3]);
		int yVelocity = Integer.parseInt(squareData[4]);
		boolean isFilled = Boolean.parseBoolean(squareData[5]);
		int sideLength = Integer.parseInt(squareData[6]);
		int insertionTime = Integer.parseInt(squareData[10]);

		//Creates an RGB colour from the r, g, and b values given
		Color colour = Color.rgb(Integer.parseInt(squareData[7]),
				Integer.parseInt(squareData[8]),
				Integer.parseInt(squareData[9]));

		Square newSquare = new Square(insertionTime, xPosition, yPosition,
				xVelocity, yVelocity, sideLength, colour, isFilled);

		return newSquare;
	}

	private static Rect readRect(String[] rectData) {
		//Assigns the relevant portions of the ovalData array to correctly typed variables.
		int xPosition = Integer.parseInt(rectData[1]);
		int yPosition = Integer.parseInt(rectData[2]);
		int xVelocity = Integer.parseInt(rectData[3]);
		int yVelocity = Integer.parseInt(rectData[4]);
		boolean isFilled = Boolean.parseBoolean(rectData[5]);
		int width = Integer.parseInt(rectData[6]);
		int height = Integer.parseInt(rectData[7]);
		int insertionTime = Integer.parseInt(rectData[11]);

		//Creates an RGB colour from the r, g, and b values given
		Color colour = Color.rgb(Integer.parseInt(rectData[8]),
				Integer.parseInt(rectData[9]),
				Integer.parseInt(rectData[10]));

		Rect newRect = new Rect(insertionTime, xPosition, yPosition,
				xVelocity, yVelocity, width, height, colour, isFilled);

		return newRect;
	}

	/**
	 * Method to read the file and return a queue of shapes from this file. The
	 * program should handle the file not found exception here and shut down the
	 * program gracefully.
	 * 
	 * @param filename the name of the file
	 * @return the queue of shapes from the file
	 */
	public static Queue<ClosedShape> readDataFile(String filename){
		Scanner in = null;
		try {
			File input = new File(filename);
			in = new Scanner(input);
		} catch (FileNotFoundException e) {
			System.out.println("Error: The Specified File could not be Found. The program will now terminate.");
			System.exit(0);
		}
		return ReadShapeFile.readDataFile(in);
	}

}
