package alixia.ash;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;

/**
 * The Tile class represents a 100px x 100px object in the game that makes up
 * the ground. The ground is made of lots of Tiles put together. Tiles are
 * managed by the {@link Map} class. <br>
 * <br>
 * Tile icons are the icons that are rendered on the screen (or the Tile's
 * texture). See {@link #icon} for more information. <br>
 * <br>
 * <br>
 * 
 * <strong>Note: The coordinates stored in a Tile are not screen coordinates;
 * they represent the position of a Tile in its Map.</strong> (See {@link Map}
 * and its <code>tiles</code> array.) <strong>Tiles are rendered at a size of
 * 100x100 so multiplying their position by 100 should give their onscreen
 * position.</strong>
 * 
 * @author Zeale
 *
 */
public class Tile extends Object {

	/**
	 * The position of this Tile in its {@link Map}.
	 */
	private int x, y;
	/**
	 * This Tile's texture. When rendered, it is scaled to a size of 100 by 100
	 * to fit in between the tiles next to it. Any image size is acceptable by
	 * code, however.
	 */
	private Image icon;
	/**
	 * This is a reference to the currently running Ash instance.
	 */
	private final Ash instance;

	/**
	 * This constructor generates a new Tile using its Image, position, and a
	 * reference to the current Ash object.
	 * 
	 * @param icon
	 *            The texture of this Tile.
	 * @param x
	 *            The x-coordinate of this Tile in its Map.
	 * @param y
	 *            The y-coordinate of this Tile in its Map.
	 * @param instance
	 *            A reference to the current Ash object.
	 */
	public Tile(Image icon, int x, int y, Ash instance) {
		this.instance = instance;
		this.icon = icon;
		this.x = x;
		this.y = y;
	}

	/**
	 * This is a getter for this Tile's texture.
	 * 
	 * @return This Tile's texture.
	 */
	public Image getIcon() {
		return icon;
	}

	/**
	 * This method will return the current X position of this Tile in its Map.
	 * <strong>A Tile's position is different from its pixel position. See
	 * {@link #x} for more details.</strong>
	 * 
	 * @return This Tile's x position.
	 */
	public int getX() {
		return x;
	}

	/**
	 * This method will return the current Y position of this Tile in its Map.
	 * <strong>A Tile's position is different from its pixel position. See
	 * {@link #y} for more details.</strong>
	 * 
	 * @return This Tile's y position.
	 */
	public int getY() {
		return y;
	}

	/**
	 * This method is called when the game attempts to render its objects.
	 * 
	 * @param graphics
	 *            The {@link Graphics} object that is used to draw to the
	 *            Window.
	 * @param observer
	 *            The JFrame that owns the <code>graphics</code> object. This
	 *            can be passed to
	 *            {@link Graphics#drawImage(Image, int, int, java.awt.image.ImageObserver)}
	 *            or any other drawImage method that takes in an ImageObserver
	 *            or can be used to find the length and width of the window.
	 */
	public void onRender(Graphics graphics, JFrame observer) {

		// Test whether or not the image should be rendered depending on where
		// the camera is (instance.getWindow().getCameraXPosition()).
		graphics.drawImage(icon, x, y, 100, 100, observer);

	}

	public void onTick() {
		return;
	}
}
