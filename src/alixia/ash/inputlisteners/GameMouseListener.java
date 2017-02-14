package alixia.ash.inputlisteners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import alixia.ash.Ash;

public class GameMouseListener implements MouseListener {

	private final Ash instance;

	public GameMouseListener(Ash instance) {
		this.instance = instance;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		instance.mouseClicked(e);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		instance.mousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		instance.mouseReleased(e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		instance.mouseEntered(e);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		instance.mouseExited(e);
	}

	public Ash getInstance() {
		return instance;
	}

}
