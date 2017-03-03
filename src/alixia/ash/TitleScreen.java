package alixia.ash;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class TitleScreen implements Tickable, Renderable {
	private final Ash instance;
	private Timer timer;

	public TitleScreen(Ash instance) {
		this.instance = instance;
	}

	public void initialize() {
		timer = new Timer(this);
		timer.initialize();
	}

	public void start() {
		timer.start();
	}

	public void mouseClicked(MouseEvent event) {

	}

	public void dispose() {
	}

	@Override
	public void onTick() {
		instance.getWindow().onTick(true);
	}

	@Override
	public void render(Graphics graphics, JFrame observer) {
		
	}
}
