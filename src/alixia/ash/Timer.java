package alixia.ash;

public class Timer {

	private final Ash instance;

	public short time = 0;

	private boolean running;

	public Timer(Ash instance) {
		this.instance = instance;
	}

	void dispose() {
	}

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
