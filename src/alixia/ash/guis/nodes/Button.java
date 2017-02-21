package alixia.ash.guis.nodes;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;

public class Button extends Node {
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

}
