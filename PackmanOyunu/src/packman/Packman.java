package packman;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;


public class Packman extends Board {
	private int x2 = 30;
	private int y2 = 30;
	public int angle;
	private List<Point> points;
	public Packman(int x, int y) {
		super(x, y);
		initImage(image);
		points= new ArrayList<>();

	}

	private void initImage(Image image) {

		packmanImage(image);
		getImageDimensions();

	}

	public void hareket() {
		packmanImage(image);
	}
	public List<Point> getPoints() {
        return points;
    }

	public void packmanImage(Image image) {
		if (angle == 0)
			loadImage("C:\\Users\\Mediha\\eclipse-workspace\\PackmanOyunu\\src\\packman\\packman1sag.png");
		if (angle == 90)
			loadImage("C:\\Users\\Mediha\\eclipse-workspace\\PackmanOyunu\\src\\packman\\packman2asagi.png");
		if (angle == 180)
			loadImage("C:\\Users\\Mediha\\eclipse-workspace\\PackmanOyunu\\src\\packman\\packman3sol.png");
		if (angle == 270)
			loadImage("C:\\Users\\Mediha\\eclipse-workspace\\PackmanOyunu\\src\\packman\\packman4yukari.png");
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {

		try {
			PackmanBoard level = new PackmanBoard();
			int keyCode = e.getKeyCode();

			int[][] levelData = level.optionallevelData();

			if (keyCode == KeyEvent.VK_LEFT) {

				if (levelData[y / 30][(x / 30) - 1] != 1) {
					x -= x2;
					angle = 180;
				}
			} else if (keyCode == KeyEvent.VK_RIGHT) {

				if (levelData[y / 30][(x / 30) + 1] != 1) {
					x += x2;
					angle = 0;

				}
			} else if (keyCode == KeyEvent.VK_UP) {
				if (levelData[(y / 30) - 1][x / 30] != 1) {
					y -= y2;
					angle = 270;

				}
			} else if (keyCode == KeyEvent.VK_DOWN) {

				if (levelData[(y / 30) + 1][x / 30] != 1) {
					y += y2;
					angle = 90;

				}

			}

		} catch (Exception e2) {
		}
	}

	public void keyReleased(KeyEvent e) {
	}

}
