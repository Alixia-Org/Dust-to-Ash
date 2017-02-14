package alixia.ash.inputlisteners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import alixia.ash.Ash;

public class GameKeyListener implements KeyListener {

	private final Ash instance;

	public GameKeyListener(Ash instance) {
		this.instance = instance;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public Ash getInstance() {
		return instance;
	}

}
