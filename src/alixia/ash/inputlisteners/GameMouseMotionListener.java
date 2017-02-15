package alixia.ash.inputlisteners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import alixia.ash.Ash;

public class GameMouseMotionListener implements MouseMotionListener {

	private final Ash instance;

	public GameMouseMotionListener(Ash instance) {
		this.instance = instance;
	}

	public Ash getInstance() {
		return instance;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		instance.mouseDragged(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		instance.mouseMoved(e);
	}

}
