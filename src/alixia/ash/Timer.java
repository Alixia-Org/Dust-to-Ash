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
	void dispose() {
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

	public void initialize() {
		// TODO Load up time from the save.

	}

	private void loop() {
		while (running) {
			instance.onTick();
		}

	}

	void start() {

		running = true;
		loop();
	}

	void stop() {
		running = false;
	}
}
