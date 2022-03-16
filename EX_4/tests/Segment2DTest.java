package ex4.tests;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Test;

import ex4.geometry.Point2D;
import ex4.geometry.Segment2D;
/**This is a class of tests for all methods of the Segment2DTest class.
 * All tests can be found
 */

class Segment2DTest {
	
	public static Point2D t1 = new Point2D(5.5,10.10);
	public static Point2D t2 = new Point2D(4.4,3.3);
	public  Segment2D t3 =new Segment2D(t1,t2);
	

	@Test// Method for testing the constructor
	void testSegment2D() {
	Point2D p1=new Point2D(5.5,10.10);
	Point2D p2=new Point2D(4.4,3.3);
	Segment2D m = new Segment2D(p1,p2);
	assertEquals(m.getPoints()[0], t3.getPoints()[0]);
	assertEquals(m.getPoints()[1], t3.getPoints()[1]);
	 p1=new Point2D(5.5,5.5);
	 p2=new Point2D(5.5,5.5);
	 assertEquals(m.getPoints()[0], t3.getPoints()[0]);
     assertEquals(m.getPoints()[1], t3.getPoints()[1]);
	
	}

	@Test//Tests the method Contains
	void testContains() {
		Point2D p1=new Point2D(1,1);
		Point2D p2=new Point2D(-3.8,-8.6);
		Point2D ans1=new Point2D(-1,-3);
		Point2D ans2=new Point2D(-1,-4);
		Segment2D m = new Segment2D(p1,p2);
		assertTrue(m.contains(ans1));
		assertFalse(m.contains(ans2));
		Point2D p11=new Point2D(1,1);
		Point2D p22=new Point2D(4,7);
		Point2D ans11=new Point2D(2.5,4);
		Point2D ans22=new Point2D(1,-4);
		Segment2D mm = new Segment2D(p11,p22);
		assertTrue(mm.contains(ans11));
		assertFalse(mm.contains(ans22));
	}

	@Test//Tests the method CenterOfMass
	void testCenterOfMass() {
		Point2D p1=new Point2D(1,1);
		Point2D p2=new Point2D(4,7);
		Point2D ans1=new Point2D(2.5,4);
		Point2D ans2=new Point2D(1,-4);
		Segment2D m = new Segment2D(p1,p2);
		assertEquals(m.centerOfMass(), ans1);
	     assertNotEquals(m.centerOfMass(), ans2);
	}
	@Test//Tests the method Area
	void testArea() {
	assertEquals(t3.area(), 0);
	 assertNotEquals(t3.area(), 3);
	}

	@Test//Tests the method Perimeter
	void testPerimeter() {
		Point2D p1=new Point2D(5.5,5.5);
		Point2D  p2=new Point2D(5.5,5.5);
		Segment2D m = new Segment2D(p1,p2);
		assertEquals(m.perimeter(),0.0);
		assertEquals(t3.perimeter(),2*(t1.distance(t2)));
		assertNotEquals(t3.perimeter(), (t1.distance(t2)));
	}

	@Test//Tests the method Move
	void testMove() {
		t3.move(t1);//t1     t2
		Point2D p1=new Point2D(5.5,10.10);
		Point2D p2=new Point2D(4.4,3.3);
		p1.move(t1);
		p2.move(t1);
		Segment2D m = new Segment2D(p1,p2);
		assertEquals(t3.getPoints()[0],m.getPoints()[0]);
		assertEquals(t3.getPoints()[1],m.getPoints()[1]);
	}

	@Test//Tests the method Copy
	void testCopy() {
		
		assertEquals(t3.copy().getPoints()[0],t3.getPoints()[0]);
		assertEquals(t3.copy().getPoints()[1],t3.getPoints()[1]);
	}

	@Test//Tests the method GetPoints
	void testGetPoints() {
	 Point2D t1 = new Point2D(5.5,10.10);
	 Point2D t2 = new Point2D(4.4,3.3);
	 Segment2D m = new Segment2D(t1,t2);
	assertEquals(t3.getPoints()[0],m.getPoints()[0]);
	assertEquals(t3.getPoints()[1],m.getPoints()[1]);
		
		
		
	}

	@Test//Tests the method ToString
	void testToString() {
	Point2D t1 = new Point2D(5.5,10.10);
	 Point2D t2 = new Point2D(4.4,3.3);
	 Segment2D m = new Segment2D(t1,t2);
	 assertEquals(t3.toString(), m.toString());
	
		
	
	}

}
