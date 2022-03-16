package ex4;
import java.awt.Color;

/**
 * This interface represents a GUI shape with meta data of color, fill/empty and tag.
 * It also contains a geometric shape (GeoShape).
 *  Ex4: you should NOT change this interface!
 * @author boaz.benmoshe
 */
import ex4.geometry.GeoShape;
public interface GUI_Shape {
	public GeoShape getShape();//צורת גיאושפ
	public void setShape(GeoShape g);//שיושפ צורה
	public boolean isFilled();// האם הצורה להיות צבועה
	public void setFilled(boolean filled);//
	public Color getColor();
	public void setColor(Color cl);
	public int getTag();
	public void setTag(int tag);
	public GUI_Shape copy();
	public String toString();
}