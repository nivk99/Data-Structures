package ex4.geometry;

/**
 * This class represents a 2D point in the plane. This class is literally the
 * GeoShape interface. In this class you can find functions for finding
 * distance, adding a point, equals, area, scope, move, receiving points.
 */

public class Point2D implements GeoShape {
	public static final double EPS1 = 0.001, EPS2 = Math.pow(EPS1, 2), EPS = EPS2;
	public static final Point2D ORIGIN = new Point2D(0, 0);
	private double _x, _y;

	/**
	 * This is the class constructor. Gets two double types
	 * 
	 * @param x=The x-axis value of the axes
	 * @param y=The y-axis value of the axes
	 */

	public Point2D(double x, double y) {
		this._x = x;
		this._y = y;
	}

	/**
	 * This is a constructor that gets a point and initializes them by x and y
	 * 
	 * @param p=A point I get and initialize it in the class
	 */

	public Point2D(Point2D p) {
		this(p.x(), p.y());
	}

	/**
	 * This is a constructor that gets a string of a dot. Checks if this is a real
	 * point. If not the system crashes
	 * 
	 * @param s=Gets an array of point strings
	 */

	public Point2D(String s) {
		try {
			String[] a = s.split(",");
			_x = Double.parseDouble(a[0]);
			_y = Double.parseDouble(a[1]);
		} catch (IllegalArgumentException e) {// If not a point
			System.err
					.println("ERR: got wrong format string for Point2D init, got:" + s + "  should be of format: x,y");
			throw (e);
		}
	}

	/**
	 * Returns the point value x
	 * 
	 * @return get x
	 */

	public double x() {
		return _x;
	}

	/**
	 * Returns the point value x
	 * 
	 * @return get y
	 */

	public double y() {
		return _y;
	}

	/**
	 * Returns the complete x value
	 * 
	 * @return get int x
	 */

	public int ix() {
		return (int) _x;
	}

	/**
	 * Returns the complete y value
	 * 
	 * @return get int y
	 */
	public int iy() {
		return (int) _y;
	}

	/**
	 * It is a function that adds a point to each value of x and y
	 * 
	 * @param p=Gets a point to add
	 * @return A point with the new value
	 */

	public Point2D add(Point2D p) {// add point
		Point2D a = new Point2D(p.x() + x(), p.y() + y());
		return a;
	}

	/**
	 * This is a function that returns a string of a point
	 * 
	 * @return A string of point x and y
	 */

	@Override
	public String toString() {
		return _x + "," + _y;
	}

	/**
	 * This is a function that calculates the distance between a point and the
	 * beginning of the axes
	 * 
	 * @return Distance between a point and the origin
	 */

	public double distance() {
		return this.distance(ORIGIN);
	}

	/**
	 * is a function that calculates a distance between 2 points
	 * 
	 * @param p2=Gets a point
	 * @return Distance between 2 points
	 */

	public double distance(Point2D p2) {
		double dx = this.x() - p2.x();
		double dy = this.y() - p2.y();
		double t = (dx * dx + dy * dy);
		return Math.sqrt(t);
	}

	/**
	 * A function that checks if it is a point from the class If it's a point he
	 * gets it in the class
	 * 
	 * @return true or false
	 */

	public boolean equals(Object p) {
		if (p == null || !(p instanceof Point2D)) {// If not a Point or null
			return false;
		}
		Point2D p2 = (Point2D) p;
		return ((_x == p2._x) && (_y == p2._y));
	}

	/**
	 * A function that checks if the distance between 2 points is smaller than
	 * Epsilon
	 * 
	 * @param p2=Distance calculation point
	 * @param eps=        Epislon value
	 * @return true or false
	 */
	public boolean close2equals(Point2D p2, double eps) {
		return (this.distance(p2) < eps);
	}

	/**
	 * A function that checks if the distance between 2 points is smaller than the
	 * epsilon I set
	 * 
	 * @param p2=Distance calculation point
	 * @return true or false
	 */

	public boolean close2equals(Point2D p2) {
		return close2equals(p2, EPS);
	}

	/**
	 * This method returns the vector between this point and the target point. The
	 * vector is represented as a Point2D.
	 * 
	 * @param target=point2D
	 * @return Destination point
	 */
	public Point2D vector(Point2D target) {
		double dx = target.x() - this.x();
		double dy = target.y() - this.y();
		return new Point2D(dx, dy);
	}

	/**
	 * Computes if the point (ot) falls inside this (closed) shape. A method that
	 * checks if a Point2D contains the same Point2D
	 * 
	 * @return true or false
	 */

	public boolean contains(Point2D ot) {
		return this.equals(ot);
	}

	/**
	 * Computes the center of mass of this shape
	 * 
	 * @return a new copy of the same Point
	 */

	@Override
	public Point2D centerOfMass() {
		return new Point2D(this);
	}

	/**
	 * Computes the area of this shape
	 * 
	 * @return 0 because it is a point
	 * 
	 */

	@Override
	public double area() {
		return 0;
	}

	/**
	 * Computes the perimeter of this shape
	 * 
	 * @return 0 because it is a point
	 * 
	 */

	@Override
	public double perimeter() {
		return 0;
	}

	/**
	 * Move this shape by the vector vec this method changes the inner state of the
	 * Object.
	 * 
	 */

	@Override
	public void move(Point2D vec) {
		this._x += vec.x();
		this._y += vec.y();
	}

	/**
	 * This method computes a new (deep) copy of this Point2D
	 * 
	 * @return New copy of Point2D
	 */

	@Override
	public GeoShape copy() {
		return new Point2D(this);
	}

	/**
	 * Returns an array of points In first place will be the Point2D
	 */

	@Override
	public Point2D[] getPoints() {
		Point2D[] ans = new Point2D[1];
		ans[0] = new Point2D(this);
		return ans;
	}
}