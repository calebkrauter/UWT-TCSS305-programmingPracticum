package shapes;

/**
 * The Shape class is used as a template for the shapes to implement area,
 * name, and use toString so that info can be easily printed out. The
 * compareTo method is used to assist with sorting the shapes
 * */
public abstract class Shape implements Comparable<Shape>{
	
/**
 * area() is an abstract method Overriden by all shapes.
 * */
	public abstract double area();

/**
 * name() is an abstract method Overriden by all shapes.
 * */
	public abstract String name();

/**
 * A toString method Overriden so that the same text can be written
 * for each shape but with differnet values for name and area.
 * @return a string with values for name and area of each shape.
 * */
	@Override
	public String toString() {
		return "The name of shape: " + name() + 
		" and the area is " + area();
	}

/**
 * The compareTo method is used to compare one shape with another shape
 * so that they can be easily sorted.
 * @param theShape a shape passed in to be compared with another
 * shape's name and area to assist in sorting the shapes.
 * @return the value given from comparing the areas of two different shapes.
 * @return the value given from comparing the names of two different shapes.
 * */
    @Override
	public int compareTo(final Shape theShape) {

		if (theShape == null) {
			throw new IllegalArgumentException("The shape is null.");
		}

		if (name().equals(theShape.name())) {
            return Double.compare(area(), theShape.area());
		}
		return name().compareTo(theShape.name());
	}

}
