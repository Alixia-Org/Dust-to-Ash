package alixia.ash;

import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;

import alixia.ash.inputlisteners.GameKeyListener;
import alixia.ash.inputlisteners.GameMouseListener;
import alixia.ash.inputlisteners.GameMouseMotionListener;
import alixia.ash.inputlisteners.GameMouseWheelListener;

public class Window {

	private final Ash instance;
	@SuppressWarnings("serial")
	private JFrame frame = new JFrame("Dust to Ash...") {
		public void paintComponents(Graphics g) {
			instance.onRender(g, frame);
		};
	};
	private JPanel panel = new JPanel();

	void dispose() {
		// TODO Auto-generated method stub
	}

	void initialize() {
		initFrame();
	}

	void start() {
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		if (gd.isFullScreenSupported()) {
			frame.setIgnoreRepaint(true);
			gd.setFullScreenWindow(frame);
		} else {
			frame.setSize(gd.getDisplayMode().getWidth(), gd.getDisplayMode().getHeight());
			frame.setUndecorated(true);
		}

	}

	void onTick() {
		frame.repaint();
	}

	public Window(Ash instance) {
		this.instance = instance;
		initFrame();
	}

	private void initFrame() {
		frame.addKeyListener(new GameKeyListener(instance));

		frame.addMouseMotionListener(new GameMouseMotionListener(instance));
		frame.addMouseListener(new GameMouseListener(instance));
		frame.addMouseWheelListener(new GameMouseWheelListener(instance));

		frame.add(panel);
	}

	private float yPos = 0f;
	private int xPos = 0;

	public void moveCamera(int xPos, float yPos) {
		this.xPos += xPos;
		this.yPos += yPos;
	}

	public float getCameraYPosition() {
		return yPos;
	}

	public int getCameraXPosition() {
		return xPos;
	}

}
