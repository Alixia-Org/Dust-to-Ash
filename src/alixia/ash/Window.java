package alixia.ash;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.event.InputMethodListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowStateListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import alixia.ash.inputlisteners.GameKeyListener;
import alixia.ash.inputlisteners.GameMouseListener;
import alixia.ash.inputlisteners.GameMouseMotionListener;
import alixia.ash.inputlisteners.GameMouseWheelListener;

public class Window {

	private final Ash instance;
	private Renderable object;
	private JFrame frame = new JFrame("Dust to Ash...");
	@SuppressWarnings("serial")
	private JPanel panel = new JPanel() {
		public void paintComponent(Graphics g) {
			object.render(g, frame);
		};
	};

	public void setObject(Renderable object) {
		this.object = object;
	}

	public Renderable getObject() {
		return object;
	}

	private float yPos = 0f;

	private double xPos = 0;

	public Window(Ash instance) {
		this.instance = instance;
		initFrame();
	}

	public void moveCameraOnX(double d) {
		moveCamera(d, 0);
	}

	public void moveCameraOnY(int distance) {
		moveCamera(0, distance);
	}

	public void addInputMethodListener(InputMethodListener arg0) {
		frame.addInputMethodListener(arg0);
	}

	public void addKeyListener(KeyListener arg0) {
		frame.addKeyListener(arg0);
	}

	public void addMouseListener(MouseListener arg0) {
		frame.addMouseListener(arg0);
	}

	public void addMouseMotionListener(MouseMotionListener arg0) {
		frame.addMouseMotionListener(arg0);
	}

	public void addMouseWheelListener(MouseWheelListener arg0) {
		frame.addMouseWheelListener(arg0);
	}

	public void addWindowFocusListener(WindowFocusListener arg0) {
		frame.addWindowFocusListener(arg0);
	}

	public void addWindowStateListener(WindowStateListener arg0) {
		frame.addWindowStateListener(arg0);
	}

	public boolean contains(int arg0, int arg1) {
		return frame.contains(arg0, arg1);
	}

	public boolean contains(Point arg0) {
		return frame.contains(arg0);
	}

	public void dispose() {
		frame.setVisible(false);
		frame.dispose();
	}

	public double getCameraXPosition() {
		return xPos;
	}

	public float getCameraYPosition() {
		return yPos;
	}

	public int getHeight() {
		return frame.getHeight();
	}

	public Dimension getMaximumSize() {
		return frame.getMaximumSize();
	}

	public Point getMousePosition() throws HeadlessException {
		return frame.getMousePosition();
	}

	public Point getMousePosition(boolean arg0) throws HeadlessException {
		return frame.getMousePosition(arg0);
	}

	public String getName() {
		return frame.getName();
	}

	public Dimension getPreferredSize() {
		return frame.getPreferredSize();
	}

	public Dimension getSize(Dimension arg0) {
		return frame.getSize(arg0);
	}

	public String getTitle() {
		return frame.getTitle();
	}

	public int getWidth() {
		return frame.getWidth();
	}

	public int getWindowHeight() {
		return frame.getHeight();
	}

	public int getWindowWidth() {
		return frame.getWidth();
	}

	public int getX() {
		return frame.getX();
	}

	public int getY() {
		return frame.getY();
	}

	private void initFrame() {
		frame.addKeyListener(new GameKeyListener(instance));

		frame.addMouseMotionListener(new GameMouseMotionListener(instance));
		frame.addMouseListener(new GameMouseListener(instance));
		frame.addMouseWheelListener(new GameMouseWheelListener(instance));

		frame.add(panel);

		frame.setResizable(false);
	}

	public void initialize() {
		initFrame();
	}

	public boolean isShowing() {
		return frame.isShowing();
	}

	public void moveCamera(double d, float yPos) {
		this.xPos += d;
		this.yPos += yPos;
	}

	public void onTick(boolean render) {
		if (render)
			panel.repaint();
	}

	public void setName(String arg0) {
		frame.setName(arg0);
	}

	public void setPreferredSize(Dimension arg0) {
		frame.setPreferredSize(arg0);
	}

	public void setSize(Dimension arg0) {
		frame.setSize(arg0);
	}

	public void setTitle(String arg0) {
		frame.setTitle(arg0);
	}

	public void start() {
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		if (gd.isFullScreenSupported()) {
			frame.setIgnoreRepaint(true);
			frame.setUndecorated(true);
			frame.setAlwaysOnTop(true);
			gd.setFullScreenWindow(frame);
		} else {
			frame.setSize(gd.getDisplayMode().getWidth(), gd.getDisplayMode().getHeight());
			frame.setUndecorated(true);
			frame.setAlwaysOnTop(true);
			frame.setVisible(true);
		}

	}

	public void toBack() {
		frame.toBack();
	}

	public void toFront() {
		frame.toFront();
	}

}
