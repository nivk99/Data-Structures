package ex4.tests;


import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.util.ArrayList;


import org.junit.jupiter.api.Test;

import ex4.GUIShape;
import ex4.GUI_Shape;
import ex4.Shape_Collection;
import ex4.Shape_Comp;
import ex4.geometry.Circle2D;
import ex4.geometry.Point2D;
import ex4.geometry.Rect2D;
import ex4.geometry.Triangle2D;
/**
 * This is a test department for Shape Collection.
 * The department tests all the methods in the department.
 * Like construction, copying. Modify, add, delete, save, get a string.
 * @author niv kotek
 */
class Shape_CollectionTest {
	public  Shape_Collection test=new Shape_Collection();
	private static 	Point2D p1 = new Point2D(0.4, 0.7);
	private static  Point2D p2 = new Point2D(0.4, 0.8);
	private  static  Point2D p3 = new Point2D(0.7, 0.2);
	public static GUI_Shape s1 = new GUIShape(new Triangle2D(p1,p2,p3),false, Color.blue, 1);
	public static GUI_Shape s2 = new GUIShape(new Circle2D(p1,0.3),true, Color.red, 2);
	public static GUI_Shape s3 = new GUIShape(new Rect2D(p1,p2),true, Color.green, 3);
	
	@Test// Method for testing the constructor
	void testShape_Collection() {
		Point2D t1 = new Point2D(5.5, 10.10);
	Shape_Collection test1=new Shape_Collection();
	assertEquals(test1.toString(), test.toString());
	test1.add(s1);
	assertNotEquals(test1.toString(), test.toString());
	test1.removeAll();;
	assertNotEquals(test1, test);
	}

	@Test// Method for testing the constructor
	void testShape_CollectionArrayListOfGUI_Shape() {
		Point2D t2 = new Point2D(4.4, 3.3);
		ArrayList<GUI_Shape>collection =new ArrayList<GUI_Shape>();
		collection.add(s1);
	assertEquals(new Shape_Collection(collection).get(0), collection.get(0));
	assertEquals(new Shape_Collection(collection).size(), collection.size());
	}

	@Test// Method for testing the get an object from an array according to the index
	void testGet() {
	ArrayList<GUI_Shape>collection =new ArrayList<GUI_Shape>();
	Shape_Collection test_get =new Shape_Collection(collection);
	test_get.add(s1);
	test_get.add(s2);
	assertEquals(test_get.get(0),s1);
	assertEquals(test_get.get(1),s2);
	}

	@Test//Check on the size of the entire array
	void testSize() {
	ArrayList<GUI_Shape>collection =new ArrayList<GUI_Shape>();
	Shape_Collection test_get =new Shape_Collection(collection);
	test_get.add(s1);
	test_get.add(s2);
	test_get.add(s3);
		assertEquals(test_get.size(),3);
		test_get.removeAll();
		assertEquals(test_get.size(),0);
		test_get.add(s1);
		assertEquals(test_get.size(),1);
		test_get.add(s2);
		assertEquals(test_get.size(),2);
		test_get.add(s3);
		assertEquals(test_get.size(),3);
		test_get.removeAll();
		assertEquals(test_get.size(),0);
		
	}
	

	@Test//Check for deleting an object in position
	void testRemoveElementAt() {
	ArrayList<GUI_Shape>collection =new ArrayList<GUI_Shape>();
	Shape_Collection test_get =new Shape_Collection(collection);
	test_get.add(s1);
	test_get.add(s2);
	test_get.add(s3);
	test_get.removeElementAt(0);
	assertEquals(test_get.size(),2);
	assertEquals(test_get.get(0).toString(),s2.toString());
	test_get.removeElementAt(0);
	assertEquals(test_get.get(0),s3);
	assertEquals(test_get.size(),1);
	
	}

	@Test//Check for adding an object to a location
	void testAddAt() {
		ArrayList<GUI_Shape>collection =new ArrayList<GUI_Shape>();
		Shape_Collection test_get =new Shape_Collection(collection);
		test_get.addAt(s1, 0);
		test_get.addAt(s2, 1);
		test_get.addAt(s3, 0);
		assertEquals(test_get.get(0),s3);
		assertEquals(test_get.get(1),s1);
		assertEquals(test_get.get(2),s2);
		
		
	}

	@Test//Check for adding an object to the array
	void testAdd() {
		ArrayList<GUI_Shape>collection =new ArrayList<GUI_Shape>();
		Shape_Collection test_get =new Shape_Collection(collection);
		test_get.add(s1);
		assertEquals(test_get.get(0),s1);
		assertEquals(test_get.size(),1);
		test_get.add(s2);
		assertEquals(test_get.get(1),s2);
		assertEquals(test_get.size(),2);
		test_get.add(s3);
		assertEquals(test_get.get(2),s3);
		assertEquals(test_get.size(),3);
		
	}

	@Test//Check for copying an object in the array
	void testCopy() {
		ArrayList<GUI_Shape>collection =new ArrayList<GUI_Shape>();
		Shape_Collection test_get =new Shape_Collection(collection);
		assertNotEquals(test_get,test_get.copy());
		assertEquals(test_get,test_get);
		
	}

	@Test//Check for array sorting
	void testSort() {
		Point2D a1 = new Point2D(0.8,0.7), a2 = new Point2D(0.3,0.7), a3 = new Point2D(0.1,0.7);;
		Triangle2D t1 = new Triangle2D(a1,a2,a3);
		GUI_Shape s1 = new GUIShape(t1,false, Color.blue, 2);
		GUI_Shape s2 = new GUIShape(a1,false, Color.BLUE, 3);
		GUI_Shape s3 = new GUIShape(a2,false, Color.gray, 4);
		ArrayList<GUI_Shape>collection =new ArrayList<GUI_Shape>();
		Shape_Collection test_get =new Shape_Collection(collection);
		test_get.add(s1);
		test_get.add(s2);
		test_get.add(s3);
		assertEquals(test_get.get(0),s1);
		assertEquals(test_get.get(1),s2);
		assertEquals(test_get.get(2),s3);
		Shape_Comp comp = new Shape_Comp(1);
		test_get.sort(comp);
		assertEquals(test_get.get(2),s1);
		assertEquals(test_get.get(1),s2);
		assertEquals(test_get.get(0),s3);
		comp = new Shape_Comp(5);
		test_get.sort(comp);
		assertEquals(test_get.get(0),s1);
		assertEquals(test_get.get(2),s2);
		assertEquals(test_get.get(1),s3);
		comp = new Shape_Comp(0);
		test_get.sort(comp);
		assertEquals(test_get.get(0),s1);
		assertEquals(test_get.get(1),s2);
		assertEquals(test_get.get(2),s3);
	}

	@Test//Check for deletion of all objects in the array
	void testRemoveAll() {
		ArrayList<GUI_Shape>collection =new ArrayList<GUI_Shape>();
		Shape_Collection test_get =new Shape_Collection(collection);
		test_get.add(s1);
		test_get.add(s2);
		test_get.add(s3);
		assertEquals(test_get.size(),3);
		test_get.removeAll();
		assertEquals(test_get.size(),0);
		test_get.add(s1);
		assertEquals(test_get.size(),1);
		test_get.removeAll();
		assertEquals(test_get.size(),0);
		
	}

	@Test//Check for saving within a file
	void testSave() {
		ArrayList<GUI_Shape>collection =new ArrayList<GUI_Shape>();
		Shape_Collection test_get =new Shape_Collection(collection);
		test_get.add(s1);
		test_get.add(s2);
		test_get.add(s3);
		test_get.save("testSave");
		assertEquals(test_get.size(),3);
		test_get.removeAll();
		assertEquals(test_get.size(),0);
		test_get.load("testSave");
		assertEquals(test_get.size(),3);
		
	}

	@Test//Check for reading from a file
	void testLoad() {
		ArrayList<GUI_Shape>collection =new ArrayList<GUI_Shape>();
		Shape_Collection test_get =new Shape_Collection(collection);
		test_get.add(s1);
		test_get.add(s2);
		test_get.add(s3);
		test_get.save("testLoad");
		assertEquals(test_get.size(),3);
		assertEquals(test.size(),0);
		test.load("testLoad");
		assertEquals(test_get.size(),3);
		assertEquals(test_get.get(0).toString(),test.get(0).toString());
		assertEquals(test_get.get(1).toString(),test.get(1).toString());
		assertEquals(test_get.get(2).toString(),test.get(2).toString());
	}

	@Test//Check for a rectangle that contains all the shapes
	void testGetBoundingBox() {
		Point2D a1 = new Point2D(0.8,0.7), a2 = new Point2D(0.3,0.7), a3 = new Point2D(0.0,0.7) ,a4 = new Point2D(0.8,0.7);
		Triangle2D t1 = new Triangle2D(a1,a2,a3);
		GUI_Shape s1 = new GUIShape(t1,false, Color.blue, 2);
		GUI_Shape s2 = new GUIShape(a1,false, Color.BLUE, 3);
		GUI_Shape s3 = new GUIShape(a2,false, Color.gray, 4);
		ArrayList<GUI_Shape>collection =new ArrayList<GUI_Shape>();
		Shape_Collection test_get =new Shape_Collection(collection);
		test_get.add(s1);
		test_get.add(s2);
		test_get.add(s3);
		Rect2D ans=new Rect2D(a3,a4);
		assertEquals(test_get.getBoundingBox().toString(),ans.toString());
		Point2D p1 = new Point2D(0.0,2.147483647E9), p2 = new Point2D(0.0,0.0) ;
		Rect2D ans2=new Rect2D(p1,p2);
		assertEquals(test.getBoundingBox().toString(),ans2.toString());
		
	}

	@Test//Check for a string of the array
	void testToString() {
		ArrayList<GUI_Shape>collection =new ArrayList<GUI_Shape>();
		Shape_Collection test_get =new Shape_Collection(collection);
		test_get.add(s1);
		ArrayList<GUI_Shape>tostring =new ArrayList<GUI_Shape>();
		Shape_Collection ans =new Shape_Collection(tostring);
		ans.add(s1);
		assertEquals(test_get.toString(),ans.toString());
	

		
	
	}

	

	

}
