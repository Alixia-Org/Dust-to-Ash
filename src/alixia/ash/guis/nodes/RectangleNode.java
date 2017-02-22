package alixia.ash.guis.nodes;

import java.awt.Point;

public class RectangleNode extends Node {
	private short endX, endY;

	public RectangleNode(short x, short y, short endX, short endY) {
		super(x, y);
		this.endX = endX;
		this.endY = endY;
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

}
