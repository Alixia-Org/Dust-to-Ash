package alixia.ash.inputlisteners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import alixia.ash.Ash;

public class GameMouseMotionListener implements MouseMotionListener {

	private final Ash instance;

	public Ash getInstance() {
		return instance;
	}

	public GameMouseMotionListener(Ash instance) {
		this.instance = instance;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
