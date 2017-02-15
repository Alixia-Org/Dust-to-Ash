package alixia.ash.inputlisteners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import alixia.ash.Ash;

public class GameMouseListener implements MouseListener {

	private final Ash instance;

	public GameMouseListener(Ash instance) {
		this.instance = instance;
	}

	public Ash getInstance() {
		return instance;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		instance.onMouseClicked(e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		instance.onMouseEntered(e);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		instance.onMouseExited(e);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		instance.onMousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		instance.onMouseReleased(e);
	}

}
