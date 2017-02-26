package alixia.ash.resources;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public abstract class Button {
	private int posX, posY, length, width;
	private boolean exists;
	private Image texture;

	public Button(int posX, int posY, int length, int width, boolean turnOn, Image texture) {
		this.posX = posX;
		this.posY = posY;
		this.length = length;
		this.width = width;
		this.texture = texture;
		exists = turnOn;
	}

	public void onClick(MouseEvent event) {
		if ((event.getX() > posX && event.getX() < posX + length)
				&& (event.getY() > posY && event.getY() < posY + width))
			clicked();
	}

	public abstract void clicked();

	public void onRender(Graphics graphics, JFrame frame) {
		graphics.drawImage(texture, posX, posY, frame);
	}
}
