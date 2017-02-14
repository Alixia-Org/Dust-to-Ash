package alixia.ash;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * The main class for <strong>Dust to Ash...</strong> This class is instantiated
 * and its {@link #start()} method is called to launch the game.<br>
 * <br>
 * This object wraps other objects that the game needs to run, such as, <br>
 * <br>
 * <ul>
 * <li>A {@link Window} object, which manages the window in which <strong>Dust
 * to Ash</strong> runs.</li>
 * <li>A {@link Timer} object, which controls the game loop, the game's time,
 * and when other objects will tick.</li>
 * <li>A {@link World} object, which manages the physical gamespace of the world
 * and holds all its objects. (The World object has its own unique methods and
 * wraps a couple other objects.)</li>
 * </ul>
 * 
 * <br>
 * <br>
 * <br>
 * The structure of this game's code is setup where everything branches out like
 * a tree. The very base is this class, which holds other objects such as the
 * ones specified above. Each of those objects contribute their own functions
 * and methods and may hold other objects which each do the same. This can
 * change if necessary.
 * 
 * @author Zeale
 *
 */
public final class Ash {

	/**
	 * This method checks if <strong>Ash</strong> has been launched before. It
	 * looks up the main save file and returns true if the file exists and is
	 * readable.
	 * 
	 * @return <code>true</code> if the game has been launched before,
	 *         (specifically, if it has found a save data file). Returns
	 *         <code>false</code> otherwise.
	 */
	public boolean isFirstLaunch() {
		// TODO Check if the game has been launched before.
		return true;
	}

	/**
	 * This method starts the game. This method will manage everything, from
	 * starting the game to stopping it.
	 */
	public void start() {
		initialize();
		dispose();
	}

	/**
	 * This object is used to manage the game window. See {@link Window} for
	 * more details.
	 */
	private final Window window = new Window(this);
	/**
	 * This object manages time in the game AND runs the game loop. It
	 * dispatches calls to this object (in the {@link #onTick()} method) which
	 * then calls ticks on everything else. See {@link Timer} for more details.
	 */
	private final Timer timer = new Timer(this);
	/**
	 * This object manages the physical world of the game. It stores the
	 * positions of objects, tiles, and other things in the game. See
	 * {@link World} for more details.
	 */
	private final World world = new World(this);

	/**
	 * This method is a simple getter for the {@link #window} object.
	 * 
	 * @return This Ash object's window.
	 */
	public Window getWindow() {
		return window;
	}

	/**
	 * This method is called once every 'tick.' A <code>tick</code> occurs once
	 * every time the game loop runs. See {@link Timer} and {@link Timer#loop()}
	 * for more details on ticks and how the game loop is managed.
	 * 
	 * @see Timer
	 * @see Timer#loop()
	 */
	public void onTick() {
		world.onTick();
		window.onTick();

	}

	/**
	 * This method is called every time this object's {@link #window} tells the
	 * game to render things to the screen. The Window schedules render calls on
	 * each tick by the {@link #timer}. See {@link Window} and {@link Timer} for
	 * more details.
	 * 
	 * <br>
	 * <br>
	 * This method takes in a {@link Graphics} object which is used to draw to
	 * the {@link #window}. Windows use JFrames and JPanels for drawing and
	 * rendering. See the {@link Window} class for more details.
	 * 
	 * @param graphics
	 *            The Graphics object that's used to draw to the window. See
	 *            {@link Graphics} for code and methods from the object itself.
	 * @param observer
	 *            The JFrame that wrapped by the {@link #window}. This can be
	 *            used to get the size of the area that is shown to the player
	 *            or passed into any of the Graphics object's drawImage()
	 *            methods.
	 * 
	 * @see Window
	 * @see Graphics
	 * 
	 * @see Graphics#drawImage(Image, int, int, int, int, int, int, int, int,
	 *      java.awt.image.ImageObserver)
	 * @see Graphics#drawImage(Image, int, int, int, int, int, int, int, int,
	 *      java.awt.Color, java.awt.image.ImageObserver)
	 * @see Graphics#drawImage(Image, int, int, java.awt.image.ImageObserver)
	 * @see Graphics#drawImage(Image, int, int, java.awt.Color,
	 *      java.awt.image.ImageObserver)
	 * @see Graphics#drawImage(Image, int, int, int, int,
	 *      java.awt.image.ImageObserver)
	 * @see Graphics#drawImage(Image, int, int, int, int, java.awt.Color,
	 *      java.awt.image.ImageObserver)
	 * 
	 */
	void onRender(Graphics graphics, JFrame observer) {
		// TODO Run onRender code.
	}

	public Timer getTimer() {
		return timer;
	}

	private void dispose() {
		timer.dispose();
		window.dispose();
		world.dispose();
	}

	private void initialize() {
		window.initialize();
		world.initialize();
		timer.initialize();

		timer.start();
	}

	public static Image getGraphic(String path) {
		return new ImageIcon(Ash.class.getResource("graphics/" + path)).getImage();
	}

	public static void main(String[] args) {
		Ash ash = new Ash();
		ash.start();

	}

	public void onKeyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub

	}

}
