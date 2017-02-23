package alixia.ash.guis.nodes;

import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JFrame;

public abstract class RectangleNode extends Node {
	private short endX, endY;

	public RectangleNode(short x, short y, short par3, short par4, boolean size) {
		super(x, y);
		if (size) {
			endX = (short) (x + par3);
			endY = (short) (y + par4);
		} else {
			endX = par3;
			endY = par4;
		}
	}
	
	public short getLength(){
		return (short) (endX-getX());
	}
	
	public short getWidth(){
		return (short) (endY-getY());
	}

	public final short getEndX() {
		return endX;
	}

	public final short getEndY() {
		return endY;
	}

	public boolean doesPointCross(short x, short y) {
		// TODO: Check if given positions are inside this Rectangular Node.
		return x > getX() && getX() < endX && y > getY() && y < endY;
	}

	public boolean doesPointCross(Point point) {
		return doesPointCross((short) point.getX(), (short) point.getY());
	}
	
	public abstract void render(Graphics graphicsObject, JFrame frame);

}
