package alixia.ash;

/**
 * This class manages ticking and game time. Game time starts at 0 and goes to
 * 15000 and the time of day in game starts at 12:00 midnight and ends at 11:59
 * PM in respect to game time. 7500 is 12 AM (noon) in the time of day.<br>
 * <br>
 * 
 * This class also handles when a tick happens and calls the current Ash's
 * {@link Ash#onTick()} method. A tick is <strong>one iteration of the game
 * loop</strong>.
 * 
 * @author Zeale
 *
 */
public class Timer {

	/**
	 * The Ash object that is currently running.
	 */
	private final Ash instance;

	/**
	 * This variable determines whether or not to run physics. This variable can
	 * be set to false to prevent physics functions from being called using
	 * {@link #pausePhysics()}. {@link #resumePhysics()} will set this variable
	 * to true and resume the game's physics.
	 */
	private boolean physics = true;
	/**
	 * This variable determines whether or not rendering updates will be
	 * performed. If this is set to false, the window will not repaint,
	 * therefore, the screen will be a stale image until this variable is set to
	 * true. Modifying this variable can be done using {@link #pauseRendering()}
	 * and {@link #resumeRendering()}.
	 */
	private boolean rendering = true;

	/**
	 * Pauses physics functions in the game. See the game loop and the
	 * {@link #physics} variable for more details. Physics can be resumed using
	 * the {@link #resumePhysics()} variable.
	 * 
	 * @see #loop()
	 * @see #resumePhysics()
	 * @see #pauseRendering()
	 * @see #resumeRendering()
	 * @see #physics
	 */
	public void pausePhysics() {
		physics = false;
	}

	/**
	 * Resumes physics calculations in the game. See the game loop and the
	 * {@link #physics} variable for more details. Physics can be paused using
	 * {@link #pausePhysics()}.
	 * 
	 * @see #loop()
	 * @see #pausePhysics()
	 * @see #pauseRendering()
	 * @see #resumeRendering()
	 * @see #physics
	 */
	public void resumePhysics() {
		physics = true;
	}

	/**
	 * Pauses rendering in the game. See the game loop and the
	 * {@link #rendering} variable for more details. Rendering can be resumed
	 * using the {@link #resumeRendering()} method.
	 * 
	 * @see #loop()
	 * @see #resumeRendering()
	 * @see #pausePhysics()
	 * @see #resumePhysics()
	 * @see #rendering
	 */
	public void pauseRendering() {
		rendering = false;
	}

	/**
	 * Resumes rendering in the game. See the game loop and the
	 * {@link #rendering} variable for more details. Rendering can be paused
	 * using the {@link #pauseRendering()} method.
	 * 
	 * @see #loop()
	 * @see #pauseRendering()
	 * @see #pausePhysics()
	 * @see #resumePhysics()
	 * @see #rendering
	 */
	public void resumeRendering() {
		rendering = true;
	}

	/**
	 * The time of the day stored from 0 to 15000. (From 12:00 AM day one, to
	 * 12:00 AM day two.)
	 */
	public short time = 0;

	/**
	 * This boolean determines whether the game is running or not. Changing it
	 * to false will kill the game loop thus calling the {@link #dispose()}
	 * chain to run. (The Ash object will call its dispose method when the game
	 * loop stops because the Timer (which was hogging the thread with the game
	 * loop) will let the thread go. The dispose method in Ash will call the
	 * dispose method in other objects, which will call the dispose method in
	 * their objects, spreading out like a tree. This is the mentioned 'dispose
	 * chain.'
	 */
	private boolean running;

	/**
	 * This constructor creates a new Timer using the specified Ash object as
	 * its parent.
	 * 
	 * @param instance
	 *            The instance of Ash that is currently running.
	 */
	public Timer(Ash instance) {
		this.instance = instance;
	}

	/**
	 * This method is called when the Timer is ready to be disposed of and the
	 * game is closing.
	 */
	public void dispose() {
		// TODO Dispose of Timer.
	}

	/**
	 * This method will return Ash object which is the parent of this Timer.
	 * (The Ash object which is currently running.)
	 * 
	 * @return The Ash object which is the parent of this Timer.
	 */
	public Ash getInstance() {
		return instance;
	}

	/**
	 * This method is called when the program is loading up. It loads up any
	 * data that this class needs to run.
	 */
	public void initialize() {
		// TODO Load up time from the save.

	}

	/**
	 * This is the game loop. It calls the {@link #instance}'s
	 * {@link Ash#onTick(boolean, boolean)} method which then goes down a chain
	 * and executes other onTick methods. It passes in whether or not to run
	 * physics and render to the screen to its {@link #instance}'s onTick
	 * method.
	 */
	private void loop() {
		while (running)
			instance.onTick(physics, rendering);

	}

	public void start() {

		running = true;
		loop();
	}

	public void stop() {
		running = false;
	}
}
