package shapes;

/**
 * The Rectangle class ensures that the shape's values used for area
 * are not less than or equal to zero and returns values for the
 * name and area of the Rectangle.
 * */
public final class Rectangle extends Shape {

/**
 * myLength is used in the calculation of the area.
 * */
	private final double myLength;

/**
 * myWidth is used in the calculation of the area.
 * */
	private final double myWidth;

/**
 * This constructor is used to ensure that the Rectangle has
 * only positive values and assigns passed values to myLength and myWidth.
 * @param theLength legnth passed in for the shape.
 * @param theWidth width passed in for the shape.
 * */
	public Rectangle(double theLength, double theWidth) {
		if (theLength <= 0 || theWidth <= 0) {
			throw new IllegalArgumentException("Length is less " 
				+ " than or equal to zero or width is less than " 
				+ "or equal to zero. Length/Base: " + theLength 
				+ " Width/Height: " + theWidth);
		}
		myLength = theLength;
		myWidth = theWidth;
	}

/**
 * The area is calculated.
 * @return area of a Rectangle.
 * */
	@Override
	public double area() {

		// Base times height
		return (getLength() * getWidth());
	}

/**
 * The name method is overridden.
 * @return the name of the shape.
 * */
	@Override public String name() {
		return "Rectangle";
	}

/**
 * Get length of Rectangle.
 * @return length(base) of the Rectangle.
 * */
	public double getLength() {
		return myLength;
	}

/**
 * Get width of Rectangle.
 * @return width(height) of the Rectangle.
 * */
	public double getWidth() {
		return myWidth;
	}

}
