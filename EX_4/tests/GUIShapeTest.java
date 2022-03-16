package ex4.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import ex4.GUIShape;
import ex4.geometry.*;
import junit.framework.Assert;
/**
 * This is a test class for GUIShape.
 * The class tests all methods
 * @author niv kotek
 * This is a test class for GUIShape.
 * The department tests all methods
 * 1. constructor
 * 2.Color
 * 3. Full or empty
 * 4. Shape type
 * 5. Copy
 * 6. String
 */
class GUIShapeTest {

	@Test// Method for testing the constructor
	void testGUIShape() {
		GUIShape test1=new GUIShape();
		GUIShape test2=new GUIShape();
		assertEquals(test1.toString(),test2.toString());
		
	}

	@Test// Method for testing the constructor
	void testGUIShapeGeoShapeBooleanColorInt() {
		GUIShape testgui1=new GUIShape(new Point2D(1.4,8.4),true,Color.white,5);
		GUIShape testgui2=new GUIShape(new Point2D(1.4,8.4),true,Color.white,5);
		assertEquals(testgui1.toString(),testgui2.toString());
	}

	@Test//This method tests the acceptance of the geometric shape
	void testGetShape() {
	GUIShape testgui=new GUIShape(new Point2D(1.4,8.4),true,Color.white,5);
	Point2D p=new Point2D(1.4,8.4);
	assertEquals(testgui.getShape(),p);
     testgui=new GUIShape(new Point2D(6.4,8.7),true,Color.BLACK,5);
	 p=new Point2D(6.4,8.7);
	 assertEquals(testgui.getShape(),p);
		
	}

	@Test//This method tests the shape change
	void testSetShape() {
	GUIShape testgui=new GUIShape(new Point2D(1.4,8.4),true,Color.white,5);
	Point2D p=new Point2D(4,5);
	testgui.setShape(p);
	assertEquals(testgui.getShape(),p);
	 p=new Point2D(8,2);
	testgui.setShape(p);
	assertEquals(testgui.getShape(),p);	
		
	}

	@Test//This method checks the answer if the shape is full or empty
	void testIsFilled() {
      Point2D p1 =new Point2D(54.4,64.4);	
      Point2D p2 =new Point2D(7.44,9.4);	
      Point2D p3 =new Point2D(54.4,35.4);
      Triangle2D t1 =new Triangle2D(p1,p2,p3);
	  GUIShape testgui=new GUIShape(t1,true,Color.white,7);
	  assertEquals(testgui.isFilled(),true);
	  testgui=new GUIShape(t1,false,Color.white,7);
	  assertEquals(testgui.isFilled(),false);
	}

	@Test//This method tests the answer change
	void testSetFilled() {
	 Point2D p1 =new Point2D(54.4,64.4);	
	 Point2D p2 =new Point2D(7.44,9.4);	
	 Point2D p3 =new Point2D(54.4,35.4);
     Triangle2D t1 =new Triangle2D(p1,p2,p3);
     GUIShape testgui=new GUIShape(t1,true,Color.white,7);
     testgui.setFilled(false);
     assertEquals(testgui.isFilled(),false);
     testgui.setFilled(true);
     assertEquals(testgui.isFilled(),true);
	}

	@Test//This method checks the color acceptance
	void testGetColor() {
	GUIShape testgui=new GUIShape(new Point2D(1.4,8.4),true,Color.white,5);
	assertEquals(testgui.getColor(),Color.white);
	 testgui=new GUIShape(new Point2D(1.4,8.4),true,Color.blue,5);
	assertEquals(testgui.getColor(),Color.blue);
	}

	@Test//This method tests the color change
	void testSetColor() {
	GUIShape testgui=new GUIShape(new Point2D(1.4,8.4),true,Color.white,5);
	testgui.setColor(Color.blue);
	assertEquals(testgui.getColor(),Color.blue);
	testgui.setColor(Color.white);
	assertEquals(testgui.getColor(),Color.white);
	}

	@Test//This method tests the receipt of the number
	void testGetTag() {
  GUIShape testgui=new GUIShape(new Point2D(1.4,8.4),true,Color.white,5);
  assertEquals(testgui.getTag(),5);
  testgui=new GUIShape(new Point2D(1.4,8.4),true,Color.white,8);
  assertEquals(testgui.getTag(),8);
  testgui=new GUIShape(new Point2D(1.4,8.4),true,Color.white,0);
  assertEquals(testgui.getTag(),0);
		
	}

	@Test// This method tests the number change
	void testSetTag() {
    GUIShape testgui=new GUIShape(new Point2D(1.4,8.4),true,Color.white,5);
    testgui.setTag(8);
    assertEquals(testgui.getTag(),8);
    testgui.setTag(10);
    assertEquals(testgui.getTag(),10);
		
	}

	@Test// This tests checks the copy
	void testCopy() {
	GUIShape testgui=new GUIShape(new Point2D(1.4,8.4),true,Color.white,5);
	assertEquals(testgui.copy().toString(),testgui.toString());
	testgui=new GUIShape(new Point2D(1.46,46.4),true,Color.black,4);
	assertEquals(testgui.copy().toString(),testgui.toString());
	}
	@Test//This method checks the resulting string
	void testToString() {
	GUIShape testgui=new GUIShape();
	assertEquals(testgui.toString(),"GUIShape,255,true,1,Point2D,0.0,0.0");
		
		
	}

}
