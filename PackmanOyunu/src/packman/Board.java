package packman;

import java.awt.Image;

import java.awt.Rectangle;

import javax.swing.ImageIcon;



public class Board {
	protected int x;
	protected int y;
	protected int width;
    protected int height;
	protected boolean temp ;
	protected Image image;

	
	public Board(int x, int y){
		this.x=x;
		this.y = y;
		temp = true;
	}
	protected void getImageDimensions() {

        width = image.getWidth(null);
        height = image.getHeight(null);
    }
	protected void loadImage(String imageName) {

        ImageIcon ii = new ImageIcon(imageName);
        image = ii.getImage();
        
    }

    public Image getImage(){
        return image;
    } 
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isTemp() {
        return temp;
    }

    public void setTemp(Boolean temp) {
        this.temp = temp;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 16, 16);
    }

	

	

}

