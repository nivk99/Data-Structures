package ex4.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ex4.geometry.Point2D;
import ex4.geometry.Rect2D;

/**
 * This class tests all the methods of the rectangle class.
 * Various tests can be seen
 * @author niv kotek
 */
class Rect2DTest {

	@Test// Method for testing the constructor
	void testRect2D() {
	Point2D p1 = new Point2D(4, -3);
	Point2D p2 = new Point2D(7, 4);
	Rect2D t1=new Rect2D(p1,p2);
	assertEquals(t1.toString(), p1.toString()+", "+p2.toString());
	}

	@Test// Method for testing the constructor
	void testContains() {
		Point2D p1 = new Point2D(-5, -2);
		Point2D p2 = new Point2D(14, 6);
		Rect2D t1=new Rect2D(p1,p2);
		Point2D testpoint = new Point2D(5, 2);
		assertEquals(t1.contains(testpoint), true);
		assertEquals(t1.contains(p1), true);
		assertEquals(t1.contains(p2), true);
		testpoint = new Point2D(14, 7);
		assertEquals(t1.contains(testpoint), false);
		testpoint = new Point2D(14, 6);
		p1 = new Point2D(0, 0);	
		p2 = new Point2D(0, 0);	
		t1=new Rect2D(p1,p2);
		testpoint = new Point2D(0, 0);
		assertEquals(t1.contains(testpoint),true);
		testpoint = new Point2D(1, 1);
		assertEquals(t1.contains(testpoint),false);
		p1 = new Point2D(9, 5);	
		p2 = new Point2D(-2, 0);	
		t1=new Rect2D(p1,p2);
		testpoint = new Point2D(7, 3);
		assertEquals(t1.contains(testpoint),true);
		assertEquals(t1.contains(p1),true);
		assertEquals(t1.contains(p2),true);
		testpoint = new Point2D(9, 6);
		assertEquals(t1.contains(testpoint),false);
	}

	@Test// Method for testing the CenterOfMass
	void testCenterOfMass() {
		Point2D p1 = new Point2D(-5, -2);
		Point2D p2 = new Point2D(14, 6);
		Rect2D t1=new Rect2D(p1,p2);
		Point2D testpoint = new Point2D(4.5, 2);
		assertEquals(t1.centerOfMass(),testpoint);
		
	
	}
	@Test// Method for testing the CenterOfMass
	void testArea() {
	Point2D p1 = new Point2D(-5, -2);
	Point2D p2 = new Point2D(14, 6);
	Rect2D t1=new Rect2D(p1,p2);
	assertEquals(t1.area(), 152);
	p1 = new Point2D(0, 0);	
	p2 = new Point2D(0, 0);	
	t1=new Rect2D(p1,p2);
	assertEquals(t1.area(),0);
	p1 = new Point2D(9, 5);	
	p2 = new Point2D(-2, 0);	
	t1=new Rect2D(p1,p2);
	assertEquals(t1.area(),55);
	
	}

	@Test// Method for testing the Perimeter
	void testPerimeter() {
		Point2D p1 = new Point2D(-5, -2);
		Point2D p2 = new Point2D(14, 6);
		Rect2D t1=new Rect2D(p1,p2);
		assertEquals(t1.perimeter(), 54);
		p1 = new Point2D(0, 0);	
		p2 = new Point2D(0, 0);	
		t1=new Rect2D(p1,p2);
		assertEquals(t1.perimeter(),0);
		p1 = new Point2D(9, 5);	
		p2 = new Point2D(-2, 0);	
		t1=new Rect2D(p1,p2);
		assertEquals(t1.perimeter(),32);
	}

	@Test// Method for testing the Move
	void testMove() {
		Point2D p1 = new Point2D(-5.0, -2.0);
		Point2D p2 = new Point2D(14.0, 6.0);
		Rect2D t1=new Rect2D(p1,p2);
		Point2D testMove = new Point2D(2, 4);
		Point2D testMove1 = new Point2D(-5.0+2,-2.0+4);
		t1.move(testMove);
	   assertEquals(t1.getPoints()[0],testMove1);
		
	
	}

	@Test// Method for testing the Copy
	void testCopy() {
		Point2D p1 = new Point2D(-5.0, -2.0);
		Point2D p2 = new Point2D(14.0, 6.0);
		Rect2D t1=new Rect2D(p1,p2);
	   assertEquals(t1.copy().toString(),t1.toString());
	
		
		
		
	}

	@Test// Method for testing the GetPoints
	void testGetPoints() {
	Point2D p1 = new Point2D(-5.0, -2.0);
	Point2D p2 = new Point2D(14.0, 6.0);
	Rect2D t1=new Rect2D(p1,p2);
     assertEquals(t1.getPoints()[0], p1);
     assertEquals(t1.getPoints()[1], p2);
		
	}

	@Test// Method for testing the ToString
	void testToString() {	
		Point2D p1 = new Point2D(-5.0, -2.0);
		Point2D p2 = new Point2D(14.0, 6.0);
		Rect2D t1=new Rect2D(p1,p2);
	 assertEquals(t1.toString(),p1.toString()+", " + p2.toString() );
	  p1 = new Point2D(0.0, 0.0);
		 p2 = new Point2D(0.0, 0.0);
		 t1=new Rect2D(p1,p2);
		assertEquals(t1.toString(),p1.toString()+", " + p2.toString() );
	}

}
