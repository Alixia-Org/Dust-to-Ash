package alixia.ash;

public class Timer {

	private final Ash instance;

	public Timer(Ash instance) {
		this.instance = instance;
	}

	void start() {

		running = true;
		loop();
	}

	private void loop() {
		while (running) {
			instance.onTick();
		}

	}

	void dispose() {
		running = false;
	}

	public Ash getInstance() {
		return instance;
	}

	public short time = 0;

	private boolean running;

	public void initialize() {
		// TODO Load up time from the save.

	}
}
