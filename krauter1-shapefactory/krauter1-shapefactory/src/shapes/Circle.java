package shapes;

/**
 * The Circle class ensures that the shape's values used for area
 * are not less than or equal to zero and returns values for the
 * name and area of the Circle.
 * */
public final class Circle extends Shape{
	
/**
 * myRadius is used in the calculation of the area.
 * */
	private final double myRadius; // Default for unit circle

/**
 * This constructor is used to ensure that the Circle has
 * only positive values and assigns passed values to myLength.
 * @param theRadius passed in for the radius of the Circle.
 * */
	public Circle(double theRadius) {
		if (theRadius <= 0) {
			throw new IllegalArgumentException("The radius is less " 
				+ " than or equal to zero, Value: " + theRadius);
		} 

		myRadius = theRadius;

	}

/**
 * The area is calculated.
 * @return area of a Circle.
 * */
	@Override
	public double area() {
		return Math.PI * (getRadius() * 2);
	}

/**
 * The name method is overridden.
 * @return the name of the shape.
 * */
	@Override
	public String name() {
		return "Circle";
	}

/**
 * Get radius of Circle.
 * @return myRadius of the Circle.
 * */
	public double getRadius() {
		return myRadius;
	}
	
}
