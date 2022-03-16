package ex4;

import java.awt.Color;
import ex4.geometry.*;
/**
 * This class implements the GUI_shape.
 * In this class a different characterization can be constructed for each geometric shape.
 * 1. Color of the shape
 * 2. If the shape is full or empty
 * 3. Serial number for each shape
 * And the characterization can be changed for anyone
 */

public class GUIShape implements GUI_Shape{
	private GeoShape geo;
	private Color color;
	private boolean full_empty;
	private int tag;
	
	/**
	 * This method constructs a general characterization of a geometric shape
	 */
	
	public GUIShape() {
		this(new Point2D(0.0,0.0),true,Color.blue,1);
	}
	/**
	 * This method constructs according to the user's need
	 * @param geo=geometric shape
	 * @param full_empty=Is the shape full or empty
	 * @param color=The color of the shape
	 * @param tag=Serial number of the shape
	 */
	public GUIShape(GeoShape geo,boolean ans,Color color,int tag) {
		this.geo=geo.copy();
		this.full_empty=ans;
		this.color= new Color(color.hashCode());
		this.tag=tag;
	}
	/**
	 * This method returns the geometric shape
	 */
	
	@Override
	public GeoShape getShape() {
		return this.geo.copy();
	}
	/**
	 * This method changes the geometric shape
	 */

	@Override
	public void setShape(GeoShape g) {;
	this.geo= g ;
	}
	/**
	 * This method returns if the shape color is full or blank
	 */

	@Override
	public boolean isFilled() {
		return this.full_empty;
		}
	/**
	 * This method changes whether the shape color is full or blank
	 */

	@Override
	public void setFilled(boolean filled) {
		this.full_empty=filled;
	}
	/**
	 * This method returns the color of the shape
	 */

	@Override
	public Color getColor() {
		return new Color(color.hashCode()) ;
	}
	/**
	 * This method changes the color of the shape
	 */

	@Override
	public void setColor(Color cl) {
		this.color=new Color(cl.hashCode());
	}
	
	/**
	 * This method returns the serial number of the shape
	 */

	@Override
	public int getTag() {
		return this.tag;
	}
	/**
	 * This method changes the serial number of the shape
	 */

	@Override
	public void setTag(int tag) {
		this.tag=tag;
	}
	/**
	 * This method copies the properties of the shape
	 */

	@Override
	public GUI_Shape copy() {
		return new GUIShape(this.geo,this.full_empty,this.color,this.tag);
	}
	/**
	 * This method returns a string of all shape properties
	 */
	@Override
	public String toString() {
		return "GUIShape"+","+(this.color.getRGB()&0xffffff)+","+this.full_empty+","+this.tag+","+this.geo.getClass().getSimpleName()+","+this.geo.toString();
	}
}