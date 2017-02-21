package alixia.ash.guis;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;

import alixia.ash.Ash;
import alixia.ash.guis.nodes.Node;

public class GraphicalUserInterface {
	private Ash ash;

	private ArrayList<Node> nodes = new ArrayList<>();

	public GraphicalUserInterface(Ash ash) {
		this.ash = ash;
	}

	public void onRender(Graphics graphics, JFrame frame) {
		// TODO Render
	}

	public void onClick() {

	}

}
