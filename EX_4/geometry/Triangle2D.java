
package ex4.geometry;





/**
 * This class represents a 2D Triangle in the plane. it according to the
 * GeoShape interface In this class you can find different methods of
 * calculating area, circumference, copying, creating an array, creating a
 * string, checking the center of mass, checking whether there is a point inside
 * the triangle.
 */
public class Triangle2D implements GeoShape {
	private Point2D pointtri1;
	private Point2D pointtri2;
	private Point2D pointtri3;
	public static final double EPS1 = 2.9421709430404007E-2, EPS2 = -2.9421709430404007E-12;

	/**
	 * This is the construction method of the department by 3 points describing a
	 * triangle
	 * 
	 * @param p1=new Point2D
	 * @param p2=new Point2D
	 * @param p3=new Point2D
	 */

	public Triangle2D(Point2D p1, Point2D p2, Point2D p3) {
		this.pointtri1 = new Point2D(p1);
		this.pointtri2 = new Point2D(p2);
		this.pointtri3 = new Point2D(p3);
	}

	/**
	 * Computes if the point (ot) falls inside this (closed) shape. This method
	 * tests whether the point within the triangle by comparing the area of the
	 * large triangle with the area of the other 3 triangles
	 */

	public boolean contains(Point2D ot) {
		Triangle2D tri = new Triangle2D(this.pointtri1, this.pointtri2, this.pointtri3);
		double s = tri.area();
		Triangle2D p1 = new Triangle2D(this.pointtri1, this.pointtri2, ot);
		Triangle2D p2 = new Triangle2D(this.pointtri1, ot, this.pointtri3);
		Triangle2D p3 = new Triangle2D(ot, this.pointtri2, this.pointtri3);
		double s1 = p1.area();
		double s2 = p2.area();
		double s3 = p3.area();
		double ss = s - (s1 + s2 + s3);
		if (ss == 0) {
			return true;
		}
		return (ss >= EPS2 && ss <= (EPS1));

	}

	/**
	 * Computes the center of mass of this shape In this method we divide the by the
	 * value of x by 3 and the whole value of y by 3
	 */

	@Override
	public Point2D centerOfMass() {
		double px = (this.pointtri1.x() + this.pointtri2.x() + this.pointtri3.x()) / 3;
		double py = (this.pointtri1.y() + this.pointtri2.y() + this.pointtri3.y()) / 3;
		px = (int) (px * 1000);
		px = (double) (px / 1000);
		py = (int) (py * 1000);
		py = (double) (py / 1000);

		return new Point2D(px, py);
	}

	/**
	 * omputes the area of this shape, in case of a point This method is aided by
	 * Heron's formula https://en.wikipedia.org/wiki/Heron%27s_formula
	 * Math.sqrt(s(d-a)(d-b)(d-c)), a,b,c are the edges length
	 */
	@Override
	public double area() {
		double distanceA = this.pointtri1.distance(this.pointtri2);
		double distanceB = this.pointtri1.distance(this.pointtri3);
		double distanceC = this.pointtri2.distance(this.pointtri3);
		double peremiter = (distanceA + distanceB + distanceC) / 2;
		double ans = (peremiter) * (peremiter - distanceA) * (peremiter - distanceB) * (peremiter - distanceC);
		return Math.sqrt(ans);
	}

	/**
	 * Computes the perimeter of this shape In this method it is calculated by the
	 * sum of all 3 ribs
	 */

	@Override
	public double perimeter() {
		
		double distance1 = this.pointtri1.distance(this.pointtri2);
		double distance2 = this.pointtri1.distance(this.pointtri3);
		double distance3 = this.pointtri2.distance(this.pointtri3);
		
		
		return distance1 + distance2 + distance3;
	}

	/**
	 * In this method all the points are moved
	 */

	@Override
	public void move(Point2D vec) {
		this.pointtri1.move(vec);
		this.pointtri2.move(vec);
		this.pointtri3.move(vec);
	}

	/**
	 * In this method a copy is obtained
	 */
	@Override
	public GeoShape copy() {
		return new Triangle2D(this.pointtri1, this.pointtri2, this.pointtri3);
	}

	/**
	 * This method creates an array of every 3 points
	 */

	@Override
	public Point2D[] getPoints() {
		Point2D[] ans = new Point2D[3];
		ans[0] = new Point2D(this.pointtri1);
		ans[1] = new Point2D(this.pointtri2);
		ans[2] = new Point2D(this.pointtri3);
		return ans;

	}

	/**
	 * In this method a new string of 3 points is created
	 */

	@Override
	public String toString() {
		return this.pointtri1.toString() + ", " + this.pointtri2.toString() + ", " + this.pointtri3.toString();
	}
}