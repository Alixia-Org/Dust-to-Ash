package alixia.ash.resources;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class Button {
	private int posX, posY;
	private boolean exists;

	public Button(int posX, int posY, boolean turnOn) {
		this.posX = posX;
		this.posY = posY;
		exists = turnOn;
	}

	public void onClick(MouseEvent event){

	}

	public void onRender(Graphics graphics, JFrame frame){

	}
}
