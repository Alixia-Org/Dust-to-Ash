package alixia.ash;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public abstract class Object {
	public void onKeyTyped(KeyEvent e, Ash instance) {
		
	}

	public void keyPressed(KeyEvent e, Ash instance) {

	}

	public void keyReleased(KeyEvent e, Ash instance) {

	}

	public void mouseClicked(MouseEvent e, Ash instance) {

	}

	public void mousePressed(MouseEvent e, Ash instance) {

	}

	public void mouseReleased(MouseEvent e, Ash instance) {

	}

	public void mouseEntered(MouseEvent e, Ash instance) {

	}

	public void mouseExited(MouseEvent e, Ash instance) {

	}

	public void mouseDragged(MouseEvent e, Ash instance) {

	}

	public void mouseMoved(MouseEvent e, Ash instance) {

	}

	public void mouseWheelMoved(MouseWheelEvent e, Ash instance) {

	}
	public abstract void onTick(Ash instance);
}
