package ex4.geometry;



/**
 * This class represents a 2D segment on the plane, it according to the GeoShape
 * interface. In this class you can find different methods for checking area,
 * perimeter, center of a segment, if a point within a segment, move the point,
 * array, string.
 */
public class Segment2D implements GeoShape {
	private Point2D point1;// point p1
	private Point2D point2;// point p2

	/**
	 * In this method she constructio the class by 2 points
	 * 
	 * @param p1=new Point2D
	 * @param p2=new Point2D
	 */
	public Segment2D(Point2D p1, Point2D p2) {
		this.point1 = new Point2D(p1);
		this.point2 = new Point2D(p2);
	}

	/**
	 * Computes the center of mass of this shape In this method If the distance
	 * between the 2 complex points is equal to the distance between point 1 and
	 * general point with point 2 and general point point 1 and general point with
	 * point 2 and general point
	 */
	@Override
	public boolean contains(Point2D ot) {
		double p1p2 = this.point1.distance(this.point2);
		double p12 = this.point1.distance(ot) + this.point2.distance(ot);
		return p1p2 == p12;
	}

	/**
	 * Computes the center of mass of this shape. In this method the center of mass
	 * is calculated between 2 points by a partial distance of 2
	 */

	@Override
	public Point2D centerOfMass() {
		double px = (this.point1.x() + this.point2.x()) / 2;
		double py = (this.point1.y() + this.point2.y()) / 2;
		return new Point2D(px, py);
	}

	/**
	 * computes the area of this shape Returns 0 because there is no space for the
	 * segment
	 */
	@Override
	public double area() {
		return 0;
	}

	/**
	 * Computes the perimeter of this shape In this method the section length is
	 * returned twice
	 */

	@Override
	public double perimeter() {

		return 2 * (this.point1.distance(this.point2));
	}

	/**
	 * Move this shape by the vector. In this method the 2 points are moved by point
	 */

	@Override
	public void move(Point2D vec) {
		this.point1.move(vec);
		this.point2.move(vec);
	}
	/**
	 * In this method the section is copied
	 */

	@Override
	public GeoShape copy() {
		return new Segment2D(this.point1, this.point2);
	}
	
	/**
	 * This method can create an array of 2 points
	 */

	@Override
	public Point2D[] getPoints() {

		Point2D[] ans = new Point2D[2];
		ans[0] = new Point2D(this.point1);
		ans[1] = new Point2D(this.point2);
		return ans;

	}
	
	/**
	 * With this method you can create a string
	 */

	@Override
	public String toString() {

		return point1.toString() + ", " + point2.toString();
	}
}