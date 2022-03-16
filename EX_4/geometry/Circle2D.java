package ex4.geometry;

/**
 * This class represents a 2D circle in the plane. it according to the GeoShape
 * interface. Ex4 In this class you can find different methods for calculating
 * area, perimeter, center of a circle, copy, move point, string and array of
 * the class.
 */
public class Circle2D  implements GeoShape {
	private Point2D _center;// A Point on the circle
	private double _radius;// The radius of the circle

	/**
	 * This is the construction method of the department. Gets radius and point. If
	 * gets a negative radius it prints an error.
	 * 
	 * @param cen=A   Point2D on the circle
	 * @param rad=The radius of the circle
	 */

	public Circle2D(Point2D cen, double rad)throws RuntimeException {
		this._center = new Point2D(cen);
		if (rad < 0) {// if negative radius!!!
			System.err.println(
					"Err got a negative radius for circle init !!!" + " " +  new RuntimeException() + " " + "!!!");
			this._radius = 1.0;
		} else {
			this._radius = rad;
		}
	
	}

	/**
	 * It is a method that sends the radius value
	 * 
	 * @return The radius of the circle
	 */

	public double getRadius() {
		return this._radius;
	}

	/**
	 * It's a method that prints through toString
	 */

	@Override
	public String toString() {
		return _center.toString() + ", " + _radius;
	}

	/**
	 * It's a method that computes if the point (ot) falls inside this (closed)
	 * shape. Finds by the distance of the point and the length of the radius
	 */
	@Override
	public boolean contains(Point2D ot) {
		double dist = ot.distance(this._center);
		return dist <= this._radius;
	}

	/**
	 * Computes the center of mass of this shape Returns the point on the circle
	 */

	@Override
	public Point2D centerOfMass() {
		return new Point2D(this._center);
	}

	/**
	 * Computes the area of this shape According to a formula for calculating a
	 * circle area
	 */

	@Override
	public double area() {
		double ans = Math.PI * Math.pow(this._radius, 2);
		return ans;
	}

	/**
	 * Computes the perimeter of this shape According to a formula for calculating a
	 * circle perimeter
	 */
	@Override
	public double perimeter() {
		double ans = Math.PI * 2 * this._radius;
		return ans;
	}

	/**
	 * This method moves the point according to the x and y values of the second
	 * point
	 * 
	 */

	@Override
	public void move(Point2D vec) {
		_center.move(vec);
	}

	/**
	 * This method copies the objects of the class
	 */

	@Override
	public GeoShape copy() {
		return new Circle2D(_center, _radius);
	}

	/**
	 * This method puts the objects of a class within an array
	 */

	@Override
	public Point2D[] getPoints() {
		Point2D[] ans = new Point2D[2];
		ans[0] = new Point2D(this._center);
		ans[1] = new Point2D(ans[0].x(), ans[0].y() + this._radius);
		return ans;
	}

}