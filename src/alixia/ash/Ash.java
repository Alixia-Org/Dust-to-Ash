package alixia.ash;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.ImageObserver;
import java.util.Arrays;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public final class Ash {

	private static final Image GRASSLANDS_BACKGROUND = getGraphic("backgrounds/grasslands/background.png");
	private static final Image SUN[] = { getGraphic("backgrounds/grasslands/sun_0.png"),
			getGraphic("backgrounds/grasslands/sun_1.png") };
	private boolean mouseLeft, mouseRight, mouseTop, mouseBottom;

	private boolean running;
	public static Random rand = new Random();
	public static short time = 0;
	public double posX = 0;
	public float posY = 0f;

	public static Ash currentInstance;

	public static strictfp short getCurrentBackground() {
		if (currentInstance.posX / 250 > currentInstance.biomes.length)
			return 0;
		return 0;
		// return (short) (currentInstance.biomes[(int)
		// Math.floor(currentInstance.posX / 250)] == 0 ? 0 : 1);
	}

	private short[] biomes = new short[50];
	{
		for (int i = 0; i < biomes.length; i++)
			if (rand.nextBoolean())
				biomes[i] = 0;
			else
				biomes[i] = 1;
	}

	private JFrame frame;

	public Ash() {
	}

	public static void launch() {
		try {
			currentInstance.start();
		} catch (Exception e) {
			System.err.println(
					"Failed to load up Ash. If there is a null pointer exception, it's HIGHLY likely that a 'current instance' wasn't set using the Ash.setInstance() method.");
		}
	}

	public static Image getGraphic(String path) {
		return new ImageIcon(Ash.class.getResource("graphics/" + path)).getImage();
	}

	public static void setCurrentInstance(Ash instance) {
		if (!(currentInstance == null) && currentInstance.running)
			System.err.println("There is currently a running instance of Ash running...");
		else
			currentInstance = instance;
	}

	public void setCurrentInstance() {
		setCurrentInstance(this);
	}

	public static void main(String[] args) {
		Ash ash = new Ash();
		ash.setCurrentInstance();
		ash.start();

	}

	private void start() {
		initialize();
		while (running)
			loop();
		dispose();
	}

	private void dispose() {
		GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(null);
	}

	private void loop() {
		time++;
		if (time >= 15000)
			time = 0;
		frame.repaint();
		if (mouseLeft)
			moveCam(1);
		if(mouseRight)
			moveCam(-1);
		try {
			Thread.sleep(1000 / 60);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void render(Graphics g, ImageObserver o) {
		renderBackground(g, o);
	}

	private void renderBackground(Graphics graphics, ImageObserver o) {
		graphics.setColor(Color.CYAN);
		graphics.fillRect(0, 0, 1920, 1080);
		if (getCurrentBackground() == 0) {
			graphics.drawImage(GRASSLANDS_BACKGROUND, (int) (-50 + posX % 1920), 0, 2020, 1080, o);
			graphics.drawImage(GRASSLANDS_BACKGROUND, (int) (-50 + posX % 1920) - 2020, 0, 2020, 1080, o);
			graphics.drawImage(GRASSLANDS_BACKGROUND, (int) (-50 + posX % 1920) + 2020, 0, 2020, 1080, o);
		}
		if (time % 100 >= 50)
			graphics.drawImage(SUN[0], 0, 0, 200, 200, o);
		if (time % 100 < 50)
			graphics.drawImage(SUN[1], 0, 0, 200, 200, o);
		graphics.dispose();
	}

	private void moveCam(int x) {
		posX += x;
	}

	private void initialize() {
		running = true;

		frame = new JFrame();
		frame.add(new JPanel() {

			/**
			 *
			 */
			private static final long serialVersionUID = 1L;

			protected void paintComponent(Graphics g) {
				render(g, this);
			};

		});
		frame.setUndecorated(true);
		frame.setResizable(false);
		frame.setAlwaysOnTop(true);

		frame.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
					System.exit(0);
			}
		});
		frame.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseMoved(MouseEvent e) {

				if (e.getX() <= 250 && !mouseLeft)
					mouseLeft = true;
				if (e.getX() > 250 && mouseLeft)
					mouseLeft = false;
				
				if (e.getX() >= 1670 && !mouseRight)
					mouseRight = true;
				if (e.getX() < 1670 && mouseRight)
					mouseRight = false;

			}

			@Override
			public void mouseDragged(MouseEvent e) {

			}
		});

		frame.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});

		frame.addMouseWheelListener(new MouseWheelListener() {

			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
			}
		});

		frame.setIgnoreRepaint(true);

		GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(frame);
		// Kill Thread for debugging purposes. Ends game and exists full screen
		// mode in case of anything.
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(5000);
					System.exit(0);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		})
		// .start()
		;
	}

}
