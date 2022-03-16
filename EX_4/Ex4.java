package ex4;

import java.awt.Color;
import java.util.Arrays;

import ex4.geometry.*;

/**
 * This class is the "main" class This method interfaces the Ex4_GUI class In
 * this class you can find the method of drawing the shapes within the whole
 * array
 * 
 * @author niv kotek
 */
public class Ex4 implements Ex4_GUI  {
	private GUI_Shape_Collection gui;

	/**
	 * This method creates a new object for the class
	 */
	public Ex4() {
		this.gui = new Shape_Collection();
	}

	/**
	 * This method updates the object in the class
	 */

	@Override
	public void init(GUI_Shape_Collection g) {
		this.gui = g;

	}

	/**
	 * This method returns a getShape_Collection object
	 */

	@Override
	public GUI_Shape_Collection getShape_Collection() {
		return this.gui;
	}

	/**
	 * This method draws the geometric shape according to the array it receives. The
	 * method checks for each shape and draws it according to the array
	 */
	@Override
	public void show() {
		//Draws the rectangle
		//Rect2D bb = gui.getBoundingBox();
		//Point2D min = bb.getPoints()[0], max = bb.getPoints()[1];
		//GUI_Shape s7 = new GUIShape(bb,false, Color.gray, gui.size());
		//gui.add(s7);
		//double m0 = Math.min(min.x(), min.y());
		//double m1 = Math.max(max.x(), max.y());
		//StdDraw.setScale(m0-0.1,m1+0.1);
		for (int i = 0; i < gui.size(); i++) {
			// Check the shape is Color\\
			StdDraw.setPenColor(gui.get(i).getColor());
			StdDraw.setPenRadius(0.01);
			/************** Check if the shape is a Circle2D ******************/
			if (gui.get(i).getShape() instanceof Circle2D) {
				Point2D xy = gui.get(i).getShape().centerOfMass();
				String[] radius = gui.get(i).getShape().toString().split(",");
				// Check if the shape is filled\\
				if (gui.get(i).isFilled()) {
					StdDraw.filledCircle(xy.x(), xy.y(), Double.parseDouble(radius[2]));
				} else {
					StdDraw.circle(xy.x(), xy.y(), Double.parseDouble(radius[2]));
				}
			}
			/************** Check if the shape is a Point2D ******************/
			if (gui.get(i).getShape() instanceof Point2D) {
				Point2D xy = gui.get(i).getShape().centerOfMass();
				StdDraw.point(xy.x(), xy.y());
			}

			/************** Check if the shape is a Triangle2D ******************/
			if (gui.get(i).getShape() instanceof Triangle2D) {
				Point2D[] xy = gui.get(i).getShape().getPoints();
				double[] x = { xy[0].x(), xy[1].x(), xy[2].x() };
				double[] y = { xy[0].y(), xy[1].y(), xy[2].y() };
				// Check if the shape is filled\\
				if (gui.get(i).isFilled()) {
					StdDraw.filledPolygon(x, y);
				} else {
					StdDraw.polygon(x, y);
				}

			}

			/************** Check if the shape is a Segment2D ******************/
			if (gui.get(i).getShape() instanceof Segment2D) {
				Point2D[] xy = gui.get(i).getShape().getPoints();
				double[] x = { xy[0].x(), xy[1].x() };
				double[] y = { xy[0].y(), xy[1].y() };
				// Check if the segment2D is a point2D
				if ((xy[0].x() == xy[1].x()) && (xy[0].y() == xy[1].y())) {
					StdDraw.point(xy[0].x(), xy[0].y());
				} else {
					// Check if the shape is filled\\
					if (gui.get(i).isFilled()) {
						StdDraw.filledPolygon(x, y);
					} else {
						StdDraw.polygon(x, y);
					}
				}
			}
			/************** Check if the shape is a Rect2D ******************/
			if (gui.get(i).getShape() instanceof Rect2D) {
				Point2D xy = gui.get(i).getShape().centerOfMass();
				Point2D[] length = gui.get(i).getShape().getPoints();
				double height = Math.abs(length[0].y() - length[1].y());
				double width = Math.abs(length[0].x() - length[1].x());
				double[] x = { length[0].x(), length[1].x() };
				double[] y = { length[0].y(), length[1].y() };
				// Check if the shape is filled\\
				if (gui.get(i).isFilled()) {
					// Check if the rectangle is a segment2D
					if ((length[0].x() == length[1].x()) || (length[0].y() == length[1].y())) {
						StdDraw.filledPolygon(x, y);
					} else {

						StdDraw.filledRectangle(xy.x(), xy.y(), (width) / 2, (height) / 2);
					}
				} else {
					// Check if the rectangle is a segment2D
					if ((length[0].x() == length[1].x()) || (length[0].y() == length[1].y())) {
						StdDraw.polygon(x, y);
					} else {
						StdDraw.rectangle(xy.x(), xy.y(), (width) / 2, (height) / 2);
					}

				}

			}

		}
		
		//gui.removeElementAt(gui.size()-1);
	}

	/**
	 * This method returns a String containing all the "toString" of each GUI_shape
	 * in the collection.
	 * 
	 * @return - a String with all the "toString"s af all shapes in the collection.
	 */

	@Override
	public String getInfo() {
		return gui.toString();
	}
}