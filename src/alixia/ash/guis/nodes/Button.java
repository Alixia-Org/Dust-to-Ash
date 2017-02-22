package alixia.ash.guis.nodes;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class Button extends RectangleNode {
	private Image icon;

	public Button(Image icon, short x, short y) {
		super(x, y);
		this.icon = icon;
	}

	public Image getIcon() {
		return icon;
	}

	public void onRender(Graphics graphics, JFrame frame) {
		// TODO Render
	}

	@Override
	public final void onClick(MouseEvent event) {
		super.onClick(event);
		if (doesPointCross((short) event.getX(), (short) event.getY()))
			;
	}

	public void onClick() {

	}
}
