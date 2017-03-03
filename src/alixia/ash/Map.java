package alixia.ash;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.JFrame;

import sun.reflect.generics.tree.IntSignature;

/**
 * This class is used to store the physical world and the objects in it.
 *
 * @author Zeale
 *
 */
public class Map {

	/**
	 * This enum contains a list of the different areas in the game.
	 *
	 * @author Zeale
	 *
	 */
	public static enum Type {
		// These are basically areas in the game that we plan on making.
		/**
		 * The Overworld area is the basic area that you spawn in. This is the
		 * island you start on.
		 */
		OVERWORLD,
		/**
		 * The Underworld is one of the areas of the game that contain a boss
		 * battle. The player won't be able to build in the Underworld until
		 * they defeat the boss there.
		 */
		UNDERWORLD,
		/**
		 * Hell is another area of the game that has a boss. The player won't be
		 * able to build there until they defeat the boss.
		 */
		HELL,
		/**
		 * The moon is an area of the game that can be found a few ways. It
		 * doesn't have a boss and you are able to build on it by default.
		 */
		MOON,
		/**
		 * The Ocean is the very edge of the Overworld on both sides. It
		 * contains extremely tough mobs and is a very dangerous area. The
		 * player can explore it with squads or using an Exploration Orb, but
		 * can't build there.
		 */
		OCEAN;
	}

	/**
	 * This is a 2D array that stores all the tiles in an area.
	 */
	private Tile[][] tiles;


	/**
	 * This is an array that stores whether or not each chunk has been loaded
	 * already.
	 */
	private boolean[] loadedChunks;
	/**
	 * This is a reference to the top-of-the-hierarchy, <code>Ash</code> object.
	 */
	private final Ash instance;
	/**
	 * This variable stores the type of area that this is.
	 */
	private Type type;

	/**
	 * This constructor will generate a map depending on the type it is. If this
	 * is not the world's first launch and this Map has been loaded before, the
	 * map is generated from a save file.
	 *
	 * @param instance
	 *            The Ash instance which is currently running.
	 * @param mapType
	 *            The {@link Type} of map this Map is.
	 */
	public Map(Ash instance, Type mapType) {
		// Set values to these fields.
		this.instance = instance;
		type = mapType;

		// Decide what values to give the arrays depending on the map type.
		switch (mapType) {
		default:
			tiles = new Tile[5000][20];
			loadedChunks = new boolean[100];
			break;
		case UNDERWORLD:
			tiles = new Tile[1000][20];
			loadedChunks = new boolean[20];
		case HELL:
			tiles = new Tile[800][20];
			loadedChunks = new boolean[16];
		case MOON:
			tiles = new Tile[400][20];
			loadedChunks = new boolean[8];
		case OCEAN:
			tiles = new Tile[1500][20];
			loadedChunks = new boolean[30];
		}

	}

	/**
	 * This method is called when the game is closing. It saves the map and
	 * finishes anything that needs to be finished.
	 */
	public void dispose() {
		// TODO Save map and dispose of anythinig.
	}

	/**
	 * This method returns the instance of Ash that owns this Map.
	 *
	 * @return The Ash object that is currently running.
	 */
	public Ash getInstance() {
		return instance;
	}

	/**
	 * This method is called when this map needs to be loaded up.
	 */
	public void initialize() {
		// Load the map if it has already been generated.
		loadMap();
	}

	/**
	 * This method is a private map loading helper. If the map has not already
	 * been generated, its save file is created and its loaded up as needed.
	 */
	private void loadMap() {

		Image dirt = Ash.getGraphic("tiles/dirt/dirt_d.png");
		Image grass = Ash.getGraphic("tiles/dirt/grass.png");

		// tiles rendering & initialization test.
		for (int i = -tiles.length / 2; i < tiles.length / 2; i++) {
			Tile[] arr = new Tile[20];
			arr[0] = new Tile(grass, i, 0, instance);
			for (int i0 = 1; i0 < arr.length; i0++) {

				arr[i0] = new Tile(dirt, i, i0, instance);
			}
			tiles[i + tiles.length / 2] = arr;
		}
		// Tiles "has area been loaded" initialization test.
		for (int i = 0; i < loadedChunks.length; i++)
			loadedChunks[i] = true;

		// TODO Load up data from the save if it exists.
	}

	private Image background = Ash.getGraphic("backgrounds/grasslands/background.png");

	/**
	 * This method is called once every time the game is scheduled to render. It
	 * renders whatever this Map needs it to if necessary.
	 *
	 * @param graphics
	 *            The {@link Graphics} object that is used to draw directly to
	 *            the screen.
	 * @param observer
	 *            The JFrame that is displayed to the user. Screen size can be
	 *            retrieved from this along with some other things, and it can
	 *            be passed to any of the Graphics object's drawImage functions
	 *            as an {@link ImageObserver}.
	 */
	public void onRender(Graphics graphics, JFrame observer) {
		if (type == Type.OVERWORLD) {
			graphics.fillRect(0, 0, (int) (1920 * instance.SCREEN_WIDTH_RATIO),
					(int) (1080 * instance.SCREEN_HEIGHT_RATIO));

			// Manage Backgrounds
			graphics.drawImage(background,
					(int) Math.round(-instance.getWindow().getCameraXPosition() % (1920 * instance.SCREEN_WIDTH_RATIO)),
					(int) Math.round(-instance.getWindow().getCameraYPosition() % (1080 * instance.SCREEN_HEIGHT_RATIO)),
					observer.getWidth(), observer.getHeight(), observer);
			graphics.drawImage(background,
					(int) Math.round(1920 * instance.SCREEN_WIDTH_RATIO
							- instance.getWindow().getCameraXPosition() % (1920 * instance.SCREEN_WIDTH_RATIO)),
					(int) Math.round(-instance.getWindow().getCameraYPosition() % (1080 * instance.SCREEN_HEIGHT_RATIO)),
					observer.getWidth(), observer.getHeight(), observer);
			graphics.drawImage(background,
					(int) Math.round(-1920 * instance.SCREEN_WIDTH_RATIO
							- instance.getWindow().getCameraXPosition() % (1920 * instance.SCREEN_WIDTH_RATIO)),
					(int) Math.round(-instance.getWindow().getCameraYPosition() % (1080 * instance.SCREEN_HEIGHT_RATIO)),
					observer.getWidth(), observer.getHeight(), observer);
		}
		for (Tile[] array : tiles)
			for (Tile t : array)
				if (t != null)
					t.onRender(graphics, observer);
	}

	/**
	 * This method is called whenever the game 'Ticks.' For more information on
	 * ticking, see the {@link Timer} class. In manages game time, the game
	 * loop, and ticking.<br>
	 * <br>
	 * This method runs whatever it needs to each tick and then calls the tick
	 * method of each game object that it owns.
	 */
	public void onTick() {

	}
}
