package alixia.ash.inputlisteners;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import alixia.ash.Ash;

public class GameMouseWheelListener implements MouseWheelListener {

	private final Ash instance;

	public Ash getInstance() {
		return instance;
	}

	public GameMouseWheelListener(Ash instance) {
		this.instance = instance;
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		instance.mouseWheelMoved(e);
	}

}
