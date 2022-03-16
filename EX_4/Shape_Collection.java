package ex4;

import java.awt.Color;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import java.util.Comparator;
import java.util.Scanner;

import ex4.geometry.Circle2D;

import ex4.geometry.Point2D;
import ex4.geometry.Rect2D;
import ex4.geometry.Triangle2D;
import ex4.geometry.Segment2D;

/**
 * 
 * This class represents a collection of GUI_Shape.
 * This class creates a GUI_Shape array.
 * The class uses an ArrayList array.
 * In the class you can delete, add, get objects in the array.
 * In the department you can also save the array in a file or get the array from a file
 */
public class Shape_Collection implements GUI_Shape_Collection {
	private ArrayList<GUI_Shape> container;

	/**
	 * This method constructor the class according to the ArrayList array
	 */
	public Shape_Collection() {
		this.container = new ArrayList<GUI_Shape>();
	}

	/**
	 * This method constructor the class according to the ArrayList array
	 * 
	 * @param container=ArrayList
	 */

	public Shape_Collection(ArrayList<GUI_Shape> container) {

		this.container = new ArrayList<GUI_Shape>(container);

	}

	/**
	 *  This method return a reference to the i'th element in the collection.
	 * @param i - the index of the element.
	 */

	@Override
	public GUI_Shape get(int i) {
		return this.container.get(i);
	}

	/**
	 * This method returns the size of the array
	 */

	@Override
	public int size() {
		int i = this.container.size();
		if (i == 0) {//if empty return 0
			return 0;
		}
		return i;
	}

	/**
	 * This method remove (and return) the gui_shape at the i'th l location.
	 * 
	 * @param i - the index of the element to be removed.
	 * @return the gui_shape which was removed
	 */

	@Override
	public GUI_Shape removeElementAt(int i) {
		GUI_Shape ans = this.container.get(i);
		this.container.remove(i);
		return ans;
	}

	/**
	 * This method adds objects to the array by index location
	 */
	@Override
	public void addAt(GUI_Shape s, int i) {
		this.container.add(i, s);

	}

	/**
	 * This method adds organs to the array
	 */

	@Override
	public void add(GUI_Shape s) {
		this.container.add(s);
	}

	/**
	 * This method copies the array
	 */
	@Override
	public GUI_Shape_Collection copy() {
		return new Shape_Collection(this.container);
	}
	
   /** 
    * This method sorts this gui_shape collection according 
    * to the comp Comparator - in increasing order. 
    */
	@Override
	public void sort(Comparator<GUI_Shape> comp) {
		this.container.sort(comp);
	}

	/**
	 * This method removes all objects from the array
	 */

	@Override
	public void removeAll() {
		this.container.removeAll(this.container);
	}

	/**
	 * This method saves this gui_shape collection to a text file.
	 * 
	 * @param file=the file name in which this collection will be saved.
	 */
	@Override
	public void save(String file) {
		try {
			FileWriter myWriter = new FileWriter(file);
			for (int i = 0; i < container.size(); i++) {
				myWriter.write(container.get(i).toString() + "\n");
			}
			myWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	/**
	 * This method restore a gui_shape collection from text file.
	 * The method works by disassembling the entire string.
	 * It puts everything in the file into the array 
	 */
	@Override
	public void load(String file) {
		try {
			File myObj = new File(file);
			Scanner myReader = new Scanner(myObj);
			ArrayList<GUI_Shape> loadarr=new ArrayList<GUI_Shape>();
			while (myReader.hasNextLine()) {
				boolean ans = true;
				double x1 = 0, y1 = 0, x2 = 0, y2 = 0, x3 = 0, y3 = 0;
				String data = myReader.nextLine();
				String[] a = data.split(",");//Puts the string into an array
				int color = Integer.parseInt(a[1]);//Conversion operation
				int flag = Integer.parseInt(a[3]);//Conversion operation
				if (a[2].equals("false")) {
					ans = false;
				}//****Checks if the shape is triangle2D****\\
				if (a[4].equals("Triangle2D")) {
					x1 = Double.parseDouble(a[5]);
					y1 = Double.parseDouble(a[6]);
					x2 = Double.parseDouble(a[7]);
					y2 = Double.parseDouble(a[8]);
					x3 = Double.parseDouble(a[9]);
					y3 = Double.parseDouble(a[10]);
					Point2D xy1 = new Point2D(x1, y1);
					Point2D xy2 = new Point2D(x2, y2);
					Point2D xy3 = new Point2D(x3, y3);
					GUIShape e = new GUIShape(new Triangle2D(xy1, xy2, xy3), ans, new Color(color), flag);
					loadarr.add(e);
				}//****Checks if the shape is Rect2D****\\
				if (a[4].equals("Rect2D")) {
					x1 = Double.parseDouble(a[5]);
					y1 = Double.parseDouble(a[6]);
					x2 = Double.parseDouble(a[7]);
					y2 = Double.parseDouble(a[8]);
					Point2D xy1 = new Point2D(x1, y1);
					Point2D xy2 = new Point2D(x2, y2);

					GUIShape e = new GUIShape(new Rect2D(xy1, xy2), ans, new Color(color), flag);
					loadarr.add(e);
				}//****Checks if the shape is segment2D****\\
				if (a[4].equals("Segment2D")) {
					x1 = Double.parseDouble(a[5]);
					y1 = Double.parseDouble(a[6]);
					x2 = Double.parseDouble(a[7]);
					y2 = Double.parseDouble(a[8]);
					Point2D xy1 = new Point2D(x1, y1);
					Point2D xy2 = new Point2D(x2, y2);
					GUIShape e = new GUIShape(new Segment2D(xy1, xy2), ans, new Color(color), flag);
					loadarr.add(e);
				}//****Checks if the shape is circle2D****\\
				if (a[4].equals("Circle2D")) {
					x1 = Double.parseDouble(a[5]);
					y1 = Double.parseDouble(a[6]);
					Point2D xy1 = new Point2D(x1, y1);
					GUIShape e = new GUIShape(new Circle2D(xy1, Double.parseDouble(a[7])), ans, new Color(color), flag);
					loadarr.add(e);

				}//****Checks if the shape is point2D*****\\
				if (a[4].equals("Point2D")) {
					x1 = Double.parseDouble(a[5]);
					y1 = Double.parseDouble(a[6]);
					Point2D xy1 = new Point2D(x1, y1);
					GUIShape e = new GUIShape(xy1, ans, new Color(color), flag);
					loadarr.add(e);
				}
				

			}//loadarr
			this.container=loadarr;

			myReader.close();
		} catch (Exception e) {
			e.printStackTrace();
			//throw new IllegalArgumentException("\n"+"!!! You did not type a valid file name !!!");
			
		}

	}
	
	
	/**
	 * This method returns the minimal bounding box containing 
	 * all the shapes in this collection.
	 * A method examines the maximum and minimum point of all
	 *  the points of the geometric shapes.
	 */

	@Override
	public Rect2D getBoundingBox() {
		double maxx = 0, maxy = 0, minx = 0, miny = Integer.MAX_VALUE;
		Point2D[][] ans = new Point2D[container.size()][];
		for (int i = 0; i < container.size(); i++) {
			if (container.get(i).getShape() instanceof Circle2D) {//Checks 4 points on the circle
				Point2D xy = container.get(i).getShape().centerOfMass();
				String[] radius = container.get(i).getShape().toString().split(",");
				double r = Double.parseDouble(radius[2]);
				Point2D[] Circle = new Point2D[4];//Finds 4 points on the circle
				Circle[0] = new Point2D(xy.x() + r, xy.y());//p1
				Circle[1] = new Point2D(xy.x() - r, xy.y());//p2
				Circle[2] = new Point2D(xy.x(), xy.y() + r);//p3
				Circle[3] = new Point2D(xy.x(), xy.y() - r);//p4
				ans[i] = Circle;
			} else {//Puts all the points in the array
				ans[i] = container.get(i).getShape().getPoints();
			}
		}
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[i].length; j++) {
				double xx = ans[i][j].x();
				double yy = ans[i][j].y();
				if (xx > maxx) {//Checks the maximum point x value
					maxx = xx;
				}
				if (yy > maxy) {//Checks the maximum point y value
					maxy = yy;
				}
				if (xx < minx) {//Checks the minimum point y value
					minx = xx;
				}
				if (yy < miny) {//Checks the minimum point y value
					miny = yy;
				}

			}
		}

		return new Rect2D(new Point2D(minx, miny), new Point2D(maxx, maxy));
	}
	/**
	 * This method presents the array as a string
	 */

	@Override
	public String toString() {
		String ans = "";
		for (int i = 0; i < container.size(); i++) {
			ans = ans + this.container.get(i).toString() + "\n";
		}
		return ans;

	}
}