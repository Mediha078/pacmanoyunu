package packman;

import java.awt.Image;

public class Canavar extends Board {
	public int angle;
	public double dx = 5, dy = 5;

	public Canavar(int x, int y) {
		super(x, y);
		initImage(image);
	}
	private void initImage(Image image) {

		hayaletGonder(image);
		getImageDimensions();
	}
	public void hareket() {

		if (x == 0 && y <= 360)
			y -= dy;
		if (y == 0 && x <= 300)
			x += dx;
		if (x > 0 && y >= 360)
			x -= dx;
		if (x >= 300 && y < 360)
			y += dy;
	}
	public void hareket2() {

		if (x == 60 && y <= 240)
			y -= dy;
		if (y == 120 && x <= 240)
			x += dx;
		if (x > 60 && y >= 240)
			x -= dx;
		if (x >= 240 && y < 240)
			y += dy;
	}
	public void hareket3() {
		
		if (x == 0 && y <= 360)
			y -= dy;
		if (x <= 60 && y == 0)
			x += dx;
		if (x == 60&& y < 60)
			y += dy;
		if (x>30 && x <=120 && y == 60)
			x += dx;
		if (x == 120&& y < 120)
			y += dy;
		if (x >= 120&&x <= 240 && y ==120)
			x += dx;
		if (x == 240&& y < 240)
			y += dy;
		if (x > 60 && y == 240)
			x -= dx;
		if (x ==60 && y <= 360&&y>=180)
			y -= dy;
		if (x >0&& y == 180&&x<=120)
			x -= dx;
	}
	public void hayaletGonder(Image image) {
		loadImage("C:\\Users\\Mediha\\eclipse-workspace\\PackmanOyunu\\src\\packman\\packman5canavar.png");
	}

}

