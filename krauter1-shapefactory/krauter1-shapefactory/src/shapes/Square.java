package shapes;

/**
 * The Square class ensures that the shape's values used for area
 * are not less than or equal to zero and returns values for the
 * name and area of the Square.
 * */
public final class Square extends Shape {

/**
 * myLength is used in the calculation of the area.
 * */
	private final double myLength;

/**
 * This constructor is used to ensure that the Square has
 * only positive values and assigns passed values to myLength.
 * @param theLength passed in for the length of the shape.
 * */
	public Square(double theLength) {
		if (theLength <= 0) {
			throw new IllegalArgumentException("The length is less " 
				+ " than or equal to zero, Value: " + theLength);

		}
		myLength = theLength;
	}

/**
 * The area is calculated.
 * @return area of a Square.
 * */
	@Override
	public double area() {
		return (getLength() * 4);
	}
	
/**
 * The name method is overridden.
 * @return the name of the shape.
 * */
	@Override public String name() {
		return "Square";
	}
	
/**
 * Get length of Square.
 * @return length of the Square.
 * */
	public double getLength() {
		return myLength;
	}	

}
	