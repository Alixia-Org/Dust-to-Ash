package alixia.ash.inputlisteners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import alixia.ash.Ash;

public class GameKeyListener implements KeyListener {

	private final Ash instance;

	public GameKeyListener(Ash instance) {
		this.instance = instance;
	}

	public Ash getInstance() {
		return instance;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		instance.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		instance.keyReleased(e);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		instance.onKeyTyped(e);
	}

}
