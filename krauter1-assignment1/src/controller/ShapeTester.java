package controller;

import java.util.ArrayList;

/**
 * TCSS 305 Autumn 2022
 * Assignment 1
 * */

/**
 * This Program inherits classes to produce the name and area
 * of many different types of shapes. The created shapes are
 * stored in an arraylist and output before and after being sorted.
 * @author Caleb Krauter
 * @version October 15, 2022
 * */

 /**
  * The ShapeTester class instantiates all of the shapes,
  * calls methods in ShapeFactory to create them and adds them
  * to an arraylist. The arraylist of shapes is output before
  * and after sorting the shapes. In the ShapeTester we also
  * use getShapes to nicely print out our info.
  * */
public class ShapeTester {

/**
 * The main method holds values for the shapes,
 * instantiates the shapes and adds them to a
 * Shape type arraylist which we use to store
 * our shapes and their info before we output
 * the info. We will ouput our info before
 * and after sorting the arraylist.
 * */
	public static void main(String[] args) {

/**
 * myIndex is passed to the getShapes method
 * where it is used to get a shape at a specific index
 * and print info about the shape.
 * */
		final int myIndex = 0;


		ArrayList<shapes.Shape> myShapeArrayList = new ArrayList<shapes.Shape>();

		final double circleRadius1 = 0.1;
		final double circleRadius2 = 0.1;
		final double circleRadius3 = 9;
		final double circleRadius4 = 7;
		final double circleRadius5 = 5.5;

		final double squareLength1 = 2;
		final double squareLength2 = 2;
		final double squareLength3 = 9.5;
		final double squareLength4 = 5.6;
		final double squareLength5 = 10;

		final double rectangleLength1 = 4;
		final double rectangleLength2 = 4;
		final double rectangleLength3 = 6;
		final double rectangleLength4 = 6.7;
		final double rectangleLength5 = 10;

		final double rectangleWidth1 = 6;
		final double rectangleWidth2 = 6;
		final double rectangleWidth3 = 3;
		final double rectangleWidth4 = 8;
		final double rectangleWidth5 = 5;

		final double triangleLength1 = 5;
		final double triangleLength2 = 5;
		final double triangleLength3 = 6;
		final double triangleLength4 = 5;
		final double triangleLength5 = 8.9;

		final double triangleWidth1 = 6;
		final double triangleWidth2 = 6;
		final double triangleWidth3 = 2;
		final double triangleWidth4 = 8.9;
		final double triangleWidth5 = 7;

		
		shapes.ShapeFactory produceCircle = new shapes.ShapeFactory();
		shapes.ShapeFactory produceSquare = new shapes.ShapeFactory();
		shapes.ShapeFactory produceRectangle = new shapes.ShapeFactory();
		shapes.ShapeFactory produceTriangle = new shapes.ShapeFactory();

		myShapeArrayList.add(produceCircle.createCricle(circleRadius1));
		myShapeArrayList.add(produceCircle.createCricle(circleRadius2));
		myShapeArrayList.add(produceCircle.createCricle(circleRadius3));
		myShapeArrayList.add(produceCircle.createCricle(circleRadius4));
		myShapeArrayList.add(produceCircle.createCricle(circleRadius5));

		myShapeArrayList.add(produceSquare.createSquare(squareLength1));
		myShapeArrayList.add(produceSquare.createSquare(squareLength2));
		myShapeArrayList.add(produceSquare.createSquare(squareLength3));
		myShapeArrayList.add(produceSquare.createSquare(squareLength4));
		myShapeArrayList.add(produceSquare.createSquare(squareLength5));

		myShapeArrayList.add(produceRectangle.createRectangle(rectangleLength1, rectangleWidth1));
		myShapeArrayList.add(produceRectangle.createRectangle(rectangleLength2, rectangleWidth2));
		myShapeArrayList.add(produceRectangle.createRectangle(rectangleLength3, rectangleWidth3));
		myShapeArrayList.add(produceRectangle.createRectangle(rectangleLength4, rectangleWidth4));
		myShapeArrayList.add(produceRectangle.createRectangle(rectangleLength5, rectangleWidth5));

		myShapeArrayList.add(produceTriangle.createTriangle(triangleLength1, triangleWidth1));
		myShapeArrayList.add(produceTriangle.createTriangle(triangleLength2, triangleWidth2));
		myShapeArrayList.add(produceTriangle.createTriangle(triangleLength3, triangleWidth3));
		myShapeArrayList.add(produceTriangle.createTriangle(triangleLength4, triangleWidth4));
		myShapeArrayList.add(produceTriangle.createTriangle(triangleLength5, triangleWidth5));

		System.out.println("\nArray list of unsorted shapes.");
		getShapes(myShapeArrayList, myIndex);
		
		myShapeArrayList.sort(null); // comment where help was given
		
		System.out.println("\nArray list of sorted shapes.");
		getShapes(myShapeArrayList, myIndex);
		}	

		// Consider extra credit for using recursion to display shapes
		// in the getShapes() method.
		
/**
 * The getShapes method uses recursion to check for a
 * shape at a given index and print it out until
 * the whole arraylist is traversed through.
 * @param myShapeArrayList the arraylist that contains
 * the shapes is passed in as a parameter so it can be
 * traversed.
 * @param myIndex is passed so that a shape can be given at
 * any given index.
 * @return myShapeArrayList returns the arraylist so that the
 * return type of getShapes is satisfied in the case that the
 * whole arraylist has been traversed.
 * @return getShapes(myShapeArrayList, myIndex) so that recursion
 * can be used to traverse the arraylist and print each value at
 * each index.
 * @return myShapeArrayList returns the arraylist so that the
 * return type of getShapes is satisfied in the case that 
 * the arraylist does not contain a value at the given index.
 * This case should never be reached unless the arraylist
 * contains no values.
 * */
 		private static ArrayList<shapes.Shape> getShapes(ArrayList<shapes.Shape> myShapeArrayList, int myIndex) {
			if (myIndex == 0) {
			System.out.println();
			}

			if (myIndex % 5 == 0) {
				System.out.println();
				System.out.println("   Next type of shape: ");
				System.out.println();
			}

			if (myShapeArrayList.contains(myShapeArrayList.get(myIndex))) {
				if (myIndex == myShapeArrayList.size() - 1) {
					System.out.println("\t" + myShapeArrayList.get(myIndex));
					return myShapeArrayList;
				}
				System.out.println("\t" + myShapeArrayList.get(myIndex));
				myIndex++;
				return getShapes(myShapeArrayList, myIndex);
			}
			return myShapeArrayList;
		}
}
