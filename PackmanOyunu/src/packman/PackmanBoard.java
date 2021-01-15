package packman;

import java.awt.Color;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PackmanBoard extends JPanel implements ActionListener {
	private int row = 0;
	private int col = 0;
	private int rowCount = 13;
	private int colCount = 11;
	private int width = 30;
	private int height = 30;
	private final int DELAY = 100;
	private final int packman_X = 25;
	private final int packman_Y = 25;
	private final int B_WIDTH = 328;
	private final int B_HEIGHT = 388;
	private boolean ingame;
	private Timer timer;
	private Packman packman;
	private Canavar ghost, ghost2, ghost3;
	private List<Point> points;
	

	public PackmanBoard() {
		initBoard();
	}
	public void initBoard() {
		timer = new Timer(DELAY, this);
		timer.start();
		addKeyListener(new TAdapter());
		setFocusable(true);
		ingame = true;
		setBackground(Color.gray);
		setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
		packman = new Packman(120,180);
		ghost = new Canavar(300, 360);
		ghost2 = new Canavar(0, 360);
		ghost3 = new Canavar(240, 240);
		initPoint();
		
	}
	private final int[][] pos = { 
			{12,12},{12,42},{12,72},{12,102},{12,132},{12,162},{12,192},{12,222},{12,252},{12,282},
			{12,312},{12,342},{12,372},{42,12},{42,42},{42,72},{42,102},{42,132},{42,162},{42,192},
			{42,222},{42,252},{42,282},{42,312},{42,342},{42,372},{72,12},{72,42},{72,72},{72,102},
			{72,132},{72,162},{72,192},{72,222},{72,252},{72,282},{72,312},{72,342},{72,372},{102,12},
			{102,42},{102,72},{102,102},{102,132},{102,162},{102,192},{102,222},{102,252},{102,282},{102,312},
			{102,342},{102,372},{132,12},{132,42},{132,72},{132,102},{132,132},{132,162},{132,192},{132,222},
			{132,252},{132,282},{132,312},{132,342},{132,372},{162,12},{162,42},{162,72},{162,102},{162,132},
			{162,162},{162,192},{162,222},{162,252},{162,282},{162,312},{162,342},{162,372},{192,12},{192,42},
			{192,72},{192,102},{192,132},{192,162},{192,192},{192,222},{192,252},{192,282},{192,312},{192,342},
			{192,372},{222,12},{222,42},{222,72},{222,102},{222,132},{222,162},{222,192},{222,222},{222,252},
			{222,282},{222,312},{222,342},{222,372},{252,12},{252,42},{252,72},{252,102},{252,132},{252,162},
			{252,192},{252,222},{252,252},{252,282},{252,312},{252,342},{252,372},{282,12},{282,42},{282,72},
			{282,102},{282,132},{282,162},{282,192},{282,222},{282,252},{282,282},{282,312},{282,342},{282,372},
			{312,12},{312,42},{312,72},{312,102},{312,132},{312,162},{312,192},{312,222},{312,252},{312,282},{312,312},{312,342},{312,372}

	        
	        
	    };
	public void initPoint() {
        
        points = new ArrayList<>();

        for (int[] p : pos) {
            points.add(new Point(p[0], p[1]));
        }
    }
	public int[][] optionallevelData() {
		int levelData[][] = { 
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0 },
				{ 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0 }, 
				{ 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0 },
				{ 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0 }, 
				{ 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0 },
				{ 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 }, 
				{ 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0 },
				{ 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0 }, 
				{ 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0 },
				{ 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0 }, 
				{ 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }

		};
		return levelData;

	}
	
	
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (ingame) {

        	drawObjects(g);

        } else {
        	

            drawGameOver(g);
        }

        Toolkit.getDefaultToolkit().sync();
    }
	public void drawObjects(Graphics g) {
		
			int[][] levelData = optionallevelData();
			for (row = 0; row < rowCount; row++) {
				for (col = 0; col < colCount; col++) {
					if (levelData[row][col] == 1) {
						g.setColor(Color.black);
						g.fillRect(col * 30, row * 30, width, height);
					}
				}
			}
			 for (Point point : points) {
		            if (point.isTemp()) {
		                g.drawImage(point.getImage(), point.getX(), point.getY(),6, 6, this);
		            }
			 }
			
			if (packman.isTemp()){
				g.drawImage(packman.getImage(), packman.getX(), packman.getY(), packman_X, packman_Y, this);
			}
			if (ghost.isTemp()){
				g.drawImage(ghost.getImage(), ghost.getX(), ghost.getY(), width, height, this);
			}
			if (ghost2.isTemp()){
				g.drawImage(ghost2.getImage(), ghost2.getX(), ghost2.getY(), width, height, this);
			}
			if (ghost3.isTemp()){
				g.drawImage(ghost3.getImage(), ghost3.getX(), ghost3.getY(), width, height, this);                    
			}
            
            
        } 
		
	
	
	

	private void drawGameOver(Graphics g) {

		String message = "GAME OVER!";
		Font small = new Font("Helvetica", Font.BOLD, 20);
		FontMetrics fm = getFontMetrics(small);

		g.setColor(Color.red);
		setBackground(Color.blue);
		g.setFont(small);
		g.drawString(message, (B_WIDTH - fm.stringWidth(message)) / 2, B_HEIGHT / 2);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		inGame();
		updatepackman();
		updateHayalet();
		updatePoint();
		checkpackman();
		Wait();
		repaint();
		
	}
	private void inGame() {

		if (!ingame) {
			timer.stop();
		}
	}
	
	private void updatepackman() {
		if (packman.isTemp()) {
			packman.hareket();
		}
	}
	private void updateHayalet() {
		

		if (ghost.isTemp()) {
			ghost.hareket();
			ghost3.hareket2();
			ghost2.hareket3();
		}
	}
	private void updatePoint() {

        if (points.isEmpty()) {

            ingame = false;
            return;
        }

        for (int i = 0; i < points.size(); i++) {

            Point a = points.get(i);
        }
    }

public void checkpackman() {
		Rectangle r3 = packman.getBounds();
		Rectangle r2 = ghost.getBounds();
		Rectangle r4 = ghost2.getBounds();
		Rectangle r5 = ghost3 .getBounds();

		if (r3.intersects(r2)||r3.intersects(r4)||r3.intersects(r5)) {

			ingame=false;
		}

	   for (Point point : points) {
	            
	            Rectangle r1 = point.getBounds();

	            if (r3.intersects(r1)) {
	                
	                point.setTemp(false);
	            }
	        }
}

	public void Wait() {
		if (packman.x >= B_WIDTH - packman_X)
			packman.x = B_WIDTH - packman_X;
		if (packman.y >= B_HEIGHT - packman_Y)
			packman.y = B_HEIGHT - packman_Y;
		if (packman.x <= 0)
			packman.x = 0;
		if (packman.y <= 0)
			packman.y = 0;

	}
	private class TAdapter extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			packman.keyReleased(e);
		}

		@Override
		public void keyPressed(KeyEvent e) {
			packman.keyPressed(e);

		}

	}

}
