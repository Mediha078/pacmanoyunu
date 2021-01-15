package packman;


import java.awt.Image;

public class Point extends Board {
	public Point(int x, int y) {
		super(x, y);
		initImage(image);
	}
	private void initImage(Image image) {

		pointImage(image);
		getImageDimensions();

	}
	public void pointImage(Image image) {
			loadImage("C:\\Users\\Mediha\\eclipse-workspace\\PackmanOyunu\\src\\packman\\nokta.png");

	}
}

