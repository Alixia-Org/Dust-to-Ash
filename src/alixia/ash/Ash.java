package alixia.ash;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public final class Ash {

	public boolean isFirstLaunch() {
		return true;

	}

	public void start() {

		initialize();
		dispose();
	}

	private final Window window = new Window(this);
	private final Timer timer = new Timer(this);
	private final World world = new World(this);

	public Window getWindow() {
		return window;
	}

	public void onTick() {
		world.onTick();
		window.onTick();

	}

	void onRender(Graphics graphics, JFrame observer) {
		// TODO Run onRender code.
	}

	public Timer getTimer() {
		return timer;
	}

	private void dispose() {
		timer.dispose();
		window.dispose();
		world.dispose();
	}

	private void initialize() {
		window.initialize();
		world.initialize();
		timer.initialize();

		timer.start();
	}

	public static Image getGraphic(String path) {
		return new ImageIcon(Ash.class.getResource("graphics/" + path)).getImage();
	}

	public static void main(String[] args) {
		Ash ash = new Ash();
		ash.start();

	}

	public void onKeyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub

	}

}
