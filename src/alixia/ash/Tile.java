package alixia.ash;

import java.awt.Image;

public class Tile extends Object{

	private int x, y;
	private Image icon;

	public Tile(Image icon, int x, int y) {
		this.icon = icon;
		this.x = x;
		this.y = y;
	}

	public Image getIcon() {
		return icon;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	public void onTick(Ash instance){
		
	}

	public void onTick() {
		
	}
}
