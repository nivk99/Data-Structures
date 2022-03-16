package ex4.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import ex4.geometry.Point2D;

/**
 * It's a testing department that checks the point department. Tests all methods
 * 
 * @author niv kotek
 *
 */

class Point2DTest {
	public static final Point2D ORIGIN = new Point2D(0.0, 0.0);
	public static Point2D t1 = new Point2D(5.5, 10.10);
	public static Point2D t2 = new Point2D(4.4, 3.3);

	@Test // Method for testing the constructor
	void testPoint2DDoubleDouble() {
		Point2D tpoint1 = new Point2D(5.5, 10.10);
		Point2D tpoint2 = new Point2D(4.4, 3.3);
		assertEquals(t1, tpoint1);
		assertEquals(t2, tpoint2);
	}

	@Test // Method for testing the constructor
	void testPoint2DPoint2D() {
		Point2D tpoint1 = new Point2D(t1);
		Point2D tpoint2 = new Point2D(t2);
		assertEquals(tpoint1, t1);
		assertEquals(tpoint2, t2);
	}

	@Test // Method for testing the constructor
	void testPoint2DString() {
		Point2D tpoint1 = new Point2D("5.5,10.10");
		Point2D tpoint2 = new Point2D("4.4,3.3");
		Point2D tpoint3 = new Point2D("0.0,0.0");
		assertEquals(t1, tpoint1);
		assertEquals(t2, tpoint2);
		assertEquals(ORIGIN, tpoint3);

	}

	@Test // Method for checking value acceptance x
	void testX() {
		assertEquals(t1.x(), 5.5);
		assertEquals(t2.x(), 4.4);
		assertEquals(ORIGIN.x(), 0.0);

	}

	@Test // Method for checking value acceptance y
	void testY() {
		assertEquals(t1.y(), 10.10);
		assertEquals(t2.y(), 3.3);
		assertEquals(ORIGIN.y(), 0.0);
	}

	@Test // A method for checking the acceptance of a complete x value
	void testIx() {
		assertEquals(t1.ix(), 5);
		assertEquals(t2.ix(), 4);
		assertEquals(ORIGIN.ix(), 0);
	}

	@Test // A method for checking the acceptance of a complete y value
	void testIy() {
		assertEquals(t1.iy(), 10);
		assertEquals(t2.iy(), 3);
		assertEquals(ORIGIN.iy(), 0);
	}

	@Test // Tests the method of adding a point to any value x and y
	void testAdd() {
		assertEquals(t1.add(ORIGIN), t1);
		Point2D tadd = new Point2D(t1.x() + t2.x(), t1.y() + t2.y());
		assertEquals(t2.add(t1), tadd);
		assertEquals(ORIGIN.add(t2), t2);
	}

	@Test // A method that checks the value entry in a string
	void testToString() {
		assertEquals(ORIGIN.toString(), "0.0,0.0");
		assertEquals(t1.toString(), "5.5,10.1");
		assertEquals(t2.toString(), "4.4,3.3");

	}

	@Test // A method that checks the distance between a point and a center
	void testDistance() {
		assertEquals(ORIGIN.distance(), 0.0);
		assertEquals(t1.distance(), Math.sqrt(t1.x() * t1.x() + t1.y() * t1.y()));
		assertEquals(t2.distance(), Math.sqrt(t2.x() * t2.x() + t2.y() * t2.y()));
	}

	@Test // A method that checks the distance between 2 points
	void testDistancePoint2D() {
		Point2D tpoint1 = new Point2D(-2, 5);
		Point2D tpoint2 = new Point2D(3, -5);
		Point2D tpoint3 = new Point2D(-8, 6);
		Point2D tp1 = new Point2D(t1.x() - tpoint1.x(), t1.y() - tpoint1.y());
		Point2D tp2 = new Point2D(t2.x() - tpoint2.x(), t2.y() - tpoint2.y());
		Point2D tp3 = new Point2D(ORIGIN.x() - tpoint3.x(), ORIGIN.y() - tpoint3.y());
		assertEquals(t1.distance(tpoint1), Math.sqrt(tp1.x() * tp1.x() + tp1.y() * tp1.y()));
		assertEquals(t2.distance(tpoint2), Math.sqrt(tp2.x() * tp2.x() + tp2.y() * tp2.y()));
		assertEquals(ORIGIN.distance(tpoint3), Math.sqrt(tp3.x() * tp3.x() + tp3.y() * tp3.y()));
	}

	@Test // Tests the equals method between Object
	void testEqualsObject() {
		Point2D tpoint1 = new Point2D(5.5, 10.10);
		Point2D tpoint2 = new Point2D(3, -5);
		Point2D tpoint3 = new Point2D(4.4, 3.3);
		assertTrue(t1.equals(tpoint1));
		assertFalse(t1.equals(tpoint2));
		assertTrue(t2.equals(tpoint3));
		assertFalse(t2.equals(tpoint2));
		assertTrue(ORIGIN.equals(ORIGIN));
		assertFalse(ORIGIN.equals(tpoint2));
	}

	@Test // Check the method if the distance between 2 points is smaller than Epsilon
	void testClose2equalsPoint2DDouble() {
		Point2D tpoint1 = new Point2D(5.5, 10.10);
		Point2D tpoint2 = new Point2D(3, -5);
		Point2D tpoint3 = new Point2D(4.4, 3.3);
		assertTrue(t1.close2equals(tpoint1, 0.01));
		assertFalse(t1.close2equals(tpoint1, -2));
		assertTrue(t2.close2equals(tpoint3, 0.01));
		assertFalse(t2.close2equals(tpoint3, -1));
		assertTrue(tpoint3.close2equals(tpoint2, 8.8));
		assertFalse(tpoint3.close2equals(tpoint2, 2));

	}

	@Test // Tests the method if the distance between 2 points is less than a given
			// epsilon
	void testClose2equalsPoint2D() {
		Point2D tpoint1 = new Point2D(5.5, 10.10);
		Point2D tpoint2 = new Point2D(3, -5);
		Point2D tpoint3 = new Point2D(4.4, 3.3);
		assertTrue(t1.close2equals(tpoint1));
		assertFalse(t1.close2equals(tpoint2));
		assertTrue(t2.close2equals(tpoint3));
		assertFalse(t2.close2equals(tpoint2));
		assertFalse(tpoint3.close2equals(ORIGIN));

	}

	@Test // Tests the method Vector
	void testVector() {
		Point2D tpoint1 = new Point2D(5.5, 10.10);
		Point2D tpoint2 = new Point2D(3, -5);
		Point2D tpoint3 = new Point2D(4.4, 3.3);
		Point2D tp1 = new Point2D(tpoint1.x() - t1.x(), tpoint1.y() - t1.y());
		Point2D tp2 = new Point2D(tpoint2.x() - t2.x(), tpoint2.y() - t2.y());
		assertEquals(t1.vector(tpoint1), tp1);
		assertEquals(t2.vector(tpoint2), tp2);
		assertEquals(ORIGIN.vector(tpoint3), tpoint3);

	}

	@Test // Tests the method Contains
	void testContains() {
		Point2D tpoint1 = new Point2D(5.5, 5.5);
		Point2D tpoint2 = new Point2D(5.5, 5.5);
		Point2D tpoint3 = new Point2D(4.4, 3.3);
		assertTrue(tpoint1.contains(tpoint2));
		assertFalse(tpoint2.contains(tpoint3));
		tpoint1 = new Point2D(3, 2);
		tpoint2 = new Point2D(3, 2);
		assertTrue(tpoint1.contains(tpoint2));
		assertTrue(tpoint1.contains(tpoint1));
		assertFalse(t1.contains(t2));
		assertFalse(t2.contains(t1));
		assertFalse(ORIGIN.contains(t1));

	}

	@Test // Tests the method CenterOfMass
	void testCenterOfMass() {
		assertEquals(t1.centerOfMass(), t1);
		assertEquals(t2.centerOfMass(), t2);
		assertEquals(ORIGIN.centerOfMass(), ORIGIN);
	}

	@Test // Tests the method Area
	void testArea() {
		assertEquals(t1.area(), 0);
		assertEquals(t2.area(), 0);
		assertEquals(ORIGIN.area(), 0);
	}

	@Test // Tests the method Perimeter
	void testPerimeter() {// Perimeter is 0
		assertEquals(t1.area(), 0);
		assertEquals(t2.area(), 0);
		assertEquals(ORIGIN.area(), 0);

	}

	@Test // Tests the method Move between 2 points
	void testMove() {
		Point2D tpoint1 = new Point2D(7, 3);
		Point2D tpoint2 = new Point2D(6, -5);
		Point2D tpoint3 = new Point2D(4.4, 3.3);
		Point2D tp1 = new Point2D(tpoint1.x() + t1.x(), tpoint1.y() + t1.y());
		Point2D tp2 = new Point2D(tpoint2.x() + t2.x(), tpoint2.y() + t2.y());
		Point2D tp3 = new Point2D(tpoint3.x() + ORIGIN.x(), tpoint3.y() + ORIGIN.y());
		tpoint1.move(t1);
		tpoint2.move(t2);
		tpoint3.move(ORIGIN);
		assertEquals(tpoint1, tp1);
		assertEquals(tpoint2, tp2);
		assertEquals(tpoint3, tp3);

	}

	@Test // Tests the method Copy point
	void testCopy() {
		assertEquals(t1.copy(), t1);
		assertEquals(t2.copy(), t2);
		assertEquals(ORIGIN.copy(), ORIGIN);
	}

	@Test // Tests the method GetPoints
	void testGetPoints() {
		Point2D[] tpoint1 = { t1 };
		Point2D[] tpoint2 = { t2 };
		Point2D[] tpoint3 = { ORIGIN };
		assertArrayEquals(t1.getPoints(), tpoint1);
		assertArrayEquals(t2.getPoints(), tpoint2);
		assertArrayEquals(ORIGIN.getPoints(), tpoint3);

	}

}
