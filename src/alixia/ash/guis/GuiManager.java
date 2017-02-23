package alixia.ash.guis;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class GuiManager {

	private GraphicalUserInterface currentGui;

	public void onRender(Graphics graphics, JFrame frame) {
		if (currentGui != null)
			currentGui.onRender(graphics, frame);
	}

	public void setGui(GraphicalUserInterface gui) {
		currentGui = gui;
	}

	public GraphicalUserInterface getGui() {
		return currentGui;
	}

	public void onClick(MouseEvent event) {
		currentGui.onClick(event);
	}

}
