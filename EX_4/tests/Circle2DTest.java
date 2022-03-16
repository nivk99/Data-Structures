package ex4.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ex4.geometry.Circle2D;
import ex4.geometry.Point2D;
/**This class is a test for all the methods of the circuit class.
 * She checks all the conditions
 * @author niv kotek
 *
 */

class Circle2DTest {
	public static final Point2D ORIGIN = new Point2D(0.0, 0.0);
	public static Point2D t = new Point2D(5.5, 10.1);
	public static Circle2D t1 = new Circle2D(t, 10.1);
	public static Circle2D t2 = new Circle2D(ORIGIN, 5.5);
	public static final double RAD = 5.4;

	@Test// Method for testing the constructor
	void testCircle2D() {
		Circle2D circle1 = new Circle2D(t, 10.1);
		Circle2D circle2 = new Circle2D(ORIGIN, 5.5);
		assertEquals(circle1.getRadius(), t1.getRadius());
		assertEquals(circle2.getRadius(), t2.getRadius());
		assertEquals(circle1.toString(), t1.toString());
		assertEquals(circle2.toString(), t2.toString());
	}

	@Test//Checks the radius reception
	void testGetRadius() {
		assertEquals(t1.getRadius(), 10.1);
		assertEquals(t2.getRadius(), 5.5);
		assertNotNull(t1.getRadius());
		assertNotNull(t2.getRadius());
	}

	@Test//Tests the method ToString
	void testToString() {
		Circle2D circle1 = new Circle2D(t, 10.1);
		Circle2D circle2 = new Circle2D(ORIGIN, 5.5);
		Circle2D circle3 = new Circle2D(ORIGIN, RAD);
		Circle2D circle4 = new Circle2D(ORIGIN, 5.4);
		assertEquals(t1.toString(), circle1.toString());
		assertEquals(t2.toString(), circle2.toString());
		assertEquals(circle3.toString(), circle4.toString());
	}

	@Test//Tests the method Contains
	void testContains() {
		Point2D p1 = new Point2D(6.8, 3.8);
		Point2D p2 = new Point2D(15, 7.3);
		Circle2D circle1 = new Circle2D(p1, 4.7);
		Circle2D circle2 = new Circle2D(p2, 12);
		Point2D testcon1 = new Point2D(5, 7);
		Point2D testcon2 = new Point2D(4, 3);
		assertTrue(circle1.contains(testcon1));
		assertTrue(circle2.contains(testcon2));
		assertTrue(t1.contains(t));
		assertTrue(t2.contains(ORIGIN));
		assertFalse(circle1.contains(p2));

	}

	@Test//Tests the method Center Of Mass
	void testCenterOfMass() {
		Point2D p1 = new Point2D(4, 5);
		Point2D p2 = new Point2D(15, 7.3);
		Circle2D circle1 = new Circle2D(p1, 4.7);
		Circle2D circle2 = new Circle2D(p2, 12);
		assertEquals(t1.centerOfMass(), t);
		assertEquals(t2.centerOfMass(), ORIGIN);
		assertEquals(circle1.centerOfMass(), p1);
		assertEquals(circle2.centerOfMass(), p2);
	}

	@Test//Tests the method Area
	void testArea() {
		Point2D p1 = new Point2D(3, -5);
		Point2D p2 = new Point2D(3, 3);
		Circle2D circle1 = new Circle2D(p1, 6.7);
		Circle2D circle2 = new Circle2D(p2, 2);

		assertEquals(t1.area(), Math.PI * Math.pow(t1.getRadius(), 2));
		assertEquals(t2.area(), Math.PI * Math.pow(t2.getRadius(), 2));
		assertEquals(circle1.area(), Math.PI * Math.pow(circle1.getRadius(), 2));
		assertEquals(circle2.area(), Math.PI * Math.pow(circle2.getRadius(), 2));
	}

	@Test//Tests the method Perimeter
	void testPerimeter() {
		Point2D p1 = new Point2D(3, -5);
		Point2D p2 = new Point2D(3, 3);
		Circle2D circle1 = new Circle2D(p1, 6.7);
		Circle2D circle2 = new Circle2D(p2, 2);

		assertEquals(t1.perimeter(), Math.PI * 2 * t1.getRadius());
		assertEquals(t2.perimeter(), Math.PI * 2 * t2.getRadius());
		assertEquals(circle1.perimeter(), Math.PI * 2 * circle1.getRadius());
		assertEquals(circle2.perimeter(), Math.PI * 2 * circle2.getRadius());

	}

	@Test//Tests the method Move
	void testMove() {
		Point2D p1 = new Point2D(3, -5);
		Point2D p2 = new Point2D(3, 3);
		Circle2D circle1 = new Circle2D(p1, 6.7);
		Circle2D circle2 = new Circle2D(p2, 2);
		circle1.move(ORIGIN);
		circle2.move(ORIGIN);
		assertEquals(circle1,circle1);
		assertEquals(circle2,circle2);
		assertEquals(circle2,circle2);
			
		

	}


	@Test//Tests the method Copy
	void testCopy() {
	Circle2D circle1 = new Circle2D(t,t1.getRadius());	
		assertEquals (t1.copy(),t1);
	
	}

	@Test//Tests the method GetPoints
	void testGetPoints() {
		Point2D[] tpoint1 =new Point2D[2];
		tpoint1[0]=t;
		tpoint1[1]=new Point2D( t.x(),t.y()+t1.getRadius());	
		Point2D[] tpoint2 =new Point2D[2];
		tpoint2[0]=ORIGIN;
		tpoint2[1]=new Point2D( ORIGIN.x(),t2.getRadius());
		assertArrayEquals(t1.getPoints(), tpoint1);
		assertArrayEquals(t2.getPoints(), tpoint2);
	}

}
