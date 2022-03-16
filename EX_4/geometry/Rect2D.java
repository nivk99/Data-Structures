
package ex4.geometry;

/**
 * This class represents a 2D axis parallel rectangle. 
 * This class has different methods for calculating area, perimeter,
 *  center of a rectangle, moving 2 points, copying, string, 
 *  if a point is on a rectangle
 */
public class Rect2D implements GeoShape {
	private Point2D right;
	private Point2D left;
	
	/**This is a method that constructor the class by 2 points
	 * @param p1=new Point2D
	 * @param p2=new Point2D
	 */
	public Rect2D(Point2D p1, Point2D p2) {
			this.right = new Point2D(p1);
			this.left = new Point2D(p2);
		
	}
	
	/** 
	 * It's a method that computes if the point (ot) falls inside this (closed)
	 * shape.
	 * The method examines two point options.
	 * The method checks for both x and y values
	 * @return=true or false
	 */
	@Override
	public boolean contains(Point2D ot) {
		if(right.x()<left.x()||right.y()<left.y()) {//right=maxPoint,left=minPoint
			boolean px = ot.x() <= left.x() && ot.x() >= right.x();
			boolean py = ot.y() <= left.y() && ot.y() >= right.y();
			return px&&py;
		}
		//left=maxPoint,right=minPoint
		boolean px = ot.x() <= right.x() && ot.x() >= left.x();
		boolean py = ot.y() <= right.y() && ot.y() >= left.y();
		return px&&py;
	}
	
	
	/**
	 * Computes the center of mass of this shape.
	 *  The method calculates according to the average of the values of x and y.
	 */

	@Override
	public Point2D centerOfMass() {
		double px= (right.x()+left.x())/2;
		double py= (right.y()+left.y())/2;
		return new Point2D(px,py); 
	}
	/**
	 * Computes the area of this shape
	 * The method calculates by double the length and width
	 */

	@Override
	public double area() {
		double p1=this.right.x()-this.left.x();
		double p2=this.right.y()-this.left.y();
		double p11= Math.sqrt((p1*p1));
		double p22= Math.sqrt((p2*p2));
		return (p11*p22);
	}
	/**
	 * Computes the perimeter of this shape
	 * The method doubles the length and twice the width
	 */

	@Override
	public double perimeter() {
		double p1=this.right.x()-this.left.x();
		double p2=this.right.y()-this.left.y();
		double p11= Math.sqrt((p1*p1));
		double p22= Math.sqrt((p2*p2));
		return (2*(p11+p22));
	}
	/**
	 * This method moves the two points at the values of both x and y 
	 * according to the point reception
	 */

	@Override
	public void move(Point2D vec) {
      this.right.move(vec);
      this.left.move(vec);
	}
	
	/**
	 * This method deeply copies the two points of the rectangle.
	 */

	@Override
	public GeoShape copy() {
		 return new Rect2D(this.right, this.left);
	}
	
	/**
	 * This method returns an array of points
	 */

	@Override
	public Point2D[] getPoints() {
		Point2D[] ans = new Point2D[2];
		ans[0] = new Point2D(this.right);
		ans[1] = new Point2D(this.left);
		return ans;
		
	}
	/**
	 * This method returns a two-point string
	 */

	@Override
	public String toString() {
	  return this.right.toString() + ", " + this.left.toString();
	}

}