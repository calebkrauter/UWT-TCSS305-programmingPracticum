package shapes;

/**
 * The ShapeFactory instantiates all shape classes and returns
 * the newly created shape.
 * */
public class ShapeFactory {

/**
 * createCircle instantiates the Circle class so that the Circle can
 * be created.
 * @param theCircleRadius is passed so that a given circle's area
 * can be calculated.
 * @return produceCircle1 is returned so that the Circle can be
 * added to the arraylist.
 * */
	public static Shape createCricle(final double theCircleRadius) {
		Circle produceCircle1 = new Circle(theCircleRadius);
		return produceCircle1;
	}

/**
 * createSquare instantiates the Square class so that the Square can
 * be created.
 * @param theSquareLength is passed so that a given circle's area
 * can be calculated.
 * @return produceSquare1 is returned so that the Square can be
 * added to the arraylist.
 * */
	public static Shape createSquare(final double theSquareLength) {
		Square produceSquare1 = new Square(theSquareLength);
		return produceSquare1;
	}	

/**
 * createRectangle instantiates the Rectangle class so that the Rectangle
 * can be created.
 * @param theRectangleLength is passed so that a given Rrectangle's area
 * can be calculated.
 * @param theRectangleWidth is passed so that a given Rectangle's area
 * can be calculated.
 * @return produceRectangle1 is returned so that the Rectangle can be
 * added to the arraylist.
 * */
	public static Shape createRectangle(final double theRectangleLength, final double theRectangleWidth) {
		Rectangle produceRectangle1 = new Rectangle(theRectangleLength, theRectangleWidth);
		return produceRectangle1;
	}

/**
 * createTriangle instantiates the Triangle class so that the Triangle
 * can be created.
 * @param theTriangleLength is passed so that a given Triangle's area
 * can be calculated.
 * @param theTriangleWidth is passed so that a given Triangle's area
 * can be calculated.
 * @return produceTriangle1 is returned so that the Triangle can be
 * added to the arraylist.
 * */
	public static Shape createTriangle(final double theTriangleLength, final double theTriangleWidth) {
		Triangle produceTriangle1 = new Triangle(theTriangleLength, theTriangleWidth);
		return produceTriangle1;
	}

}
