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
	 * The object that this Timer manages.
	 */
	private final Tickable object;

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

	public Timer(Tickable object) {
		this.object = object;
	}

	/**
	 * This method is called when the Timer is ready to be disposed of and the
	 * game is closing.
	 */
	public void dispose() {
		// TODO Dispose of the Timer... This'll probably save the in-game time
		// and some other stuffz.
	}

	public Tickable getInstance() {
		return object;
	}

	/**
	 * This method is called when the program is loading up. It loads up any
	 * data that this class needs to run.
	 */
	public void initialize() {
		// TODO Load up time from the save.
	}

	private void loop() {
		// Set a random delta value, get the current system time.
		long delta = 0, currTime = System.nanoTime(), prevTime = currTime;
		while (running) {
			// The current system time is set again... yay.....
			currTime = System.nanoTime();
			// The delta is the difference between the previous loop and this
			// loop. Tick 1: They have the same value. Tick 2: currTime is one
			// tick ahead, prevTime has the same value. Tick 3: currTime is 2
			// ticks ahead, prevTime is one tick head. Previous time basically
			// lags behind.
			delta = currTime - prevTime;
			// Actually loop

			// If the difference in time between the last loop and this loop is
			// greater than 1/60th of a second, go to the next tick. If not,
			// then rerun the loop. We do this to make sure that we don't loop a
			// bajillion times a second.
			if (delta > 1000000000 / 60) {
				tick();// The tick method actually does stuff.
				prevTime = currTime;// Update the previous time; we finished
									// this tick, so the time when this tick
									// stated will go to prevTime. At the top of
									// this loop, currTime gets changed.
			}
		}

	}

	private void tick() {
		object.onTick();
	}

	public void start() {

		running = true;
		loop();
	}

	public void stop() {
		running = false;
	}
}
