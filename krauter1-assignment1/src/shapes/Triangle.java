package shapes;

/**
 * The Triangle class ensures that the shape's values used for area
 * are not less than or equal to zero and returns values for the
 * name and area of the Triangle.
 * */
public final class Triangle extends Shape {

/**
 * myLength is used in the calculation of the area.
 * */
	private final double myLength;
/**
 * myWidth is used in the calculation of the area.
 * */
	private final double myWidth;

/**
 * This constructor is used to ensure that the Triangle has
 * only positive values and assigns passed values to myLength and myWidth.
 * @param theLength legnth passed in for the shape.
 * @param theWidth width passed in for the shape.
 * */
	public Triangle(double theLength, double theWidth) {
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
 * @return area of a Triangle.
 * */
	@Override
	public double area() {

		// The product of base times height divided by 2
		return ((getLength() * getWidth()) / 2);
	}

/**
 * The name method is overridden.
 * @return the name of the shape.
 * */
	@Override public String name() {
		return "Triangle";
	}

/**
 * Get length of Triangle.
 * @return length(base) of the Triangle.
 * */
	public double getLength() {
		return myLength;
	}

/**
 * Get width of Triangle.
 * @return width(height) of the Triangle.
 * */
	public double getWidth() {
		return myWidth;
	}
 
}