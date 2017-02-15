package alixia.ash;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;

/**
 * The Tile class represents a 100px x 100px object in the game that makes up
 * the ground. The ground is made of lots of Tiles put together. Tiles are
 * managed by the {@link Map} class.
 * <br>
 * <br>
 * Tile images are 
 * 
 * @author Zeale
 *
 */
public class Tile extends Object {

	private int x, y;
	private Image icon;
	private final Ash instance;

	public Tile(Image icon, int x, int y, Ash instance) {
		this.instance = instance;
		this.icon = icon;
		this.x = x;
		this.y = y;
	}

	public Image getIcon() {
		return icon;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void onTick() {

	}

	public void onTick(Ash instance) {
		return;
	}

	public void onRender(Graphics graphics, JFrame observer) {

		// Test whether or not the image should be rendered depending on where
		// the camera is (instance.getWindow().getCameraXPosition()).
		graphics.drawImage(icon, x, y, 100, 100, observer);

	}
}
