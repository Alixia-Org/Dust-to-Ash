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
 * The structure of this game's code is setup to where everything branches out
 * like a tree. The very base is this class, which holds other objects such as
 * the ones specified above. Each of those objects contribute their own
 * functions and methods and may hold other objects which each do the same. This
 * can change if necessary.
 * 
 * @author Zeale
 *
 */
public final class Ash {

	/**
	 * This is a static method used to retrieve a graphical resource (an
	 * {@link Image}) from the classpath, (specifically, the
	 * <code>graphics</code> folder).<br>
	 * <br>
	 * 
	 * This method is made to cut down on tedious work.
	 * 
	 * @param path
	 *            The path of the resource that will be retrieved.
	 * @return A new Image object that was created using the resource specified.
	 */
	public static Image getGraphic(String path) {
		return new ImageIcon(Ash.class.getResource("graphics/" + path)).getImage();
	}

	/**
	 * This class's main method. The program currently starts from here. This
	 * method just creates a new <code>Ash</code> object and then starts it.
	 * 
	 * @param args
	 *            Program Arguments.
	 */
	public static void main(String[] args) {
		Ash ash = new Ash();
		ash.start();

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
	private World world = new World(this);

	/**
	 * This method is called when the game has finished running. It closes the
	 * window, saves the game, and disposes anything that needs to be disposed
	 * of. Anything that needs to be run when the game closes should be put put
	 * in the dispose method of an object.
	 */
	private void dispose() {
		timer.dispose();
		window.dispose();
		world.dispose();
	}

	/**
	 * This method is a simple getter for this object's {@link #timer} object.
	 * 
	 * @return This object's {@link #timer} object.
	 */
	public Timer getTimer() {
		return timer;
	}

	/**
	 * This method is a simple getter for the {@link #window} object.
	 * 
	 * @return This Ash object's window.
	 */
	public Window getWindow() {
		return window;
	}

	/**
	 * This method is called when the program is started. It initializes
	 * everything and sets up the game. If a save is found (see
	 * {@link #isFirstLaunch()}), then the save is loaded up in this method.
	 */
	private void initialize() {
		window.initialize();
		world.initialize();
		timer.initialize();

		window.start();
		timer.start();
	}

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
	 * This method is called by the {@link #window} when a key is pressed on the
	 * keyboard. This event is fired at the same time that the key is pushed
	 * down. The {@link #onKeyReleased(KeyEvent)} method handles when a key is
	 * released.
	 * 
	 * @param e
	 *            The KeyEvent object of this event. It contains data about the
	 *            event, like what key was pressed.
	 * 
	 * @see #onKeyReleased(KeyEvent)
	 */
	public void onKeyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
			timer.stop();
	}

	/**
	 * This method is called by the {@link #window} when a key is released.
	 * 
	 * @param e
	 *            The KeyEvent object of this event. It contains data about the
	 *            event, like what key was released.
	 */
	public void onKeyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * This method is called by the {@link #window} when a key is typed on the
	 * keyboard.
	 * 
	 * @param e
	 *            The KeyEvent object of this event. It contains data about this
	 *            event, like what key was typed.
	 */
	public void onKeyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	/**
	 * This method is called by the {@link #window} when any of the mouse keys
	 * are clicked, (pushed down then released; including the mouse wheel).
	 * 
	 * @param e
	 *            The MouseEvent object of this event. It contains data about
	 *            the event, like the position at which it occurred on the
	 *            screen and which part of the mouse was clicked.
	 */
	public void onMouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * This method is called by the {@link #window} when the user holds down a
	 * mouse button while moving the mouse. (This includes the mouse wheel)
	 * 
	 * @param e
	 *            The MouseEvent object of this event. It contains information
	 *            about the event.
	 */
	public void onMouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * This method is called by the {@link #window} when the mouse enters the
	 * screen.
	 * 
	 * @param e
	 *            The MouseEvent object of this event. It contains data about
	 *            the position of the mouse when this event was fired.
	 */
	public void onMouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * This method is called by the {@link #window} when the mouse exits the
	 * screen.
	 * 
	 * @param e
	 *            The MouseEvent object of this event. It contains data about
	 *            the position of the mouse when this event was fired.
	 */
	public void onMouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * This method is called by the {@link #window} when the mouse is moved.
	 * 
	 * @param e
	 *            The MouseEvent object of this event. It contains information
	 *            about the event.
	 */
	public void onMouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * This method is called by the {@link #window} when any of the mouse keys
	 * are pressed down. (This includes the mouse wheel.)
	 * 
	 * @param e
	 *            The MouseEvent object of this event. It contains data about
	 *            the event, like the position at which it occurred on the
	 *            screen and which part of the mouse was pressed.
	 */
	public void onMousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * This method is called by the {@link #window} when any of the buttons on
	 * the mouse are released. (This includes the mouse wheel.)
	 * 
	 * @param e
	 *            The MouseEvent object of this event. It contains data about
	 *            the event, like the position of the mouse on the screen when
	 *            the event occurred, and which button on the mouse was
	 *            released.
	 */
	public void onMouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * This method is called by the {@link #window} when the mouse wheel is
	 * moved.
	 * 
	 * @param e
	 *            The MouseEvent object of this event. It contains information
	 *            about the event.
	 */
	public void onMouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub

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
	public void onRender(Graphics graphics, JFrame observer) {
		world.onRender(graphics, observer);
	}

	/**
	 * This method is called once every 'tick.' A <code>tick</code> occurs once
	 * every time the game loop runs. See {@link Timer} and {@link Timer#loop()}
	 * for more details on ticks and how the game loop is managed.
	 * 
	 * @param physics
	 *            A boolean determining whether or not to run any physics.
	 * @param rendering
	 *            A boolean determining whether or not to run any rendering.
	 * 
	 * @see Timer
	 * @see Timer#loop()
	 */
	public void onTick(boolean physics, boolean rendering) {
		if (physics)
			world.onTick();
		window.onTick(rendering);

	}

	/**
	 * This method starts the game. This method will manage everything, from
	 * starting the game to stopping it.
	 */
	public void start() {
		initialize();
		dispose();
	}

	public void stop() {
		timer.stop();
	}

	/**
	 * This 'ratio' is used to scale things to the size of the screen (using the
	 * 1920x1080 resolution.)<br>
	 * <br>
	 * 
	 * Example: Lets say you want the program to stop when the user moves the
	 * mouse to the top 1/8th of the screen. In the common resolution of
	 * 1920x1080, the top 1/8th of the screen would be from 0 (the very top) to
	 * 135px down. So, if the user runs their game with a resolution of
	 * 1920x1080, we would have our code set up so that it will detect mouse
	 * movement within the coordinates 0 to 135 on the y axis (height). But what
	 * if they run the game in 4k (3840 x 2160)? <br>
	 * <br>
	 * Quick solution for this (if you don't care to know how it works) is that
	 * you can take your original numbers (0 to 135) and multiply them by
	 * {@link #SCREEN_HEIGHT_RATIO}. The 0 multiplied by the ratio is 0..., and
	 * the 135 multiplied by this ratio will give 270... (2160 / 8 is 270) This
	 * gives you 1/8th of the screen.<br>
	 * <br>
	 * Now, you've probably already guessed that the actual value of this ratio
	 * would be 2 if you ran the game in 4k. When you multiply a number (like
	 * 135) by the height ratio, what's happening is that: <br>
	 * <br>
	 * The number you multiply (135 in this example) is divided by 1920, then
	 * the result is multiplied by the screen size. So if you imagine this as a
	 * sequence of steps...<br>
	 * <br>
	 * <ul>
	 * <li>First you would take out the <code>1080</code> from the number 135.
	 * This leaves you with a decimal. This decimal <strong>represents a portion of the
	 * screen</strong> so if you multiply the screen size (1080) by this
	 * decimal, you will get your number (135). 135 is 1/8th of 1080, so this
	 * decimal will be equal to 1/8.</li>
	 * <li>Second, you would simply multiply this portion by the actual size of
	 * the screen (which could be whatever but for now I'll use 2160) to get the
	 * area you want. (270)</li>
	 * </ul>
	 * <br>
	 * <br>
	 * This is probably the most I've ever documented on a single variable. Have
	 * fun reading all this. Also, if someone reports this method as "not in
	 * depth enough" then I'll probably kill myself.
	 */
	public final float SCREEN_WIDTH_RATIO = (float) 1 / 1920 * window.getWindowWidth(),
			SCREEN_HEIGHT_RATIO = (float) 1 / 1080 * window.getWindowHeight();

}
