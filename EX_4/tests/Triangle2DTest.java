package ex4.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ex4.geometry.Point2D;
import ex4.geometry.Triangle2D;
/**This is a test class for a triangle class.
 * In this department you can find tests for all methods
 * @author niv kotek
 */

class Triangle2DTest {// Method for testing the constructor
	public static Point2D t1 = new Point2D(5.5,10.10);
	public static Point2D t2 = new Point2D(4.4,3.3);
	public static Point2D t3 = new Point2D(4.4,3.3);
	public  Triangle2D t4 = new Triangle2D(t1,t2,t3);

	@Test// Method for testing the constructor
	void testTriangle2D() {
	Point2D p1 = new Point2D(5.5,10.10);
	Point2D p2 = new Point2D(4.4,3.3);
	Point2D p3 = new Point2D(4.4,3.3);
    Triangle2D p4 = new Triangle2D(p1,p2,p3);
   assertEquals(t4.getPoints()[0], p4.getPoints()[0]);
   assertEquals(t4.getPoints()[1], p4.getPoints()[1]);
   assertEquals(t4.getPoints()[2], p4.getPoints()[2]);
	}

	@Test
	void testContains() {//Tests the method Contains
		Point2D p1 = new Point2D(5.5,10.10);
		Point2D p2 = new Point2D(4.4,-3.3);
		Point2D p3 = new Point2D(-8,-3); 
		Point2D ans = new Point2D(5.5,10.10); 
	    Triangle2D p4 = new Triangle2D(p1,p2,p3);
		assertEquals(p4.contains(ans), true);
		 ans = new Point2D(3,2);
		assertEquals(p4.contains(ans), true);
		 ans = new Point2D(2,2);
		 assertEquals(p4.contains(ans), true);
           ans = new Point2D(-4,0);
	       assertEquals(p4.contains(ans), true);
	       ans = new Point2D(-4,0.6);
	       assertEquals(p4.contains(ans), true);
	       ans = new Point2D(-4,0.75);
	       assertEquals(p4.contains(ans), true);
	       ans = new Point2D(-4,1.2);
	       assertEquals(p4.contains(ans), false);
	        ans = new Point2D(-4,0.9);
        	assertEquals(p4.contains(ans), false);
        	 p1 = new Point2D(-5,-5);
    	     p2 = new Point2D(5,-5);
    		 p3 = new Point2D(2,12); 
    		 p4 = new Triangle2D(p1,p2,p3);
    		 ans = new Point2D(5,-5.1); 
    	     assertEquals(p4.contains(ans), false);
    	     ans = new Point2D(4,0.6); 
    	     assertEquals(p4.contains(ans), true);
    	     ans = new Point2D(4,0.7);
    	     assertEquals(p4.contains(ans),false);
    	     ans = new Point2D(3.7,2.4);
    	     assertEquals(p4.contains(ans),false);
    	     ans = new Point2D(3,6.3);
    	     assertEquals(p4.contains(ans),true);
	}
	@Test
	void testCenterOfMass() {//Tests the method Center Of Mass	
	Point2D p1 = new Point2D (5, 5);
	Point2D p2 = new Point2D(10, -3);
	Point2D p3 = new Point2D(-4, -3);
	Triangle2D t4 = new Triangle2D(p1,p2,p3);
	Point2D ans = new Point2D(3.666,-0.333);
	assertEquals(t4.centerOfMass(), ans);
		
	}

	@Test
	void testArea() {//Tests the method area	
	 Point2D p1 = new Point2D(8,4);
	 Point2D p2 = new Point2D(2,3);
	 Point2D p3 = new Point2D(6,9);
	 Triangle2D t4 = new Triangle2D(p1,p2,p3);
	  assertEquals(t4.area(), 16);
	   p1 = new Point2D(3,5);
	   p2 = new Point2D(4,5);
	   p3 = new Point2D(5,5);
	   t4 = new Triangle2D(p1,p2,p3);
	   assertEquals(t4.area(), 0);
		
	}

	@Test
	void testPerimeter() {//Tests the method Perimeter
	 Point2D p1 = new Point2D(8,4);
	 Point2D p2 = new Point2D(2,3);
	 Point2D p3 = new Point2D(6,9);
	 Triangle2D t4 = new Triangle2D(p1,p2,p3);
	 assertEquals(t4.perimeter(), p1.distance(p2)+p2.distance(p3)+p1.distance(p3));
	
	}

	@Test
	void testMove() {//Tests the method Move
		t4.move(t1);
		 Point2D p1 = new Point2D(5.5+5.5,10.10+10.10);
		 Point2D p2 = new Point2D(4.4+5.5,3.3+10.10);
		 Point2D p3 = new Point2D(4.4+5.5,3.3+10.10);
		 Triangle2D p4 = new Triangle2D(p1,p2,p3);
		assertEquals(t4.getPoints()[0], p4.getPoints()[0]);
		assertEquals(t4.getPoints()[1], p4.getPoints()[1]);
		assertEquals(t4.getPoints()[2], p4.getPoints()[2]);
	}

	@Test
	void testCopy() {//Tests the method Move copy
		 Point2D p1 = new Point2D(5.5,10.10);
		 Point2D p2 = new Point2D(4.4,3.3);
		 Point2D p3 = new Point2D(4.4,3.3);
	    Triangle2D p4 = new Triangle2D(p1,p2,p3);
	    assertEquals(t4.copy().getPoints()[0], p4.getPoints()[0]);
		assertEquals(t4.copy().getPoints()[1], p4.getPoints()[1]);
		assertEquals(t4.copy().getPoints()[2], p4.getPoints()[2]);
		
	}

	@Test
	void testGetPoints() {//Tests the method GetPoints
		 Point2D p1 = new Point2D(5.5,10.10);
		 Point2D p2 = new Point2D(4.4,3.3);
		 Point2D p3 = new Point2D(4.4,3.3);
	    Triangle2D p4 = new Triangle2D(p1,p2,p3);
	    assertEquals(t4.getPoints()[0], p4.getPoints()[0]);
		assertEquals(t4.getPoints()[1], p4.getPoints()[1]);
		assertEquals(t4.getPoints()[2], p4.getPoints()[2]);
		
		
		
	}

	@Test
	void testToString() {//Tests the method To String
		 Point2D p1 = new Point2D(5.5,10.10);
		 Point2D p2 = new Point2D(4.4,3.3);
		 Point2D p3 = new Point2D(4.4,3.3);
	    Triangle2D p4 = new Triangle2D(p1,p2,p3);
	    assertEquals(t4.toString(),p4.toString());
	    
	}

}
