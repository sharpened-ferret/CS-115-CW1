
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
					shapeQueue.enqueue(tempCircle);
					break;

				case "oval":
					Oval tempOval = readOval(currentLine);
					shapeQueue.enqueue(tempOval);
					break;

				case "square":
					Square tempSquare = readSquare(currentLine);
					shapeQueue.enqueue(tempSquare);
					break;

				case "rect":
					Rect tempRect =  readRect(currentLine);
					shapeQueue.enqueue(tempRect);
					break;

				case "hex":
					Hexagon tempHex =  readHex(currentLine);
					shapeQueue.enqueue(tempHex);
					break;

				default:
					break;
			}
		}

		shapeQueue.print();
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
		boolean isFlashing = Boolean.parseBoolean(circleData[11]);

		//Creates an RGB colour from the r, g, and b values given
		Color colour = Color.rgb(Integer.parseInt(circleData[7]),
				Integer.parseInt(circleData[8]),
				Integer.parseInt(circleData[9]));

		if (isFlashing) {
			Color secondaryColour = Color.rgb(Integer.parseInt(circleData[12]),
					Integer.parseInt(circleData[13]),
					Integer.parseInt(circleData[14]));
			Circle newCircle = new Circle(insertionTime, xPosition, yPosition,
					xVelocity, yVelocity, diameter, colour, secondaryColour, isFilled, isFlashing);
			return newCircle;
		}
		else {
			Circle newCircle = new Circle(insertionTime, xPosition, yPosition,
					xVelocity, yVelocity, diameter, colour, isFilled);
			return newCircle;
		}
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
		boolean isFlashing = Boolean.parseBoolean(ovalData[12]);

		//Creates an RGB colour from the r, g, and b values given
		Color colour = Color.rgb(Integer.parseInt(ovalData[8]),
				Integer.parseInt(ovalData[9]),
				Integer.parseInt(ovalData[10]));

		if (isFlashing) {
			Color secondaryColour = Color.rgb(Integer.parseInt(ovalData[13]),
					Integer.parseInt(ovalData[14]),
					Integer.parseInt(ovalData[15]));
			Oval newOval = new Oval(insertionTime, xPosition, yPosition,
					xVelocity, yVelocity, width, height, colour, secondaryColour, isFilled, isFlashing);
			return newOval;
		}
		else {
			Oval newOval = new Oval(insertionTime, xPosition, yPosition,
					xVelocity, yVelocity, width, height, colour, isFilled);
			return newOval;
		}
	}

	/**
	 * @param squareData a String array containing properties read from file, split at space characters
	 * @return a new square object with the specified properties
	 */
	private static Square readSquare(String[] squareData) {
		//Assigns the relevant portions of the squareData array to correctly typed variables.
		int xPosition = Integer.parseInt(squareData[1]);
		int yPosition = Integer.parseInt(squareData[2]);
		int xVelocity = Integer.parseInt(squareData[3]);
		int yVelocity = Integer.parseInt(squareData[4]);
		boolean isFilled = Boolean.parseBoolean(squareData[5]);
		int sideLength = Integer.parseInt(squareData[6]);
		int insertionTime = Integer.parseInt(squareData[10]);
		boolean isFlashing = Boolean.parseBoolean(squareData[11]);

		//Creates an RGB colour from the r, g, and b values given
		Color colour = Color.rgb(Integer.parseInt(squareData[7]),
				Integer.parseInt(squareData[8]),
				Integer.parseInt(squareData[9]));

		if (isFlashing) {
			Color secondaryColour = Color.rgb(Integer.parseInt(squareData[12]),
					Integer.parseInt(squareData[13]),
					Integer.parseInt(squareData[14]));
			Square newSquare = new Square(insertionTime, xPosition, yPosition,
					xVelocity, yVelocity, sideLength, colour, secondaryColour, isFilled, isFlashing);
			return newSquare;
		}
		else {
			Square newSquare = new Square(insertionTime, xPosition, yPosition,
					xVelocity, yVelocity, sideLength, colour, isFilled);
			return newSquare;
		}
	}

	/**
	 * @param rectData a string array containing properties read from file, split at space characters
	 * @return a new rectangle object with the specified properties
	 */
	private static Rect readRect(String[] rectData) {
		//Assigns the relevant portions of the rectData array to correctly typed variables.
		int xPosition = Integer.parseInt(rectData[1]);
		int yPosition = Integer.parseInt(rectData[2]);
		int xVelocity = Integer.parseInt(rectData[3]);
		int yVelocity = Integer.parseInt(rectData[4]);
		boolean isFilled = Boolean.parseBoolean(rectData[5]);
		int width = Integer.parseInt(rectData[6]);
		int height = Integer.parseInt(rectData[7]);
		int insertionTime = Integer.parseInt(rectData[11]);
		boolean isFlashing = Boolean.parseBoolean(rectData[12]);

		//Creates an RGB colour from the r, g, and b values given
		Color colour = Color.rgb(Integer.parseInt(rectData[8]),
				Integer.parseInt(rectData[9]),
				Integer.parseInt(rectData[10]));

		if (isFlashing) {
			Color secondaryColour = Color.rgb(Integer.parseInt(rectData[13]),
					Integer.parseInt(rectData[14]),
					Integer.parseInt(rectData[15]));
			Rect newRect = new Rect(insertionTime, xPosition, yPosition,
					xVelocity, yVelocity, width, height, colour, secondaryColour, isFilled, isFlashing);
			return  newRect;
		}
		else {
			Rect newRect = new Rect(insertionTime, xPosition, yPosition,
					xVelocity, yVelocity, width, height, colour, isFilled);
			return newRect;
		}
	}

	/**
	 * @param hexData a String array containing properties read from file, split at space characters
	 * @return a new Hexagon object with the specified properties
	 */
	private static Hexagon readHex(String[] hexData) {
		//Assigns the relevant portions of the ovalData array to correctly typed variables.
		int xPosition = Integer.parseInt(hexData[1]);
		int yPosition = Integer.parseInt(hexData[2]);
		int xVelocity = Integer.parseInt(hexData[3]);
		int yVelocity = Integer.parseInt(hexData[4]);
		boolean isFilled = Boolean.parseBoolean(hexData[5]);
		int width = Integer.parseInt(hexData[6]);
		int height = Integer.parseInt(hexData[7]);
		int insertionTime = Integer.parseInt(hexData[11]);
		boolean isFlashing = Boolean.parseBoolean(hexData[12]);

		//Creates an RGB colour from the r, g, and b values given
		Color colour = Color.rgb(Integer.parseInt(hexData[8]),
				Integer.parseInt(hexData[9]),
				Integer.parseInt(hexData[10]));

		if (isFlashing) {
			Color secondaryColour = Color.rgb(Integer.parseInt(hexData[13]),
					Integer.parseInt(hexData[14]),
					Integer.parseInt(hexData[15]));
			Hexagon newHex = new Hexagon(insertionTime, xPosition, yPosition,
					xVelocity, yVelocity, width, height, colour, secondaryColour, isFilled, isFlashing);
			return newHex;
		}
		else {
			Hexagon newHex = new Hexagon(insertionTime, xPosition, yPosition,
					xVelocity, yVelocity, width, height, colour, isFilled);
			return newHex;
		}
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
