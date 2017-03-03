package alixia.ash;

import java.awt.Graphics;

import javax.swing.JFrame;

public interface Renderable {
	void render(Graphics graphics, JFrame observer);
}
